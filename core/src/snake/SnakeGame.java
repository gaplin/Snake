package snake;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import snake.enums.ScreenType;
import snake.screens.GameScreen;
import snake.screens.HighScoresScreen;
import snake.screens.MainMenuScreen;
import snake.utils.Assets;


public class SnakeGame extends Game {
	private Assets _assets;
	private SpriteBatch _batch;

	private GameScreen _gameScreen;
	private MainMenuScreen _mainMenuScreen;
	private HighScoresScreen _highSCoresScreen;

	@Override
	public void create () {
		_batch = new SpriteBatch();
		_mainMenuScreen = new MainMenuScreen(this);

		_assets = Assets.getInstance();

		_assets.load();
		_assets.finishLoading();

		setScreen(_mainMenuScreen);
	}

	public SpriteBatch batch() {
		return _batch;
	}

	public void changeScreen(ScreenType screenType) {
		switch (screenType) {
			case MainMenu -> setScreen(_mainMenuScreen);
			case HighScores -> {
				if (_highSCoresScreen == null) _highSCoresScreen = new HighScoresScreen(this);
				setScreen(_highSCoresScreen);
			}
			case Game -> {
				if (_gameScreen == null) _gameScreen = new GameScreen(this);
				setScreen(_gameScreen);
			}
		}
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {
		_assets.dispose();
		_batch.dispose();
		_mainMenuScreen.dispose();
		if(_highSCoresScreen != null) {
			_highSCoresScreen.dispose();
		}
		if(_gameScreen != null) {
			_gameScreen.dispose();
		}
	}
}
