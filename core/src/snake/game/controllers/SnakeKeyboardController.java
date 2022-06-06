package snake.game.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import snake.enums.Direction;
import snake.game.entities.Snake;

import static snake.enums.Direction.*;

public class SnakeKeyboardController extends SnakeController {

    public SnakeKeyboardController(Snake snake) {
        super(snake);
    }

    public void handleInputEvent() {
        if(Gdx.input.isKeyJustPressed(Input.Keys.W) || Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            changeDirection(Up);
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.D) || Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            changeDirection(Right);
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.S) || Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            changeDirection(Down);
        }
        else if(Gdx.input.isKeyJustPressed(Input.Keys.A) || Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            changeDirection(Left);
        }
    }
    private void changeDirection(Direction direction) {
        var currentDirection = _snake.getDirection();
        var directionIn1Step = _snake.getDirectionIn1Step();
        var directionIn2Steps = _snake.getDirectionIn2Steps();
        if(directionIn1Step != null) {
            if(directionIn2Steps == null && direction != directionIn1Step && ! opposite(direction, directionIn1Step)) {
                _snake.setDirectionIn2Steps(direction);
            }
        } else if(direction != currentDirection && !opposite(currentDirection, direction)) {
            _snake.setDirectionIn1Step(direction);
        }
    }
}
