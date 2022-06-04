package snake.game.entities.cells;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import snake.utils.Assets;
import snake.utils.Helper;

import static snake.utils.GlobalVariables.CELL_HEIGHT;
import static snake.utils.GlobalVariables.CELL_WIDTH;

public abstract class Cell {
    protected final Sprite _sprite = new Sprite(Assets.getInstance().getTexture(this), CELL_WIDTH, CELL_HEIGHT);

    protected Cell(int gridX, int gridY) {
        setPosition(gridX, gridY);
    }

    protected void setPosition(int gridX, int gridY) {
        var posInPixels = Helper.gridTpPixels(gridX, gridY);
        _sprite.setPosition(posInPixels.x, posInPixels.y);
    }

    public float getX() {
        return _sprite.getX();
    }
    public float getY() {
        return _sprite.getY();
    }

    public void draw(SpriteBatch batch) {
        _sprite.draw(batch);
    }
}
