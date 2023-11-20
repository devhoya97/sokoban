package sokoban;

import java.util.List;

public class GameMap {
    private static final String MAP_DELIMITER = "\n";
    private List<List<Integer>> gameMap;
    private int stage;
    public GameMap(String gameMap) {

    }

    private void makeGameMap(String gameMap) {
        String[] gameMapRows = gameMap.split(MAP_DELIMITER);
    }


}
