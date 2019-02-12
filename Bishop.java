/* The Bishop moves diagonally on either light or dark squares */

public class Bishop extends Piece {

    Bishop(int x, int y, Player p, Board b) {
        super("bishop", p, b);
        this.setXcoordinate(x);
        this.setYcoordinate(y);
    }
    // TODO: Add Bishop specific functionality
    public void move(String location) {
        // Changes the piece's location to a new square
        this.location = location;
    }

    public void capture() {
        // if a piece exists on the square to which this piece
        // is moved, that piece is captured.
    }

    public void captured() {
        // Not sure if this is required; if it is not, it will be removed
    }
}
