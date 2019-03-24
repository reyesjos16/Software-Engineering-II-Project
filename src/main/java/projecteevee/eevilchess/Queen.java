/* Queen movement pattern:
 *      X  X  X
 *       X X X
 *        XXX
 *XXXXXXXXXOXXXXXXXXX
 *        XXX
 *       X X X
 *      X  X  X
 */
package projecteevee.eevilchess;

import java.util.ArrayList;

public class Queen extends Piece
{
    Queen(int x, int y, Player p, Board b)
    {
        super("queen", p, b);
        this.setXcoordinate(x);
        this.setYcoordinate(y);
    }

    private boolean captured = false;

    public ArrayList<Tile> validMoveList()
    {
        ArrayList<Tile> movelist = new ArrayList<>();
        //up
        movelist.addAll(getValidMoves(this, 0, 1));
        //up right
        movelist.addAll(getValidMoves(this, 1 ,1));
        //right
        movelist.addAll(getValidMoves(this, 1 ,0));
        //down right
        movelist.addAll(getValidMoves(this, 1, -1));
        //down
        movelist.addAll(getValidMoves(this, 0, -1));
        //down left
        movelist.addAll(getValidMoves(this, -1, -1));
        //left
        movelist.addAll(getValidMoves(this, -1, 0));
        //up left
        movelist.addAll(getValidMoves(this, -1, 1));
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