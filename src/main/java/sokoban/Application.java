package sokoban;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String STAGE_DELIMITER = "=====";

    public static void main(String[] args) {
        List<GameMap> gameMaps = getGameMaps();
        List<List<Integer>> stage1GameMap = gameMaps.get(0).getGameMap();
        stage1GameMap.forEach(System.out::println);
        List<List<Integer>> stage2GameMap = gameMaps.get(1).getGameMap();
        stage2GameMap.forEach(System.out::println);

    }

    private static List<GameMap> getGameMaps() {
        List<GameMap> gameMapStages = new ArrayList<>();
        String totalGameMapStage =
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
                         """
        ;
        for (String gameMapStage : totalGameMapStage.split(STAGE_DELIMITER)) {
            gameMapStages.add(new GameMap(gameMapStage));
        }
        return gameMapStages;
    }
}
