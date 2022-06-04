package snake.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;
import snake.SnakeGame;
import snake.game.entities.cells.Cell;
import snake.game.entities.cells.TerrainCell;

public class GameScreen implements Screen {
    private final SnakeGame _game;
    private final Cell _cell;

    public GameScreen(SnakeGame game) {
        _game = game;
        _cell = new TerrainCell(5, 5);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        _game.batch().begin();
        _cell.draw(_game.batch());
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
