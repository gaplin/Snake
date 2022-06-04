package snake.game.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import snake.game.entities.cells.BrightTerrainCell;
import snake.game.entities.cells.Cell;
import snake.game.entities.cells.DarkTerrainCell;

import static snake.utils.GlobalVariables.CELL_HEIGHT;
import static snake.utils.GlobalVariables.CELL_WIDTH;

public class Board {
    private final Array<Array<Cell>> _cells = new Array<>();

    public Board(int width, int height) {
        for (int i = 0; i < height; ++i) {
            _cells.add(new Array<>());
            for(int j = 0; j < width; ++j) {
                int x = j * CELL_WIDTH, y = i * CELL_HEIGHT;
                _cells.get(i).add((i + j) % 2 == 0 ? new DarkTerrainCell(x, y) : new BrightTerrainCell(x, y));
            }
        }
    }

    public void draw(SpriteBatch batch) {
        for(var row : _cells) {
            for(var cell : row) {
                cell.draw(batch);
            }
        }
    }
}
