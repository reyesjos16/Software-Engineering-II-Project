package projecteevee.eevilchess.chessgame;

public class Tile
{
    int x,y;
    private Piece holding;

    Tile(int xcord, int ycord)
    {
        x = xcord;
        y = ycord;
        holding = null;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
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
