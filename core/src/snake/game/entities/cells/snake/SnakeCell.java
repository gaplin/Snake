package snake.game.entities.cells.snake;

import snake.game.entities.cells.Cell;

public abstract class SnakeCell extends Cell {
    public SnakeCell(int gridX, int gridY) {
        super(gridX, gridY);
    }
    public SnakeCell(float px, float py) {
        super(px, py);
    }
}
