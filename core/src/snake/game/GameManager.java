package snake.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import snake.game.entities.Board;
import snake.game.entities.Snake;
import snake.game.entities.cells.pickup.PointCell;
import snake.utils.CollisionChecker;

import static snake.utils.GlobalVariables.*;

public class GameManager {
    private final SpriteBatch _batch;
    private Board _board;
    private Snake _snake;

    private final PointCell _point = new PointCell(0, 0);
    private static final float _moveCoolDown = 0.07f;
    private boolean _pointCollected = false;
    private float _timeFromLastMove = 0.0f;
    public GameManager(SpriteBatch batch) {
        _batch = batch;
        init();
    }

    public void init() {
        _board = new Board(WIDTH / CELL_WIDTH, HEIGHT / CELL_HEIGHT);
        _snake = new Snake();
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
        if(_pointCollected) {
            _snake.moveAndAddCell();
            setFreeRandomPosition(_point);
            _pointCollected = false;
        } else {
            _snake.move();
        }
        checkCollisions();
    }

    private void checkCollisions() {
        if(CollisionChecker.isCollidingWithSnake(_point, _snake)) {
            _pointCollected = true;
        }
        if(CollisionChecker.isCollidingWithItself(_snake)) {
            gameOver();
        }
    }

    private void gameOver() {
        _snake = new Snake();
        setFreeRandomPosition(_point);
    }

    private void setFreeRandomPosition(PointCell cell) {
        int width = _board.getWidth(), height = _board.getHeight();
        do {
            cell.setPosition(MathUtils.random.nextInt(width), MathUtils.random.nextInt(height));
        }while(CollisionChecker.isCollidingWithSnake(cell, _snake));
    }
    public void render() {
        _board.render(_batch);
        _snake.render(_batch);
        _point.draw(_batch);
    }
}
