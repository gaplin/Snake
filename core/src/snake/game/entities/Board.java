package snake.game.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import snake.game.entities.cells.BrightTerrainCell;
import snake.game.entities.cells.DarkTerrainCell;
import snake.game.entities.cells.TerrainCell;

public class Board {
    private final Array<Array<TerrainCell>> _cells = new Array<>();
    private Snake _snake;
    public Board(int width, int height) {
        for (int i = 0; i < height; ++i) {
            _cells.add(new Array<>());
            for(int j = 0; j < width; ++j) {
                _cells.get(i).add((i + j) % 2 == 0 ? new DarkTerrainCell(j, i) : new BrightTerrainCell(j, i));
            }
        }
    }

    public void setSnake(Snake snake) {
        _snake = snake;
    }

    public void render(SpriteBatch batch) {
        for(var row : _cells) {
            for(var cell : row) {
                cell.draw(batch);
            }
        }
    }
}
