/* The Bishop moves diagonally on either light or dark squares */
package projecteevee.eevilchess.chessgame;

import java.util.ArrayList;

public class Bishop extends Piece {

    Bishop(int x, int y, Player p, Board b) {
        super("bishop", p, b);
        this.setXcoordinate(x);
        this.setYcoordinate(y);
    }
    // TODO: Add Bishop specific functionality
    public void move(int x, int y) {
        
    }

    public void capture() {
        // if a piece exists on the square to which this piece
        // is moved, that piece is captured.
    }

    public boolean captured() {
        // Not sure if this is required; if it is not, it will be removed
        return false;
    }

    public ArrayList<Tile> validMoveList()
    {
        ArrayList<Tile> movelist = new ArrayList<>();
        //up right
        movelist.addAll(getValidMoves(this, 1 ,1));
        //down right
        movelist.addAll(getValidMoves(this, 1, -1));
        //down left
        movelist.addAll(getValidMoves(this, -1, -1));
        //up left
        movelist.addAll(getValidMoves(this, -1, 1));
        return movelist;
    }
}