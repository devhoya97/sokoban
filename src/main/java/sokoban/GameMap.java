package sokoban;

import java.util.ArrayList;
import java.util.List;
import sokoban.view.OutputView;

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
        List<Integer> playerPosition = getPlayerPosition();
        int playerRowIndex = playerPosition.get(0);
        int playerColumnIndex = playerPosition.get(1);

        Direction direction = Direction.match(symbol);
        if (direction == Direction.UP) {
            return moveUp(playerRowIndex, playerColumnIndex);
        }
        if (direction == Direction.DOWN) {
            return moveDown(playerRowIndex, playerColumnIndex);
        }
        if (direction == Direction.LEFT) {
            return moveLeft(playerRowIndex, playerColumnIndex);
        }
        if (direction == Direction.RIGHT) {
            return moveRight(playerRowIndex, playerColumnIndex);
        }
        return false;
    }

    private boolean moveUp(int playerRowIndex, int playerColumnIndex) {
        if (gameMap.get(playerRowIndex - 1).get(playerColumnIndex) != MapElement.EMPTY_SPACE.getMappingValue()) {
            return false;
        }
        changePosition(playerRowIndex, playerColumnIndex, playerRowIndex - 1, playerColumnIndex);
        return true;
    }

    private boolean moveDown(int playerRowIndex, int playerColumnIndex) {
        if (gameMap.get(playerRowIndex + 1).get(playerColumnIndex) != MapElement.EMPTY_SPACE.getMappingValue()) {
            return false;
        }
        changePosition(playerRowIndex, playerColumnIndex, playerRowIndex + 1, playerColumnIndex);
        return true;
    }

    private boolean moveLeft(int playerRowIndex, int playerColumnIndex) {
        if (gameMap.get(playerRowIndex).get(playerColumnIndex - 1) != MapElement.EMPTY_SPACE.getMappingValue()) {
            return false;
        }
        changePosition(playerRowIndex, playerColumnIndex, playerRowIndex, playerColumnIndex - 1);
        return true;
    }

    private boolean moveRight(int playerRowIndex, int playerColumnIndex) {
        if (gameMap.get(playerRowIndex).get(playerColumnIndex + 1) != MapElement.EMPTY_SPACE.getMappingValue()) {
            return false;
        }
        changePosition(playerRowIndex, playerColumnIndex, playerRowIndex, playerColumnIndex + 1);
        return true;
    }

    private void changePosition(int playerRowIndex, int playerColumnIndex, int targetRowIndex, int targetColumnIndex) {
        gameMap.get(targetRowIndex).set(targetColumnIndex, MapElement.PLAYER.getMappingValue());
        gameMap.get(playerRowIndex).set(playerColumnIndex, MapElement.EMPTY_SPACE.getMappingValue());
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
