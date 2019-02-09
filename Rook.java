/* Rook movement pattern:
 *         X
 *         X
 *         X
 *XXXXXXXXXOXXXXXXXXX
 *         X
 *         X
 *         X
 */

public class Rook extends Piece
{
    Rook(int x, int y, Player p, Board b)
    {
        super("rook", p, b);
        this.setXcoordinate(x);
        this.setYcoordinate(y);
    }

    private boolean captured = false;

    public boolean moveIsValid(String spot)
    {
        //TODO: implement
        return true;
    }

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