package snake.utils;

import com.badlogic.gdx.math.Vector2;

import static snake.utils.GlobalVariables.CELL_SIZE;

public class Helper {
    public static Vector2 gridTpPixels(int x, int y) {
        return new Vector2(x * GlobalVariables.CELL_SIZE, y * CELL_SIZE);
    }
}
