package snake.utils;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;
import snake.game.entities.cells.Cell;
import snake.game.entities.cells.pickup.PointCell;
import snake.game.entities.cells.snake.SnakeBodyCell;
import snake.game.entities.cells.snake.SnakeHeadCell;
import snake.game.entities.cells.terrain.BrightTerrainCell;
import snake.game.entities.cells.terrain.DarkTerrainCell;

public class Assets implements Disposable {
    private static final AssetDescriptor<Texture> headTexture =
            new AssetDescriptor<>("snake/head.png", Texture.class);
    private static final AssetDescriptor<Texture> bodyTexture =
            new AssetDescriptor<>("snake/body.png", Texture.class);
    private static final AssetDescriptor<Texture> darkTerrainTexture =
            new AssetDescriptor<>("terrain/dark.png", Texture.class);

    private static final AssetDescriptor<Texture> brightTerrainTexture =
            new AssetDescriptor<>("terrain/bright.png", Texture.class);
    private static final AssetDescriptor<Texture> pointTexture =
            new AssetDescriptor<>("pickup/point.png", Texture.class);
    private final AssetManager _manager = new AssetManager();

    private static Assets instance;

    public static Assets getInstance() {
        if(instance == null) {
            instance = new Assets();
        }
        return instance;
    }
    private Assets() {}

    public void load() {
        _manager.load(headTexture);
        _manager.load(bodyTexture);
        _manager.load(brightTerrainTexture);
        _manager.load(darkTerrainTexture);
        _manager.load(pointTexture);
    }

    public void finishLoading() {
        _manager.finishLoading();
    }

    public Texture getTexture(Cell obj) {
        if(obj instanceof DarkTerrainCell) {
            return _manager.get(darkTerrainTexture);
        }
        if(obj instanceof BrightTerrainCell) {
            return _manager.get(brightTerrainTexture);
        }
        if(obj instanceof SnakeHeadCell) {
            return _manager.get(headTexture);
        }
        if(obj instanceof SnakeBodyCell) {
            return _manager.get(bodyTexture);
        }
        if(obj instanceof PointCell) {
            return _manager.get(pointTexture);
        }
        return null;
    }

    @Override
    public void dispose() {
        _manager.dispose();
    }
}
