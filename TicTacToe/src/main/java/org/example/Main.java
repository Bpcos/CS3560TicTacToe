package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean replay = true;
        System.out.println("1 for against other player, 2 for against CPU:");
        GameController game = new GameController((scanner.nextInt() == 1));
        do {
            game.gameLoop();
            System.out.println();
            System.out.println("Type 0 to quit or any other number to continue:");
            replay = scanner.nextInt() != 0;
        } while(replay);


    }
}