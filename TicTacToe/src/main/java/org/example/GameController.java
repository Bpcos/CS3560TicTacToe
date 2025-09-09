package org.example;

import java.util.Scanner;

public class GameController {
    private Board board;
    private int turn = 1;
    private final boolean multiplayer;
    private boolean winState;

    public GameController(boolean gameMode){
        this.multiplayer = gameMode;
    }

    public void gameLoop(){
        board = new Board();
        turn = 1;
        if(multiplayer){
            do{
                printBoard();
                playerTurn();
                turn++;
            } while(!(winState || turn >= 10));
        } else {
            ComputerPlayer com = new ComputerPlayer(board, false);
            do{
                printBoard();
                playerTurn();
                turn++;
                if(!(winState || turn >= 10)){
                    Cell Target = com.ComputerTurn();
                    winState = board.checkWin(Target);
                    if (winState) System.out.println("Computer Player Wins");
                    turn++;
                }
            } while(!(winState || turn >= 10));
        }
    }

    private void playerTurn(){
        Scanner scanner = new Scanner(System.in);
        int player, choice;
        boolean p1;
        if(turn % 2 == 0){
            player = 2;
            p1 = false;
        }
        else {
            player = 1;
            p1 = true;
        }
        System.out.printf("%n Player %d's Turn:", player);
        do {
            System.out.printf("%n Select an open space:");
            choice = scanner.nextInt();
        } while(board.cellAt(choice).getFilled());
        //this do while should prevent selecting a filled unit but just in case
        if(!board.cellAt(choice).getFilled()){
           board.cellAt(choice).setFilled(p1);
           winState = board.checkWin(board.cellAt(choice));
        }
        if(winState) System.out.printf("%n Player %d Wins!", player);
    }

    private void printBoard(){
        for (int i = 1; i < 10; i++){
            if(board.cellAt(i).getFilled()){
                if(board.cellAt(i).getX()){
                    System.out.print(" X ");
                } else System.out.print(" O ");
            }  else System.out.printf(" %d ", i);
            if(i % 3 == 0) System.out.println();
        }
    }
}
