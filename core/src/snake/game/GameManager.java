package snake.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import snake.game.entities.Board;
import snake.game.entities.Snake;
import snake.game.entities.cells.pickup.PointCell;
import snake.utils.CollisionChecker;

import static snake.utils.GlobalVariables.*;

public class GameManager {
    private final SpriteBatch _batch;
    private static final int width = WIDTH / CELL_WIDTH, height = HEIGHT / CELL_HEIGHT;
    private static final int initialSnakeSize = 10;
    private Board _board;
    private Snake _snake;

    private final PointCell _point = new PointCell(0, 0);
    private static final float _moveCoolDown = 0.07f;
    private float _timeFromLastMove = 0.0f;
    public GameManager(SpriteBatch batch) {
        _batch = batch;
        init();
    }

    public void init() {
        _board = new Board(width, height);
        _snake = new Snake(initialSnakeSize - 1, height / 2, initialSnakeSize);
        setFreeRandomPosition(_point);
    }

    public void step(float delta) {
        _snake.handleKeyboard();
        _timeFromLastMove += delta;
        if(_timeFromLastMove >= _moveCoolDown) {
            makeAMove();
            _timeFromLastMove = 0;
        }
    }

    private void makeAMove() {
        var lastCellPosition = _snake.move(width, height);
        checkCollisions(lastCellPosition);
    }

    private void checkCollisions(Vector2 lastCellPosition) {
        if(CollisionChecker.isCollidingWithSnake(_point, _snake)) {
            _snake.addCell(lastCellPosition.x, lastCellPosition.y);
            if(_snake.getSize() < height * width) {
                setFreeRandomPosition(_point);
            } else {
                _point.setVisible(false);
            }
        }
        if(CollisionChecker.isCollidingWithItself(_snake)) {
            gameOver();
        }
    }

    private void gameOver() {
        _snake = new Snake(initialSnakeSize - 1, height / 2, initialSnakeSize);
        setFreeRandomPosition(_point);
    }

    private void setFreeRandomPosition(PointCell cell) {
        do {
            cell.setPosition(MathUtils.random.nextInt(width), MathUtils.random.nextInt(height));
        }while(CollisionChecker.isCollidingWithSnake(cell, _snake));
        _point.setVisible(true);
    }
    public void render() {
        _board.render(_batch);
        _snake.render(_batch);
        _point.draw(_batch);
    }
}
