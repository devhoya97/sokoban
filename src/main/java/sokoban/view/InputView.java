package sokoban.view;

import java.util.Scanner;

public class InputView {
    public static String getUserInput() {
        Scanner console = new Scanner(System.in);
        return console.nextLine();
    }
}
