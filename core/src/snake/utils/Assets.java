package snake.utils;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable {
    public static final AssetDescriptor<Texture> headTexture =
            new AssetDescriptor<>("snake/head.png", Texture.class);
    private final AssetManager _manager = new AssetManager();

    private static Assets instance;

    public static Assets getInstance() {
        if(instance == null) {
            instance = new Assets();
        }
        return instance;
    }
    private Assets() {}

    public void loadSnakeTextures() {
        _manager.load(headTexture);
    }

    public void finishLoading() {
        _manager.finishLoading();
    }

    public <T> T get(AssetDescriptor<T> assetDescriptor) {
        return _manager.get(assetDescriptor);
    }

    @Override
    public void dispose() {
        _manager.dispose();
    }
}
