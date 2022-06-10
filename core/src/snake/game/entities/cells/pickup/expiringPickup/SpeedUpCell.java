package snake.game.entities.cells.pickup.expiringPickup;

import com.badlogic.gdx.math.Vector2;
import snake.game.data.GameData;

public class SpeedUpCell extends ExpiringPickupCell {
    public SpeedUpCell(int gridX, int gridY) {
        super(gridX, gridY);
    }

    public SpeedUpCell(Vector2 position) {
        super(position);
    }

    @Override
    public void act(GameData gameData) {
        if(gameData.moveCoolDown > 0.05f) {
            gameData.moveCoolDown -= 0.01;
        }
    }
}
