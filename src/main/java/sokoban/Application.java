package sokoban;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String STAGE_DELIMITER = "=====";

    public static void main(String[] args) {
        getMap();

    }

    private static List<GameMap> getMap() {
        List<GameMap> gameMaps = new ArrayList<>();
        String totalGameMap = """
        Stage 1
        #####
        #OoP#
        #####
        =====
        Stage 2
          #######
        ###  O  ###
        #    o    #
        # Oo P oO #
        ###  o  ###
         #   O  #
         ########
        """;

        String[] gameMapStages = totalGameMap.split(STAGE_DELIMITER);
        for (String gameMap : gameMapStages) {
            gameMaps.add(new GameMap(gameMap));
        }
        return gameMaps;
    }
}
