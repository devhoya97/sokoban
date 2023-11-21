package sokoban;

import java.util.ArrayList;
import java.util.List;
import sokoban.view.InputView;
import sokoban.view.OutputView;

public class Application {
    private static final String NEW_LINE = "\n";
    private static final String STAGE_DELIMITER = "=====";
    private static final char QUIT = 'Q';

    public static void main(String[] args) {
        GameMap stage2GameMap = getGameMaps().get(1);
        OutputView.printGameStart(stage2GameMap);
        while (true) {
            String userInput = InputView.getUserInput();
            for (char symbol : userInput.toCharArray()) {
                if (!Character.isLetter(symbol)) {
                    OutputView.printNotSupportedInput(symbol);
                    continue;
                }
                symbol = Character.toUpperCase(symbol);
                if (symbol == QUIT) {
                    OutputView.printGameOver();
                    return;
                }
                boolean canMove = stage2GameMap.move(symbol);
                OutputView.printResult(stage2GameMap, symbol, canMove);
            }
        }
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
