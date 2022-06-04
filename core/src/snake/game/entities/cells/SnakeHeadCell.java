package snake.game.entities.cells;

public class SnakeHeadCell extends SnakeCell{
    public SnakeHeadCell(int gridX, int gridY) {
        super(gridX, gridY);
    }
    public void setPosition(float px, float py) {
        _sprite.setPosition(px, py);
    }
    public void rotate(boolean clockWise) {
        _sprite.rotate90(clockWise);
    }
}
