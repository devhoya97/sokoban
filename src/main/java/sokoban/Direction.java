package sokoban;

public enum Direction {
    UP('w', "위쪽으로 이동합니다."),
    DOWN('s', "아래쪽으로 이동합니다."),
    LEFT('a', "왼쪽으로 이동합니다."),
    RIGHT('d', "오른쪽으로 이동합니다.");

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
            if (direction.symbol == Character.toLowerCase(symbol)) {
                return direction;
            }
        }
        return null;
    }
}
