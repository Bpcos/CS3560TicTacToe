package org.example;

public class Board {
    //the board is a collection of 9 cells arranged in a grid
    private Cell A1, A2, A3, B1, B2, B3, C1, C2, C3;
    private Line col1,col2,col3,rowA,rowB,rowC,diagUp,diagDown;
    private int turn;

    public Board(){
        turn = 1;
        A1 = new Cell();
        A2 = new Cell();
        A3 = new Cell();
        B1 = new Cell();
        B2 = new Cell();
        B3 = new Cell();
        C1 = new Cell();
        C2 = new Cell();
        C3 = new Cell();
        col1 = new Line(A1,B1,C1);
        col2 = new Line(A2,B2,C2);
        col3 = new Line(A3,B3,C3);
        rowA = new Line(A1,A2,A3);
        rowB = new Line(B1,B2,B3);
        rowC = new Line(C1,C2,C3);
        diagDown = new Line(A1,B2,C3);
        diagUp = new Line(A3,B2,C1);
    }



    public void fillCell(Cell cell, boolean X){
        cell.setFilled(X);
    }
    public void turnAdvance(){
        turn++;
    }
    public  int getTurn(){
        return turn;
    }

    public boolean checkWin(Cell cell){
        boolean test = false;
        if(col1.contains(cell)) test = test || col1.winCon();
        if(col2.contains(cell)) test = test || col2.winCon();
        if(col3.contains(cell)) test = test || col3.winCon();
        if(rowA.contains(cell)) test = test || rowA.winCon();
        if(rowB.contains(cell)) test = test || rowB.winCon();
        if(rowC.contains(cell)) test = test || rowC.winCon();
        if(diagUp.contains(cell)) test = test || diagUp.winCon();
        if(diagDown.contains(cell)) test = test || diagDown.winCon();
        return test;
    }

    public Cell checkNear(Boolean X){
        //sloppy
        Cell test;
        test = col1.nearWin(X);
        if(test != null) return test;
        test = col2.nearWin(X);
        if(test != null) return test;
        test = col3.nearWin(X);
        if(test != null) return test;
        test = rowA.nearWin(X);
        if(test != null) return test;
        test = rowB.nearWin(X);
        if(test != null) return test;
        test = rowC.nearWin(X);
        if(test != null) return test;
        test = diagDown.nearWin(X);
        if(test != null) return test;
        test = diagUp.nearWin(X);
        return test;
    }

    public Cell cellAt(int X){
        //cheap and dirty, but it'll work
        return switch (X) {
            case 1 -> A1;
            case 2 -> A2;
            case 3 -> A3;
            case 4 -> B1;
            case 5 -> B2;
            case 6 -> B3;
            case 7 -> C1;
            case 8 -> C2;
            case 9 -> C3;
            default -> null;
        };

    }



}
