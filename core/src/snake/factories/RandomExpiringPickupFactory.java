package snake.factories;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import snake.game.entities.cells.pickup.expiringPickup.ExpiringPickupCell;

public class RandomExpiringPickupFactory implements IExpiringPickupFactory {
    private final Array<IExpiringPickupFactory> _pickupFactories = new Array<>();
    public RandomExpiringPickupFactory(IExpiringPickupFactory...factories) {
        for(var factory : factories) {
            _pickupFactories.add(factory);
        }
    }

    @Override
    public ExpiringPickupCell createOnPosition(Vector2 position) {
        var idx = MathUtils.random.nextInt(_pickupFactories.size);
        return _pickupFactories.get(idx).createOnPosition(position);
    }
}
