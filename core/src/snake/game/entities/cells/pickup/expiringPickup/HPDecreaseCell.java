package snake.game.entities.cells.pickup.expiringPickup;

import com.badlogic.gdx.math.Vector2;
import snake.assets.Assets;
import snake.game.data.GameData;

import static snake.GlobalVariables.DEAD_COLOR;

public class HPDecreaseCell extends ExpiringPickupCell{
    public HPDecreaseCell(Vector2 position) {
        super(position, Assets.getInstance().get(Assets.HeadTexture));
        _sprite.setColor(DEAD_COLOR);
    }

    @Override
    public void act(GameData gameData) {
        if(!gameData.GodMode) {
            --gameData.lives;
        } else {
            ++gameData.lives;
        }
    }
}
