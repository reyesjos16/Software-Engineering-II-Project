/*
*   General Piece is an abstract class that provides each game piece with
*   common functions.
*
*
* */

public abstract class Piece
{
    // Current location of piece on the board
    protected int xcoordinate;
    protected int ycoordinate;

    // Abstract functions each piece must have
    
    // TODO: Define what input for move is required
    public abstract void move(int newX, int newY);

    // TODO: Define input for capture and captured
    // TODO: Is captured required?
    public abstract void capture();

    public abstract boolean captured();

    // Location getter
    public int[] getLoc() {
        arrLocation = new int[2];
        arrLocation[0] = this.xcoordinate;
        arrLocation[1] = this.ycoordinate;
        return arrLocation;
    }

    // Location setter
    public void setLoc(int newX, int newY) {
        this.xcoordinate = newX;
        this.ycoordinate = newY;
    }

    // King will implement it's own "threatened" method

    // Special moves (since not all pieces have them) should be handled for each piece
}
