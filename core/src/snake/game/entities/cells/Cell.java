package snake.game.entities.cells;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import snake.utils.Assets;
import snake.utils.Helper;

import static snake.utils.GlobalVariables.CELL_HEIGHT;
import static snake.utils.GlobalVariables.CELL_WIDTH;

public abstract class Cell {
    protected final Sprite _sprite = new Sprite(Assets.getInstance().getTexture(this), CELL_WIDTH, CELL_HEIGHT);

    public Cell(int gridX, int gridY) {
        setPosition(gridX, gridY);
    }
    public Cell(float px, float py) {
        setPosition(px, py);
    }

    public void setPosition(int gridX, int gridY) {
        var posInPixels = Helper.gridTpPixels(gridX, gridY);
        _sprite.setPosition(posInPixels.x, posInPixels.y);
    }
    public void setPosition(float px, float py) {
        _sprite.setPosition(px, py);
    }
    public void setPosition(Cell cell) {
        _sprite.setPosition(cell.getX(), cell.getY());
    }

    public boolean collidesWith(Cell other) {
        return _sprite.getBoundingRectangle().overlaps(other._sprite.getBoundingRectangle());
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
