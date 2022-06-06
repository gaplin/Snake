package snake;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import snake.screens.GameScreen;
import snake.utils.Assets;


public class SnakeGame extends Game {
	private Assets _assets;
	private SpriteBatch _batch;

	private GameScreen _gameScreen;

	@Override
	public void create () {
		_assets = Assets.getInstance();

		_assets.load();
		_assets.finishLoading();

		_batch = new SpriteBatch();
		_gameScreen = new GameScreen(this);

		setScreen(_gameScreen);
	}

	public SpriteBatch batch() {
		return _batch;
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {
		_assets.dispose();
		_batch.dispose();
		_gameScreen.dispose();
	}
}
