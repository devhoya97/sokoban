package sokoban.view;

import java.util.List;
import sokoban.GameMap;
import sokoban.MapElement;

public class OutputView {
    private static final String NEW_LINE = "\n";
    public static void printGameMap(GameMap gameMap) {
        StringBuilder totalMessage = new StringBuilder();
        for (List<Integer> gameMapRow : gameMap.getGameMap()) {
            gameMapRow.stream()
                    .map(MapElement::matchWithMappingValue)
                    .map(MapElement::getSymbol)
                    .forEach(totalMessage::append);
            totalMessage.append(NEW_LINE);
        }
        System.out.println(totalMessage);
    }
}
