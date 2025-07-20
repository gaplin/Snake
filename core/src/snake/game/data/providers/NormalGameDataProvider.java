package snake.game.data.providers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import snake.game.controllers.SnakeKeyboardController;
import snake.game.data.GameData;
import snake.game.entities.Board;
import snake.game.entities.Snake;
import snake.game.factories.*;
import snake.game.systems.*;
import snake.preferences.PreferencesManager;

public final class NormalGameDataProvider {
    private static final int
            boardWidth = 16,
            boardHeight = 16,
            initialSnakeSize = 3,
            initialLives = 3,
            maxWalls = 5,
            initialMaxPointPickups = 3,
            initialMaxExpiringPickups = 3,
            minPointPickups = 1,
            minExpiringPickups = 1,
            maxTeleports = 3,
            speedAreaLength = 3,
            speedAreaCount = 3;

    private static final float
            initialPickupCoolDown = 1f,
            pickupChance = 1.7f,
            minPickupCoolDown = 1.0f;

    public static GameData provide(SpriteBatch batch) {
        var gameData = getGameData();
        var pickupFactory = new RandomExpiringPickupFactory(
                new SpeedDownFactory(), new SpeedUpFactory(), new DirectionReverseFactory(),
                new GodModeFactory(), new MorePickupsFactory(), new LessPickupsFactory(),
                new NegativePointFactory(), new HPIncreaseFactory(), new HPDecreaseFactory(),
                new BombFactory(), new MorePointsFactory(), new LessPointsFactory(),
                new MoreFrequentPickupsFactory(), new LessFrequentPickupsFactory()
        );

        gameData.systems.add(new SnakeMovementSystem(gameData));
        gameData.systems.add(new PointPickupSystem(gameData));
        gameData.systems.add(new TeleportSystem(gameData));
        gameData.systems.add(new WallsSystem(gameData));
        gameData.systems.add(new ExpiringPickupSystem(gameData, pickupFactory));
        gameData.systems.add(new EffectsSystem(gameData));
        gameData.systems.add(new SnakeSelfCollisionSystem(gameData));
        gameData.systems.add(new SpeedTerrainSystem(gameData));
        gameData.systems.add(new EndGameSystem(gameData));
        gameData.systems.add(new RenderingSystem(gameData, batch));

        return gameData;
    }

    private static GameData getGameData() {
        var preferencesManager = PreferencesManager.getInstance();
        var initialMoveCoolDown = preferencesManager.getInitialCoolDown();
        var minMoveCoolDown = preferencesManager.getMinCoolDown();
        var maxMoveCoolDown = preferencesManager.getMaxCoolDown();

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
