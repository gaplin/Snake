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
        var newDirection = _snake.getNewDirection();
        if(newDirection != null || direction == currentDirection || opposite(currentDirection, direction)) {
            return;
        }
        _snake.setNewDirection(direction);
    }
}
