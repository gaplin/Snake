package snake.enums;

public enum Direction {
    Up,
    Right,
    Down,
    Left;

    public static Direction prev(Direction direction) {
        return switch (direction) {
            case Up -> Left;
            case Right -> Up;
            case Down -> Right;
            case Left -> Down;
        };
    }


    public static boolean opposite(Direction dir1, Direction dir2) {
        return (dir1 == Up && dir2 == Down) ||
                (dir1 == Right && dir2 == Left) ||
                (dir1 == Down && dir2 == Up) ||
                (dir1 == Left && dir2 == Right);
    }
}
