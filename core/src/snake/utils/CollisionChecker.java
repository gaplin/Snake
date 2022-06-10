package snake.utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import snake.game.data.GameData;
import snake.game.entities.Snake;
import snake.game.entities.cells.Cell;
import snake.game.entities.cells.pickup.PointCell;
import snake.game.entities.cells.pickup.expiringPickup.ExpiringPickupCell;
import snake.game.entities.cells.snake.SnakeHeadCell;

public class CollisionChecker {
    public static boolean isCollidingWithItself(Snake snake) {
        var snakeCells = snake.getCells();
        var head = (SnakeHeadCell) snakeCells.get(0);
        for (int i = 1; i < snakeCells.size; ++i) {
            if (head.collidesWith(snakeCells.get(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean SnakeContains(Snake snake, Cell cell) {
        for(var snakeCell : snake.getCells()) {
            if(snakeCell.collidesWith(cell)) {
                return true;
            }
        }
        return false;
    }

    public static boolean AnyPointPickupContains(Array<PointCell> pickups, Cell cell) {
        for(var pickup : pickups) {
            if(pickup.collidesWith(cell)) {
                return true;
            }
        }
        return false;
    }

    public static boolean AnyExpiringPickupContains(Array<ExpiringPickupCell> pickups, Cell cell) {
        for(var pickup : pickups) {
            if(pickup.collidesWith(cell)) {
                return true;
            }
        }
        return false;
    }

    public static Vector2 getFreePosition(GameData gameData, boolean skipPoint, boolean skipExpiring) {
        Array<Vector2> goodPositions = new Array<>();

        var board = gameData.board.getBoard();

        for(var row : board) {
            for(var cell: row) {
                if(isGoodPosition(cell, gameData, skipPoint, skipExpiring)) {
                    goodPositions.add(cell.getPosition());
                }
            }
        }

        return goodPositions.random();
    }

    private static boolean isGoodPosition(Cell cell, GameData gameData, boolean skipPoint, boolean skipExpiring) {
        if(SnakeContains(gameData.snake, cell)) {
            return false;
        }
        if(!skipPoint && AnyPointPickupContains(gameData.pointPickups, cell)) {
            return false;
        }
        if (!skipExpiring && AnyExpiringPickupContains(gameData.expiringPickups, cell)) {
            return false;
        }
        return true;
    }
}
