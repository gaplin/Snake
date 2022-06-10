package snake.game.entities.cells.pickup.expiringPickup;

import com.badlogic.gdx.math.Vector2;
import snake.game.data.GameData;

public class SpeedDownCell extends ExpiringPickupCell {
    public SpeedDownCell(int gridX, int gridY) {
        super(gridX, gridY);
    }

    public SpeedDownCell(Vector2 position) {
        super(position);
    }

    @Override
    public void act(GameData gameData) {
        if(gameData.moveCoolDown < 0.2f) {
            gameData.moveCoolDown += 0.01f;
        }
    }
}
