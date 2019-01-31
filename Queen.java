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
    private boolean captured = false;

    public void move(String spot)
    {
        this.setLoc(spot);
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