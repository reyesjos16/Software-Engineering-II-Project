/* Queen movement pattern:
 *      X  X  X
 *       X X X
 *        XXX
 *XXXXXXXXXOXXXXXXXXX
 *        XXX
 *       X X X
 *      X  X  X
 */

public class Queen extends Piece
{
    Queen(int x, int y, Player p, Board b)
    {
        super("queen", p, b);
        this.setXcoordinate(x);
        this.setYcoordinate(y);
    }

    private boolean captured = false;

    public void move(int x, int y)
    {

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