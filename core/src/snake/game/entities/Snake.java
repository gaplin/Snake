package snake.game.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import snake.enums.Direction;
import snake.game.entities.cells.snake.SnakeBodyCell;
import snake.game.entities.cells.snake.SnakeCell;
import snake.game.entities.cells.snake.SnakeHeadCell;
import snake.utils.GlobalVariables;

import static snake.enums.Direction.Right;
import static snake.enums.Direction.prev;
import static snake.utils.GlobalVariables.CELL_SIZE;

public class Snake {
    /*
    head at index 0
     */
    private final Array<SnakeCell> _cells = new Array<>();
    private Direction _direction;
    private Direction _directionIn1Step = null;
    private Direction _directionIn2Steps = null;

    public Snake(int startX, int startY, int initialSize) {
        _cells.add(new SnakeHeadCell(startX, startY));
        for(int i = 1; i <= initialSize - 1; ++i) {
            _cells.add(new SnakeBodyCell(startX - i, startY));
        }
        _direction = Right;
    }
    /*
    returns position of last bodyCell before move
     */
    public Vector2 move(int width, int height) {
        var lastBodyCell = _cells.get(_cells.size - 1);
        var prevPosition = new Vector2(lastBodyCell.getX(), lastBodyCell.getY());

        width *= GlobalVariables.CELL_SIZE;
        height *= CELL_SIZE;

        for(int i = _cells.size - 1; i > 0; --i) {
            _cells.get(i).setPosition(_cells.get(i - 1));
        }

        var head = (SnakeHeadCell)_cells.get(0);

        if(_directionIn1Step != null) {
            head.rotate(prev(_directionIn1Step) == _direction);
            _direction = _directionIn1Step;
            _directionIn1Step = _directionIn2Steps;
            _directionIn2Steps = null;
        }

        float x = head.getX(), y = head.getY();
        switch (_direction) {
            case Up -> y += CELL_SIZE;
            case Right -> x += GlobalVariables.CELL_SIZE;
            case Down -> y -= CELL_SIZE;
            case Left -> x -= GlobalVariables.CELL_SIZE;
        }
        if(x < 0) {
            x = width - GlobalVariables.CELL_SIZE;
        } else if(x >= width) {
            x = 0;
        } else if(y < 0) {
            y = height - CELL_SIZE;
        } else if(y >= height) {
            y = 0;
        }
        head.setPosition(x, y);

        return prevPosition;
    }

    public void addCell(float px, float py) {
        _cells.add(new SnakeBodyCell(px, py));
    }

    public int getSize() {
        return _cells.size;
    }

    public Direction getDirection() {
        return _direction;
    }

    public Direction getDirectionIn1Step() {
        return _directionIn1Step;
    }

    public void setDirectionIn1Step(Direction direction) {
        _directionIn1Step = direction;
    }

    public void setDirectionIn2Steps(Direction direction) {
        _directionIn2Steps = direction;
    }
    public Direction getDirectionIn2Steps() {
        return _directionIn2Steps;
    }

    public void setDead() {
        for(var cell : _cells) {
            cell.setDead();
        }
    }

    public Array<SnakeCell> getCells() {
        return _cells;
    }
    public void render(SpriteBatch batch) {
        for(int i = _cells.size - 1; i >= 0; --i) {
            _cells.get(i).draw(batch);
        }
    }
}
