package snake.game.data;

import com.badlogic.gdx.utils.Array;
import snake.game.entities.Board;
import snake.game.entities.Snake;
import snake.game.entities.cells.pickup.PointCell;
import snake.game.entities.cells.pickup.expiringPickup.ExpiringPickupCell;

public class GameData {
    public final Board board;
    public final Snake snake;
    public int score;
    public final int maxExpiringPickups, maxPointPickups;
    public float moveCoolDown;
    public final float pickupCoolDown, pickupChance;

    public boolean gameEnded;

    public final Array<PointCell> pointPickups = new Array<>();
    public final Array<ExpiringPickupCell> expiringPickups = new Array<>();

    public GameData(Board board, Snake snake, int maxPickups, int maxPointPickups,
                    float moveCoolDown, float pickupCoolDown, float pickupChance) {
        this.board = board;
        this.snake = snake;
        this.maxExpiringPickups = maxPickups;
        this.maxPointPickups = maxPointPickups;
        this.moveCoolDown = moveCoolDown;
        this.pickupCoolDown = pickupCoolDown;
        this.pickupChance = pickupChance;
    }
}
