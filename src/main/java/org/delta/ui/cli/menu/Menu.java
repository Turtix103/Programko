package org.delta.ui.cli.menu;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Menu {

    public MenuChoices read() {
        try {
            System.out.print("What do you want (1 is help): ");
            Scanner scanner = new Scanner(new InputStreamReader(System.in));
            int menuInput = scanner.nextInt();
            System.out.println("Your choice: " + menuInput);

            return MenuChoices.convertFromMenuInput(menuInput);
        } catch (Exception exception) {
            System.out.println("Input is not valid");

            return MenuChoices.INVALID_CHOICE;
        }
    }

    public String simpleRead() {
        try {
            System.out.print("What do you want: ");
            Scanner scanner = new Scanner(new InputStreamReader(System.in));
            String input = scanner.next();

            return input;
        } catch (Exception exception) {
            System.out.println("Input is not valid");

            return "";
        }
    }
}
