package snake.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;
import snake.game.SnakeGame;

public class GameScreen implements Screen {
    private final SnakeGame _game;
    private final Texture _texture;

    public GameScreen(SnakeGame game) {
        _game = game;
        _texture = new Texture("head.png");
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        _game.batch.begin();
        _game.batch.draw(_texture, Gdx.graphics.getWidth() / 2.0f, (float)Gdx.graphics.getHeight() / 2.0f);
        _game.batch.end();
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
        _texture.dispose();
    }
}
