package snake.screens;

import com.badlogic.gdx.Screen;
import snake.SnakeGame;
import snake.game.GameManager;



public class GameScreen implements Screen {
    private final SnakeGame _game;
    private final GameManager _gameManager;

    public GameScreen(SnakeGame game) {
        _game = game;
        _gameManager = new GameManager(_game.batch());
    }
    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        _gameManager.step(delta);

        _game.batch().begin();
        _gameManager.render();
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
