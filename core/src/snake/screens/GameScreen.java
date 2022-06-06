package snake.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.ScreenUtils;
import snake.SnakeGame;
import snake.game.GameManager;
import snake.utils.Assets;

import static snake.utils.GlobalVariables.*;


public class GameScreen implements Screen {
    private final SnakeGame _game;
    private final GameManager _gameManager;

    private final Image _pointImage = new Image(Assets.getInstance().get(Assets.PointTexture));

    private final BitmapFont _font;

    public GameScreen(SnakeGame game) {
        _game = game;
        _font = Assets.getInstance().get(Assets.MonoFont);
        _font.setColor(1f, 1f, 1f, 1f);
        _font.getData().setScale(0.8f);

        _pointImage.setScale(1.8f);
        _pointImage.setPosition(WIDTH / 2f - 2.8f * CELL_WIDTH, HEIGHT - 2.3f * CELL_HEIGHT);

        _gameManager = new GameManager(_game.batch());
    }
    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0.6f, 0.2f, 1);

        _gameManager.step(delta);

        _game.batch().begin();

        _gameManager.render();
        _pointImage.draw(_game.batch(), 1.0f);
        _font.draw(_game.batch(), Integer.toString(_gameManager.getScore()), _pointImage.getX() + 3.8f * CELL_WIDTH, _pointImage.getY() + 1.3f * CELL_HEIGHT, 0f, 0, false);

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
