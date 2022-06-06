package snake.utils;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Disposable;
import snake.game.entities.cells.Cell;
import snake.game.entities.cells.pickup.PointCell;
import snake.game.entities.cells.snake.SnakeBodyCell;
import snake.game.entities.cells.snake.SnakeHeadCell;
import snake.game.entities.cells.terrain.BrightTerrainCell;
import snake.game.entities.cells.terrain.DarkTerrainCell;

public class Assets implements Disposable {
    public static final AssetDescriptor<Texture> HeadTexture =
            new AssetDescriptor<>("snake/head.png", Texture.class);
    public static final AssetDescriptor<Texture> BodyTexture =
            new AssetDescriptor<>("snake/body.png", Texture.class);
    public static final AssetDescriptor<Texture> DarkTerrainTexture =
            new AssetDescriptor<>("terrain/dark.png", Texture.class);

    public static final AssetDescriptor<Texture> BrightTerrainTexture =
            new AssetDescriptor<>("terrain/bright.png", Texture.class);
    public static final AssetDescriptor<Texture> PointTexture =
            new AssetDescriptor<>("pickup/point.png", Texture.class);

    public static final AssetDescriptor<BitmapFont> MonoFont =
            new AssetDescriptor<>("fonts/Mono.fnt", BitmapFont.class);
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
        _manager.load(HeadTexture);
        _manager.load(BodyTexture);
        _manager.load(BrightTerrainTexture);
        _manager.load(DarkTerrainTexture);
        _manager.load(PointTexture);
        _manager.load(MonoFont);
    }

    public void finishLoading() {
        _manager.finishLoading();
    }

    public Texture getTexture(Cell obj) {
        if(obj instanceof DarkTerrainCell) {
            return _manager.get(DarkTerrainTexture);
        }
        if(obj instanceof BrightTerrainCell) {
            return _manager.get(BrightTerrainTexture);
        }
        if(obj instanceof SnakeHeadCell) {
            return _manager.get(HeadTexture);
        }
        if(obj instanceof SnakeBodyCell) {
            return _manager.get(BodyTexture);
        }
        if(obj instanceof PointCell) {
            return _manager.get(PointTexture);
        }
        return null;
    }

    public <T> T get(AssetDescriptor<T> assetDescriptor) {
        return _manager.get(assetDescriptor);
    }

    @Override
    public void dispose() {
        _manager.dispose();
    }
}
