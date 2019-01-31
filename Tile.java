public class Tile
{
    private Piece holding;

    Tile()
    {
        holding = null;
    }

    public boolean isEmpty()
    {
        return holding == null;
    }

    public Piece getPiece()
    {
        return holding;
    }

    public void setPiece(Piece newpiece)
    {
        holding = newpiece;
    }
}
