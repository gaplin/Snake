package snake.utils;

import com.badlogic.gdx.math.Vector2;

import static snake.utils.GlobalVariables.CELL_SIZE;

public class Helper {
    public static Vector2 gridToPixels(int x, int y) {
        return new Vector2(x * CELL_SIZE, y * CELL_SIZE);
    }
}
