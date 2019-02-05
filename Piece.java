/*
*   General Piece is an abstract class that provides each game piece with
*   common functions.
*
*
* */

public abstract class Piece
{
    // Current location of piece on the board
    private String location = null;

    // Abstract functions each piece must have
    
    // TODO: Define what input for move is required
    public abstract void move();

    // TODO: Define input for capture and captured
    // TODO: Is captured required?
    public abstract void capture();

    public abstract boolean captured();

    // Location getter
    public String getLoc() {
        return this.location;
    }

    // Location setter
    public void setLoc(String loc) {
        this.location = loc;
    }

    // King will implement it's own "threatened" method

    // Special moves (since not all pieces have them) should be handled for each piece
}
