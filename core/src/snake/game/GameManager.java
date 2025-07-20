package snake.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import snake.game.data.GameData;
import snake.game.data.providers.InitialGameDataProvider;

public class GameManager {
    private final SpriteBatch _batch;
    private final InitialGameDataProvider _initialGameDataProvider = new InitialGameDataProvider();
    private GameData _gameData;

    public GameManager(SpriteBatch batch) {
        _batch = batch;
        init();
    }

    private void init() {
        _gameData = _initialGameDataProvider.provide(_batch);
    }

    public void step(float delta) {
        for(var system : _gameData.systems) {
            system.act(delta);
        }
    }

    public boolean gameEnded() {
        return _gameData.gameEnded;
    }

    public boolean gameWon() {
        return _gameData.gameWon;
    }
    public void restart() {
        init();
    }

    public int getScore() {
        return _gameData.score;
    }

    public int getLives() {
        return _gameData.lives;
    }
}
