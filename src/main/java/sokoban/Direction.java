package sokoban;

public enum Direction {
    UP('W', "위쪽으로 이동합니다."),
    DOWN('S', "아래쪽으로 이동합니다."),
    LEFT('A', "왼쪽으로 이동합니다."),
    RIGHT('D', "오른쪽으로 이동합니다.");

    private final char symbol;
    private final String moveMessage;

    Direction(char symbol, String moveMessage) {
        this.symbol = symbol;
        this.moveMessage = moveMessage;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getMoveMessage() {
        return moveMessage;
    }

    public static Direction match(char symbol) {
        for (Direction direction : Direction.values()) {
            if (direction.symbol == symbol) {
                return direction;
            }
        }
        return null;
    }
}
