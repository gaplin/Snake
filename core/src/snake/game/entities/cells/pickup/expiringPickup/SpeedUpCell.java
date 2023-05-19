package snake.game.entities.cells.pickup.expiringPickup;

import com.badlogic.gdx.math.Vector2;
import snake.game.data.GameData;

public class SpeedUpCell extends ExpiringPickupCell {
    public SpeedUpCell(Vector2 position) {
        super(position);
    }

    @Override
    public void act(GameData gameData) {
        gameData.moveCoolDown = Math.max(gameData.minMoveCoolDown, gameData.moveCoolDown - 0.01f);
    }
}
