package snake.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import snake.game.controllers.SnakeController;
import snake.game.controllers.SnakeKeyboardController;
import snake.game.entities.Board;
import snake.game.entities.Snake;
import snake.game.entities.cells.pickup.PointCell;
import snake.utils.CollisionChecker;


public class GameManager {
    private final SpriteBatch _batch;
    private static final int boardWidth = 16, boardHeight = 16;
    private static final int initialSnakeSize = 3;
    private final Board _board;
    private Snake _snake;
    private int _score = 0;

    private boolean _gameEnded = false;

    private final PointCell _point = new PointCell(0, 0);
    private static final float _moveCoolDown = 0.07f;
    private float _timeFromLastMove = 0.0f;

    private final SnakeController _snakeController;
    public GameManager(SpriteBatch batch) {
        _batch = batch;
        _board = new Board(boardWidth, boardHeight);
        _snake = new Snake(initialSnakeSize - 1, boardHeight / 2, initialSnakeSize);
        _snakeController = new SnakeKeyboardController(_snake);
        setFreeRandomPosition(_point);
    }

    public void step(float delta) {
        _snakeController.handleInputEvent();
        _timeFromLastMove += delta;
        if(_timeFromLastMove >= _moveCoolDown) {
            makeAMove();
            _timeFromLastMove = 0;
        }
    }

    public boolean gameEnded() {
        return _gameEnded;
    }

    public boolean gameWon() {
        return _snake.getSize() == boardWidth * boardHeight;
    }

    private void makeAMove() {
        if(!_gameEnded) {
            var lastCellPosition = _snake.move(boardWidth, boardHeight);
            handleCollisions(lastCellPosition);
        }
    }

    private void handleCollisions(Vector2 lastCellPosition) {
        if(CollisionChecker.isCollidingWithSnake(_point, _snake)) {
            ++_score;
            _snake.addCell(lastCellPosition.x, lastCellPosition.y);
            if(_snake.getSize() < boardHeight * boardWidth) {
                setFreeRandomPosition(_point);
            } else {
                _point.setVisible(false);
                gameOver();
            }
        }
        if(CollisionChecker.isCollidingWithItself(_snake)) {
            gameOver();
        }
    }

    public void restart() {
        _snake = new Snake(initialSnakeSize - 1, boardHeight / 2, initialSnakeSize);
        _snakeController.setSnake(_snake);
        setFreeRandomPosition(_point);
        _gameEnded = false;
        _score = 0;
    }
    private void gameOver() {
        _gameEnded = true;
    }

    private void setFreeRandomPosition(PointCell cell) {
        do {
            cell.setPosition(MathUtils.random.nextInt(boardWidth), MathUtils.random.nextInt(boardHeight));
        }while(CollisionChecker.isCollidingWithSnake(cell, _snake));
        _point.setVisible(true);
    }
    public int getScore() {
        return _score;
    }
    public void render() {
        _board.render(_batch);
        _snake.render(_batch);
        _point.draw(_batch);
    }
}
