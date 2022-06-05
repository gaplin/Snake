package snake.game.entities.cells.snake;

public class SnakeHeadCell extends SnakeCell {
    public SnakeHeadCell(int gridX, int gridY) {
        super(gridX, gridY);
    }
    public void rotate(boolean clockWise) {
        _sprite.rotate90(clockWise);
    }
}
