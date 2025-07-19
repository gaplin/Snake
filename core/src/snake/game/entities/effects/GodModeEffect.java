package snake.game.entities.effects;

import com.badlogic.gdx.math.MathUtils;
import snake.game.data.GameData;

public class GodModeEffect extends RenewableEffect implements ActingEffect {
    private static final float s_timeBonus = 9.0f;
    public GodModeEffect() {
        super(s_timeBonus);
    }

    @Override
    public void apply(GameData gameData) {
        gameData.GodMode = true;
    }

    @Override
    public void expire(GameData gameData) {
        gameData.GodMode = false;
        gameData.snake.setAlpha(1.0f);
    }

    @Override
    public void renew() {
        _timeLeft += s_timeBonus;
    }

    @Override
    public void act(GameData gameData) {
        var multiplier = _timeLeft >= 3.5f ? 4.0f : 6.0f;
        var alpha = Math.max(0.1f, Math.abs(MathUtils.sin(_timeLeft * multiplier)));
        gameData.snake.setAlpha(alpha);
    }
}
