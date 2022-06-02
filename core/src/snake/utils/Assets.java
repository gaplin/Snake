package snake.utils;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable {
    private final AssetManager _manager = new AssetManager();

    public static final AssetDescriptor<Texture> headTexture =
            new AssetDescriptor<>("snake/head.png", Texture.class);

    public void loadSnakeTextures() {
        _manager.load(headTexture);
    }

    public AssetManager manager() {
        return _manager;
    }

    @Override
    public void dispose() {
        _manager.dispose();
    }
}
