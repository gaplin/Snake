package snake.utils;

import com.badlogic.gdx.math.Vector2;

import static snake.utils.GlobalVariables.CELL_HEIGHT;
import static snake.utils.GlobalVariables.CELL_WIDTH;

public class Helper {
    public static Vector2 gridTpPixels(int x, int y) {
        return new Vector2(x * CELL_WIDTH, y * CELL_HEIGHT);
    }
}
