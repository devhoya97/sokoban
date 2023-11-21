package sokoban;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String NEW_LINE = "\n";
    private static final String STAGE_DELIMITER = "=====";

    public static void main(String[] args) {
        List<GameMap> gameMaps = getGameMaps();
    }

    private static List<GameMap> getGameMaps() {
        List<GameMap> gameMaps = new ArrayList<>();
        String totalGameMapsOfStages =
                """
                        Stage 1
                        #####
                        #OoP#
                        #####
                        =====Stage 2
                          #######
                        ###  O  ###
                        #    o    #
                        # Oo P oO #
                        ###  o  ###
                         #   O  # 
                         ########
                         """;
        for (String stageMessageAndRawGameMap : totalGameMapsOfStages.split(STAGE_DELIMITER)) {
            int stageMessageEndIndex = stageMessageAndRawGameMap.indexOf(NEW_LINE);
            String stageMessage = stageMessageAndRawGameMap.substring(0, stageMessageEndIndex);
            String rawGameMap = stageMessageAndRawGameMap.substring(stageMessageEndIndex + 1);
            gameMaps.add(new GameMap(stageMessage, rawGameMap));
        }
        return gameMaps;
    }
}
