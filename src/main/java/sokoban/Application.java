package sokoban;

public class Application {

    public static void main(String[] args) {

    }

    private static Map getMap() {
        String map = """
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
        return new Map(map);
    }
}
