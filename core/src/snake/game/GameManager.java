package snake.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import snake.game.entities.Board;
import snake.game.entities.Snake;

import static snake.utils.GlobalVariables.*;

public class GameManager {
    private final SpriteBatch _batch;
    private Board _board;
    private Snake _snake;
    private static final float _moveCoolDown = 0.07f;
    private float _timeFromLastMove = 0.0f;
    public GameManager(SpriteBatch batch) {
        _batch = batch;
        init();
    }

    public void init() {
        _board = new Board(WIDTH / CELL_WIDTH, HEIGHT / CELL_HEIGHT);
        _snake = new Snake();
        _board.setSnake(_snake);
    }

    public void step(float delta) {
        _snake.handleKeyboard();
        _timeFromLastMove += delta;
        if(_timeFromLastMove >= _moveCoolDown) {
            _snake.move();
            _timeFromLastMove = 0;
        }
    }

    public void render() {
        _board.render(_batch);
        _snake.render(_batch);
    }
}
