package snake.game.entities.cells;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import snake.utils.Assets;
import snake.utils.GlobalVariables;

public abstract class Cell {
    protected final Rectangle _cell = new Rectangle(0, 0, GlobalVariables.CELL_WIDTH, GlobalVariables.CELL_HEIGHT);
    protected final Texture texture = Assets.getInstance().getTexture(this);

    protected Cell(float x, float y) {
        _cell.setPosition(x, y);
    }

    protected void setPosition(float x, float y) {
        _cell.setPosition(x, y);
    }

    protected void setX(float x) {
        _cell.setX(x);
    }

    protected void setY(float y) {
        _cell.setY(y);
    }

    public float getX() {
        return _cell.getX();
    }

    public float getY() {
        return _cell.getY();
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, _cell.x, _cell.y, _cell.width, _cell.height);
    }
}
