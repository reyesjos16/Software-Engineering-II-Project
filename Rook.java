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
    private boolean captured = false;

    public boolean moveIsValid(String spot)
    {
        //TODO: implement
        return true;
    }

    public void move(String spot)
    {
        this.location = spot;
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