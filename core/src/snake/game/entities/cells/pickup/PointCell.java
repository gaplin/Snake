package snake.game.entities.cells.pickup;

import snake.game.entities.cells.Cell;

public class PointCell extends Cell {
    public PointCell(int gridX, int gridY) {
        super(gridX, gridY);
    }

    public void setVisible(boolean visible) {
        _sprite.setAlpha(visible ? 1f : 0f);
    }
}
