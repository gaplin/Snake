package snake.game.controllers;

import snake.game.entities.Snake;

public abstract class SnakeController {
    protected Snake _snake;

    protected SnakeController(Snake snake) {
        _snake = snake;
    }

    public void setSnake(Snake snake) {
        _snake = snake;
    }

    public abstract void handleInputEvent();
}
