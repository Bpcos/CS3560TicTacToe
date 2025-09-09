package org.example;

public class Line {
    //a Line is the three cells that constitute a win state
    private Cell one, two, three;

    Line(Cell a, Cell b, Cell c){
        this.one = a;
        this.two = b;
        this.three = c;
    }

    public boolean winCon(){
        if(one.getFilled() && two.getFilled() && three.getFilled()){
            boolean a = one.getX(), b = two.getX(), c = three.getX();
            return a == b && b == c;
        }else return false;
    }

    protected Cell nearWin(boolean X){
        //the computer will use this method to find and block near win lines
        boolean a = one.getFilled(), b = two.getFilled(), c = three.getFilled();
        if((a&&b&&!c)||(a&&!b&&c)||(!a&&b&&c)){
            //boolean logic to find if a line contains 2 filled and 1 empty cell
            if( (one.getX() == X) || (two.getX() == X) ){
                //check to see which player holds the given line
                if(!a) return one;
                if(!b) return two;
                return three;
            }
        } return null;
    }

    public boolean contains(Cell cell){
        return cell == one || cell == two || cell == three;
    }
}
