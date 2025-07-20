package snake.game.data.providers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import snake.game.controllers.SnakeKeyboardController;
import snake.game.data.GameData;
import snake.game.entities.Board;
import snake.game.entities.Snake;
import snake.game.systems.*;
import snake.preferences.PreferencesManager;

public final class ClassicGameDataProvider {
    private static final int
            boardWidth = 16,
            boardHeight = 16,
            initialSnakeSize = 3,
            initialLives = 1,
            maxWalls = 0,
            initialMaxPointPickups = 1,
            initialMaxExpiringPickups = 0,
            minPointPickups = 1,
            minExpiringPickups = 0,
            maxTeleports = 0,
            speedAreaLength = 0,
            speedAreaCount = 0;

    private static final float
            initialPickupCoolDown = 1f,
            minMoveCoolDown = 0.0f,
            maxMoveCoolDown = 20.0f,
            pickupChance = 1.7f,
            minPickupCoolDown = 1.0f;

    public static GameData provide(SpriteBatch batch) {
        var gameData = getGameData();

        gameData.systems.add(new SnakeMovementSystem(gameData));
        gameData.systems.add(new PointPickupSystem(gameData));
        gameData.systems.add(new SnakeSelfCollisionSystem(gameData));
        gameData.systems.add(new EndGameSystem(gameData));
        gameData.systems.add(new RenderingSystem(gameData, batch));

        return gameData;
    }

    private static GameData getGameData() {
        var preferencesManager = PreferencesManager.getInstance();
        var initialMoveCoolDown = preferencesManager.getInitialCoolDown();

        var board = new Board(boardWidth, boardHeight);
        var snake = new Snake(initialSnakeSize - 1, boardHeight / 2, initialSnakeSize);
        var snakeController = new SnakeKeyboardController(snake);

        return new GameData(
                board, snake, snakeController, initialMaxExpiringPickups, initialMaxPointPickups,
                minExpiringPickups, minPointPickups, maxWalls, speedAreaLength, initialMoveCoolDown, initialPickupCoolDown,
                pickupChance, initialLives, maxTeleports, speedAreaCount, minMoveCoolDown, maxMoveCoolDown,
                minPickupCoolDown
        );
    }
}
