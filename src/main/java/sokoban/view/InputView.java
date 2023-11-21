package sokoban.view;

import java.util.Scanner;

public class InputView {
    public static String getUserInput() {
        System.out.print("SOKOBAN> ");
        Scanner console = new Scanner(System.in);
        String consoleInput = console.nextLine();
        System.out.println();
        return consoleInput;
    }
}
