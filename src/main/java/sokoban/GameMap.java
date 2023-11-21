package sokoban;

import java.util.ArrayList;
import java.util.List;

public class GameMap {
    private static final String MAP_DELIMITER = "\n";
    private List<List<Integer>> gameMap;
    private String stageMessage;
    public GameMap(String stageMessage, String rawGameMap) {
        this.stageMessage = stageMessage;
        this.gameMap = translateToGameMap(rawGameMap.split(MAP_DELIMITER));
    }

    private List<List<Integer>> translateToGameMap(String[] rawGameMap) {
        List<List<Integer>> gameMap = new ArrayList<>();
        for (String rawGameMapRow : rawGameMap) {
            gameMap.add(translateToGameMapRow(rawGameMapRow));
        }
        return gameMap;
    }

    private List<Integer> translateToGameMapRow(String rawGameMapRow) {
        List<Integer> gameMapRow = new ArrayList<>();
        for (int index = 0; index < rawGameMapRow.length(); index++) {
            String symbol = String.valueOf(rawGameMapRow.charAt(index));
            MapElement mapElement = MapElement.matchWithSymbol(symbol);
            gameMapRow.add(mapElement.getMappingValue());
        }
        return gameMapRow;
    }

    public boolean move(char symbol) {
        Direction direction = Direction.match(symbol);
        if (direction == null) {
            return false;
        }
        List<Integer> playerPosition = getPlayerPosition();
        if (direction == Direction.UP) {
            return moveUp();
        }
        if (direction == Direction.DOWN) {
            return moveDown();
        }
        if (direction == Direction.LEFT) {
            return moveLeft();
        }
        if (direction == Direction.RIGHT) {
            return moveRight();
        }
    }

    private boolean moveUp() {
    }

    private boolean moveDown() {
    }

    private boolean moveLeft() {
    }

    private boolean moveRight() {
    }

    public List<Integer> getPlayerPosition() {
        for (int rowIndex = 0; rowIndex < gameMap.size(); rowIndex++) {
            List<Integer> gameMapRow = gameMap.get(rowIndex);
            if (gameMapRow.contains(MapElement.PLAYER.getMappingValue())) {
                return List.of(rowIndex, gameMapRow.indexOf(MapElement.PLAYER.getMappingValue()));
            }
        }
        throw new IllegalArgumentException("맵에 플레이어가 없습니다.");
    }

    //view를 위한 getter
    public List<List<Integer>> getGameMap() {
        return gameMap;
    }

    public String getStageMessage() {
        return stageMessage;
    }
}
