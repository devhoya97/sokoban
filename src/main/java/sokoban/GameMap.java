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

    public List<List<Integer>> getGameMap() {
        return gameMap;
    }
}
