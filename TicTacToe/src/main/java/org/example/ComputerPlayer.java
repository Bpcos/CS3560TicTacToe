package org.example;

public class ComputerPlayer {
    //I dont have a Player object, so no inheritance here
    private final Board board;
    private boolean polarity;
    public ComputerPlayer(Board b, Boolean x){
        this.board = b;
    }
    public Cell ComputerTurn(){
        Cell target = board.checkNear(!polarity);
        if (target != null){
            board.fillCell(target, polarity);
        }
        else if(!board.cellAt(5).getFilled()) {
            board.fillCell(board.cellAt(5), polarity);
            target = board.cellAt(5);
        }
        //Center First
        else if(!board.cellAt(1).getFilled()) {
            board.fillCell(board.cellAt(1), polarity);
            target = board.cellAt(1);
        }
        else if(!board.cellAt(3).getFilled()) {
            board.fillCell(board.cellAt(3), polarity);
            target = board.cellAt(3);
        }
        else if(!board.cellAt(7).getFilled()) {
            board.fillCell(board.cellAt(7), polarity);
            target = board.cellAt(7);
        }
        else if(!board.cellAt(9).getFilled()) {
            board.fillCell(board.cellAt(9), polarity);
            target = board.cellAt(9);
        }
        //Then the corners if possible
        else for(int i = 2; i < 10; i+=2) {
                if (!board.cellAt(i).getFilled()) {
                    board.fillCell(board.cellAt(i), polarity);
                    target = board.cellAt(i);
                }
            }
        //then go to any open even square
        return target;
    }
}
//computer is playing not to lose but not particularly to win
