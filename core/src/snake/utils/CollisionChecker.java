package snake.utils;

import snake.game.entities.Snake;
import snake.game.entities.cells.Cell;
import snake.game.entities.cells.snake.SnakeHeadCell;

public class CollisionChecker {
    public static boolean isCollidingWithItself(Snake snake) {
        var snakeCells = snake.getCells();
        var head = (SnakeHeadCell) snakeCells.get(0);
        for(int i = 1; i < snakeCells.size; ++i) {
            if(head.collidesWith(snakeCells.get(i))) {
                return true;
            }
        }
        return false;
    }
    public static boolean isCollidingWithSnake(Cell cell, Snake snake) {
        for(var snakeCell : snake.getCells()) {
            if(cell.collidesWith(snakeCell)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCollidingWithHead(Cell cell, Snake snake) {
        var head = snake.getCells().get(0);
        return cell.collidesWith(head);
    }
}
