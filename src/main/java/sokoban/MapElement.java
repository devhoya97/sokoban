package sokoban;

public enum MapElement {
    EMPTY_SPACE(" ", 0),
    HALL("O", 1),
    BALL("o", 2),
    PLAYER("P", 3),
    WALL("#", 4),
    STAGE_DELIMITER("=", -1);

    private String symbol;
    private int mappingValue;

    MapElement(String symbol, int mappingValue) {
        this.symbol = symbol;
        this.mappingValue = mappingValue;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getMappingValue() {
        return mappingValue;
    }
}
