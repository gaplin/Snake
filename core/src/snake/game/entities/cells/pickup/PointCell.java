package snake.game.entities.cells.pickup;

import com.badlogic.gdx.math.Vector2;
import snake.game.data.GameData;


public class PointCell extends PickupCell {
    public PointCell(int gridX, int gridY) {
        super(gridX, gridY);
    }
    public PointCell(Vector2 position) {
        super(position);
    }

    @Override
    public void act(GameData gameData) {
        ++gameData.score;
        gameData.snake.increaseSize();
    }

    public void setVisible(boolean visible) {
        _sprite.setAlpha(visible ? 1f : 0f);
    }
}
