package snake.screens;

import com.badlogic.gdx.Screen;
import snake.SnakeGame;
import snake.enums.ScreenType;

public class MainMenuScreen implements Screen {

    private final SnakeGame _game;

    public MainMenuScreen(SnakeGame game) {
        _game = game;
    }

    @Override
    public void show() {
        _game.changeScreen(ScreenType.Game);
    }

    @Override
    public void render(float delta) {

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
