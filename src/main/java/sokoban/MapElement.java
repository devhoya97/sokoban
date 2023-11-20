package sokoban;

public enum MapElement {
    EMPTY_SPACE(" ", 0),
    HALL("O", 1),
    BALL("o", 2),
    PLAYER("P", 3),
    WALL("#", 4);

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

    public static MapElement matchWithSymbol(String symbol) {
        for (MapElement mapElement : MapElement.values()) {
            if (symbol.equals(mapElement.symbol)) {
                return mapElement;
            }
        }
        throw new IllegalArgumentException("유효한 맵 요소가 아닙니다.");
    }

    public static MapElement matchWithMappingValue(Integer mappingValue) {
        for (MapElement mapElement : MapElement.values()) {
            if (mappingValue.equals(mapElement.mappingValue)) {
                return mapElement;
            }
        }
        throw new IllegalArgumentException("유효한 맵 요소가 아닙니다.");
    }
}
