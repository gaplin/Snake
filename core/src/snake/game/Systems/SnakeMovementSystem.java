package snake.game.Systems;

import snake.game.controllers.SnakeController;
import snake.game.data.GameData;

public class SnakeMovementSystem implements GameSystem {
    private final GameData _gameData;
    private float _timeFromLastMove = 0.0f;
    private final SnakeController _controller;

    public SnakeMovementSystem(GameData gameData, SnakeController controller) {
        _gameData = gameData;
        _controller = controller;
    }

    @Override
    public void act(float delta) {
        if(_gameData.gameEnded) return;

        _controller.handleInputEvent();
        _timeFromLastMove += delta;
        if(_timeFromLastMove >= _gameData.moveCoolDown) {
            makeAMove();
            _timeFromLastMove = 0.0f;
        }
    }

    private void makeAMove() {
        _gameData.snake.move(_gameData.board.getWidth(), _gameData.board.getHeight());
    }
}
