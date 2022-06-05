package snake.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import snake.game.entities.cells.snake.SnakeBodyCell;
import snake.game.entities.cells.snake.SnakeCell;
import snake.game.entities.cells.snake.SnakeHeadCell;
import snake.game.enums.Direction;

import static com.badlogic.gdx.Input.Keys;
import static snake.game.enums.Direction.*;
import static snake.utils.GlobalVariables.CELL_HEIGHT;
import static snake.utils.GlobalVariables.CELL_WIDTH;

public class Snake {
    /*
    head at index 0
     */
    private final Array<SnakeCell> _cells = new Array<>();
    private Direction _direction;
    private Direction _newDirection = null;
    private static final int _initialBodySize = 9, startX = 10, startY = 10;

    public Snake() {
        _cells.add(new SnakeHeadCell(startX, startY));
        for(int i = 1; i <= _initialBodySize; ++i) {
            _cells.add(new SnakeBodyCell(startX - i, startY));
        }
        _direction = Right;
    }

    public void handleKeyboard() {
        if(Gdx.input.isKeyJustPressed(Keys.W)) {
            changeDirection(Up);
        }
        else if(Gdx.input.isKeyJustPressed(Keys.D)) {
            changeDirection(Right);
        }
        else if(Gdx.input.isKeyJustPressed(Keys.S)) {
            changeDirection(Down);
        }
        else if(Gdx.input.isKeyJustPressed(Keys.A)) {
            changeDirection(Left);
        }
    }

    private void changeDirection(Direction direction) {
        if(_newDirection != null || direction == _direction || opposite(_direction, direction)) {
            return;
        }
        _newDirection = direction;
    }
    public void move(int width, int height) {
        width *= CELL_WIDTH;
        height *= CELL_HEIGHT;
        for(int i = _cells.size - 1; i > 0; --i) {
            _cells.get(i).setPosition(_cells.get(i - 1));
        }

        var head = (SnakeHeadCell)_cells.get(0);

        if(_newDirection != null) {
            head.rotate(prev(_newDirection) == _direction);
            _direction = _newDirection;
            _newDirection = null;
        }

        float x = head.getX(), y = head.getY();
        switch (_direction) {
            case Up -> y += CELL_HEIGHT;
            case Right -> x += CELL_WIDTH;
            case Down -> y -= CELL_HEIGHT;
            case Left -> x -= CELL_WIDTH;
        }
        if(x < 0) {
            x = width - CELL_WIDTH;
        } else if(x >= width) {
            x = 0;
        } else if(y < 0) {
            y = height - CELL_HEIGHT;
        } else if(y >= height) {
            y = 0;
        }
        head.setPosition(x, y);
    }

    private void addCell(float px, float py) {
        _cells.add(new SnakeBodyCell(px, py));
    }
    public void moveAndAddCell(int width, int height) {
        var lastCell = _cells.get(_cells.size - 1);
        float lastX = lastCell.getX(), lastY = lastCell.getY();
        move(width, height);
        addCell(lastX, lastY);
    }

    public Array<SnakeCell> getCells() {
        return _cells;
    }
    public void render(SpriteBatch batch) {
        for(var cell : _cells) {
            cell.draw(batch);
        }
    }
}
