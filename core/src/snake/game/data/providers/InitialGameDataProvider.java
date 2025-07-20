package snake.game.data.providers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import snake.game.data.GameData;
import snake.preferences.PreferencesManager;

public final class InitialGameDataProvider {
    private final PreferencesManager _preferences = PreferencesManager.getInstance();

    public GameData provide(SpriteBatch batch) {
        var gameMode = _preferences.getGameMode();
        return switch (gameMode) {
            case Normal -> NormalGameDataProvider.provide(batch);
            case Classic -> ClassicGameDataProvider.provide(batch);
        };
    }
}
