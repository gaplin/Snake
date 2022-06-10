package snake.game.entities.cells.pickup;

import com.badlogic.gdx.math.Vector2;
import snake.game.data.GameData;
import snake.game.entities.cells.Cell;

public abstract class PickupCell extends Cell {
    public PickupCell(Vector2 position) {
        super(position);
    }
    public abstract void act(GameData gameData);
}
