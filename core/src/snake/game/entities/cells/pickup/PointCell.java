package snake.game.entities.cells.pickup;

import com.badlogic.gdx.math.Vector2;
import snake.game.data.GameData;


public class PointCell extends PickupCell {
    public PointCell(Vector2 position) {
        super(position);
    }

    @Override
    public void act(GameData gameData) {
        ++gameData.score;
        gameData.snake.increaseSize();
    }
}
