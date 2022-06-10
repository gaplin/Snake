package snake.factories;

import com.badlogic.gdx.math.Vector2;
import snake.game.entities.cells.pickup.expiringPickup.ExpiringPickupCell;

public interface IExpiringPickupFactory {
    ExpiringPickupCell createOnPosition(Vector2 position);
}
