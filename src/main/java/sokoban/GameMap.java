package sokoban;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameMap {
    private static final String MAP_DELIMITER = "\n";
    private List<List<Integer>> gameMap;
    private String stageMessage;
    public GameMap(String gameMapStage) {
        String[] gameMapStageRows = gameMapStage.split(MAP_DELIMITER);
        this.stageMessage = gameMapStageRows[0];
        this.gameMap = translateToGameMap(Arrays.copyOfRange(gameMapStageRows, 1, gameMapStageRows.length));
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
            MapElement mapElement = MapElement.match(symbol);
            gameMapRow.add(mapElement.getMappingValue());
        }
        return gameMapRow;
    }

    public int getHorizontalSize() {
        return gameMap.stream()
                .mapToInt(List::size)
                .max()
                .orElseThrow();
    }

    public int getVerticalSize() {
        return gameMap.size();
    }

    public int getHallCount() {
        long hallCount = 0;
        for (List<Integer> gameMapRow : gameMap) {
            hallCount += gameMapRow.stream()
                    .filter(mappingValue -> mappingValue == MapElement.HALL.getMappingValue())
                    .count();
        }
        return (int) hallCount;
    }

    public int getBallCount() {
        long BallCount = 0;
        for (List<Integer> gameMapRow : gameMap) {
            BallCount += gameMapRow.stream()
                    .filter(mappingValue -> mappingValue == MapElement.BALL.getMappingValue())
                    .count();
        }
        return (int) BallCount;
    }

    public List<Integer> getPlayerPosition() {
        for (int rowIndex = 0; rowIndex < gameMap.size(); rowIndex++) {
            List<Integer> gameMapRow = gameMap.get(rowIndex);
            if (gameMapRow.contains(MapElement.PLAYER.getMappingValue())) {
                return List.of(rowIndex + 1, gameMapRow.indexOf(MapElement.PLAYER.getMappingValue()) + 1);
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
