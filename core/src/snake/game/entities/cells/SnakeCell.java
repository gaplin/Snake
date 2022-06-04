package snake.game.entities.cells;

public abstract class SnakeCell extends Cell{
    protected SnakeCell(int gridX, int gridY) {
        super(gridX, gridY);
    }
    public void setPosition(int gridX, int gridY) {
        super.setPosition(gridX, gridY);
    }
    public void setPosition(Cell cell) {
        _sprite.setPosition(cell._sprite.getX(), cell._sprite.getY());
    }
}
