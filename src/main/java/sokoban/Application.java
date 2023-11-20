package sokoban;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String STAGE_DELIMITER = "=====";

    public static void main(String[] args) {
        List<GameMap> gameMaps = getGameMaps();
        GameMap stage2 = gameMaps.get(1);
        System.out.println(stage2.getHorizontalSize());
        System.out.println(stage2.getVerticalSize());
        System.out.println(stage2.getHallCount());
        System.out.println(stage2.getBallCount());
        System.out.println(stage2.getPlayerPosition());


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
