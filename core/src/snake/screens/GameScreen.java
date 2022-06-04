package snake.screens;

import com.badlogic.gdx.Screen;
import snake.SnakeGame;
import snake.game.entities.Board;

import static snake.utils.GlobalVariables.*;

public class GameScreen implements Screen {
    private final SnakeGame _game;

    private final Board _board = new Board(WIDTH / CELL_WIDTH, HEIGHT / CELL_HEIGHT);

    public GameScreen(SnakeGame game) {
        _game = game;
    }
    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        _game.batch().begin();
        _board.draw(_game.batch());
        _game.batch().end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
    }
}
