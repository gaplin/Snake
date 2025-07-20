package snake.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.ScreenUtils;
import snake.SnakeGame;
import snake.assets.Assets;
import snake.enums.GameMode;
import snake.enums.ScreenType;
import snake.preferences.PreferencesManager;

import static snake.GlobalVariables.BACKGROUND_COLOR;

public class MenuScreen implements Screen {
    private final SnakeGame _game;
    private final Stage _stage;
    private final PreferencesManager _preferencesManager;
    private final Table _table;

    public MenuScreen(SnakeGame game) {
        _game = game;
        _preferencesManager = PreferencesManager.getInstance();
        _stage = new Stage();

        BitmapFont font = Assets.getInstance().get(Assets.MonoFont);

        font.setColor(1f, 1f, 1f, 1f);
        font.getData().setScale(0.8f);

        Skin skin = Assets.getInstance().get(Assets.ComicSkin);
        _table = new Table();
        _table.setFillParent(true);

        TextButton playButton = new TextButton("Play", skin);
        TextButton gameModeButton = new TextButton("Mode: " + _preferencesManager.getGameMode(), skin);
        TextButton optionsButton = new TextButton("Options", skin);
        TextButton controlsButton = new TextButton("Controls", skin);
        TextButton exitButton = new TextButton("Exit", skin);

        playButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                _game.changeScreen(ScreenType.Game);
            }
        });

        gameModeButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                var currentGameMode = _preferencesManager.getGameMode();
                var currentIdx = currentGameMode.ordinal();
                var values = GameMode.values();
                var next = (currentIdx + 1) % values.length;
                var newGameMode = values[next];
                _preferencesManager.setGameMode(newGameMode);
                gameModeButton.setText("Mode: " + newGameMode);
            }
        });
        optionsButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                _game.changeScreen(ScreenType.Options);
            }
        });

        controlsButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                _game.changeScreen(ScreenType.Controls);
            }
        });

        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });

        _table.add(playButton).fillX().uniform().width(250);
        _table.row().pad(50, 0, 0, 0);

        _table.add(gameModeButton).fillX().uniform().width(300);
        _table.row().pad(50, 0, 0, 0);

        _table.add(optionsButton).fillX().uniform().width(250);
        _table.row().pad(50, 0, 0, 0);

        _table.add(controlsButton).fillX().uniform().width(250);
        _table.row().pad(50, 0, 0, 0);

        _table.add(exitButton).fillX().uniform().width(250);
        _table.row().pad(50, 0, 0, 0);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(_stage);
        _stage.addActor(_table);
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(BACKGROUND_COLOR);

        _stage.act(delta);
        _stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        _stage.clear();
    }

    @Override
    public void dispose() {
        _stage.dispose();
    }
}
