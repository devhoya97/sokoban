package sokoban.view;

import java.util.List;
import sokoban.Direction;
import sokoban.GameMap;
import sokoban.MapElement;

public class OutputView {
    private static final String NEW_LINE = "\n";

    public static void printGameStart(GameMap gameMap) {
        System.out.println(gameMap.getStageMessage() + NEW_LINE);
        printGameMap(gameMap);
    }

    public static void printResult(GameMap gameMap, char symbol, boolean canMove) {
        printGameMap(gameMap);
        Direction direction = Direction.match(symbol);
        if (direction != null) {
            if (canMove) {
                System.out.println(symbol + ": " + direction.getMoveMessage() + NEW_LINE);
                return;
            }
            System.out.println(symbol + ": (경고!) 해당 명령을 수행할 수 없습니다!" + NEW_LINE);
            return;
        }
        printNotSupportedInput(symbol);
    }

    public static void printGameOver() {
        System.out.println("Bye~");
    }

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

    public static void printNotSupportedInput(char symbol) {
        System.out.println(symbol + ": (경고) 지원하지 않는 명령입니다!" + NEW_LINE);
    }
}
