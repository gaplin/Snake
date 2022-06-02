package snake.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import snake.screens.GameScreen;
import snake.utils.Assets;


public class SnakeGame extends Game {
	private Assets _assets;
	private SpriteBatch _batch;

	@Override
	public void create () {
		_assets = new Assets();

		_assets.loadSnakeTextures();
		_assets.manager().finishLoading();

		_batch = new SpriteBatch();

		setScreen(new GameScreen(this));
	}

	public Assets assets() {
		return _assets;
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
	}
}
