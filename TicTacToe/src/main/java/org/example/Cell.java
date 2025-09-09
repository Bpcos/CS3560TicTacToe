package org.example;

public class Cell {
    private boolean isFilled, isX;
    //A cell is one unit of the Board. it can be empty or filled X/O.
    public Cell()
    {
        this.isFilled = false;
    }
    public void setFilled(boolean X)
    {
        this.isFilled = true;
        isX = X;
    }
    public boolean getX()
    {
        return isX;
    }

    public boolean getFilled()
    {
        return isFilled;
    }


}
