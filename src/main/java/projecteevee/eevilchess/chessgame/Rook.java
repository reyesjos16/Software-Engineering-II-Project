/* Rook movement pattern:
 *         X
 *         X
 *         X
 *XXXXXXXXXOXXXXXXXXX
 *         X
 *         X
 *         X
 */
package projecteevee.eevilchess.chessgame;

import java.util.ArrayList;

public class Rook extends Piece
{
    Rook(int x, int y, Player p, Board b)
    {
        super("rook", p, b);
        this.setXcoordinate(x);
        this.setYcoordinate(y);
    }

    private boolean captured = false;

    public ArrayList<Tile> validMoveList()
    {
        ArrayList<Tile> movelist = new ArrayList<>();
        //up
        movelist.addAll(getValidMoves(this, 0, 1));
        //right
        movelist.addAll(getValidMoves(this, 1, 0));
        //down
        movelist.addAll(getValidMoves(this, 0, -1));
        //left
        movelist.addAll(getValidMoves(this, -1, 0));
        return movelist;
    }

    public void capture()
    {
        captured = true;
    }

    public boolean captured()
    {
        return captured;
    }
}