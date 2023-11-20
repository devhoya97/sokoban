package sokoban;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String NEW_LINE = "\n";
    private static final String DOUBLE_NEW_LINE = "\n\n";
    private static final String STAGE_DELIMITER = "=====";

    public static void main(String[] args) {
        List<GameMap> gameMaps = getGameMaps();
        printAll(gameMaps);
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
                         """
        ;
        for (String stageMessageAndRawGameMap : totalGameMapsOfStages.split(STAGE_DELIMITER)) {
            int stageMessageEndIndex = stageMessageAndRawGameMap.indexOf(NEW_LINE);
            String stageMessage = stageMessageAndRawGameMap.substring(0, stageMessageEndIndex);
            String rawGameMap = stageMessageAndRawGameMap.substring(stageMessageEndIndex + 1);
            gameMaps.add(new GameMap(stageMessage, rawGameMap));
        }
        return gameMaps;
    }

    private static void printAll(List<GameMap> gameMaps) {
        for (GameMap gameMap : gameMaps) {
            printGameMap(gameMap);
            printGameMapSummary(gameMap);
        }
    }

    private static void printGameMap(GameMap gameMap) {
        StringBuilder totalMessage = new StringBuilder();
        totalMessage.append(gameMap.getStageMessage()).append(DOUBLE_NEW_LINE);
        for (List<Integer> gameMapRow : gameMap.getGameMap()) {
            gameMapRow.stream()
                    .map(MapElement::matchWithMappingValue)
                    .map(MapElement::getSymbol)
                    .forEach(totalMessage::append);
            totalMessage.append(NEW_LINE);
        }
        System.out.println(totalMessage);
    }

    private static void printGameMapSummary(GameMap gameMap) {
        StringBuilder totalMessage = new StringBuilder();
        totalMessage.append("가로크기: ")
                .append(gameMap.getHorizontalSize()).append(NEW_LINE);
        totalMessage.append("세로크기: ")
                .append(gameMap.getVerticalSize()).append(NEW_LINE);
        totalMessage.append("구멍의 수: ")
                .append(gameMap.getHallCount()).append(NEW_LINE);
        totalMessage.append("공의 수: ")
                .append(gameMap.getBallCount()).append(NEW_LINE);
        totalMessage.append("플레이어 위치: ")
                .append(gameMap.getPlayerPosition().get(0)).append("행 ")
                .append(gameMap.getPlayerPosition().get(1)).append("열")
                .append(NEW_LINE);
        System.out.println(totalMessage);
    }
}
