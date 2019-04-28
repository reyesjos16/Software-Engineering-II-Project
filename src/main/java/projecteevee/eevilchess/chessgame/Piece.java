package projecteevee.eevilchess.chessgame;

/*
*   Piece is an abstract class that provides each game piece with
*   common functions.
*
*
* */

import java.util.ArrayList;

public abstract class Piece
{

    // Member variables
    protected int xcoordinate;  // X coordinate
    protected int ycoordinate;  // Y coordinate
    protected String name;      // Piece name (knight, rook, pawn, king, queen, bishop)
    protected Player player;    // Player this piece belongs to (black, white?)
    protected String imagePath; // Path to piece image, for GUI purposes
    protected Board board;      // Current chess board
    protected ArrayList<Tile> movelist; //movelist

    // Constructor
    public Piece(String pieceName, Player player, Board board) {
        this.name = pieceName;
        this.player = player;
        this.name = name;
        this.xcoordinate = -1;   // Set location to "null"
        this.ycoordinate = -1;   // TODO: Discuss what should be used for null value?
        this.board = board;
        this.imagePath = "./pieces/" + player.getColor() + "_" + pieceName + ".png";
        this.movelist = new ArrayList<>();
    }

    // Abstract functions each piece must have
    
    // TODO: Discuss whether pieces should move themselves (current model)
    // or have Player move pieces (would require validMoveList(), currently
    // commented out below:
    
    public abstract ArrayList<Tile> validMoveList();

    public void updateMoves()
    {
        movelist = validMoveList();
    }

    public void move(int x, int y)
    {
        this.board.getTile(this.getXcoordinate(), this.getYcoordinate()).setPiece(null);
        this.xcoordinate = x;
        this.ycoordinate = y;
        this.board.placeOnTile(x, y, this);
        this.updateMoves();
    }

    // TODO: Decide if capture() and captured() are still necessary

    // Capture opponents piece
    public abstract void capture();

    // Recognize and handle being captured
    public abstract boolean captured();

    /* Getters */

    public int getXcoordinate() { return this.xcoordinate; }

    public int getYcoordinate() { return this.ycoordinate; }

    public String getName() { return this.name; }

    public Player getPlayer() { return this.player; }

    public String getImagePath() { return this.imagePath; }

    public Board getBoard() { return this.board; }

    public ArrayList<Tile> getMovelist()
    {
        return movelist;
    }

    /* Setters */

    public void setXcoordinate(int newX) { this.xcoordinate = newX; }

    public void setYcoordinate(int newY) { this.ycoordinate = newY; }

    public void setName(String pieceName) { this.name = pieceName; }

    public void setPlayer(Player player) { this.player = player; }

    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public void setBoard(Board board) { this.board = board; }

    public void setMovelist(ArrayList<Tile> moves) { movelist = moves; }
    // King will implement it's own "threatened" method

    // Special moves (since not all pieces have them) should be handled for each piece

    //incx = 0, incy  =  1 for incrementing up
    //incx = 1, incy  =  1 for up and right
    //incx = 1, incy  =  0 for incrementing to right
    //incx = -1, incy = -1 for incrementing to the right and down
    //incx = 0, incy  = -1 for incrementing down
    //incx = -1, incy = -1 for incrementing down and to the left
    //incx = -1, incy =  0 for incrementing left
    //incx = -1, incy =  1 for incrementing left and up
    //format(incx,incy)     (i got tired typing incx = ... incy = ...)
    //Bishop will use (1,1),(1,-1),(-1,-1),(-1,1)
    //Rook will use (0,1),(1,0),(0,-1),(-1,0)
    //Queen will use both rook's and bishop's movements
    //
    //x = piece x coords
    //y = piece y coords
    //incx, incy explained above
    //board is the board the piece is on
    //p is the player the piece belongs to
    public static ArrayList<Tile> getValidMoves(int x, int y, int incx, int incy, Board board, Player p)
    {
        ArrayList<Tile> movelist = new ArrayList<>();
        for(int i = 1; board.getTile(x+(incx*i), y+(incy*i)) != null; i++)
        {
            Tile nextmove = board.getTile(x+(incx*i), y+(incy*i));
            if(!nextmove.isEmpty())
            {
                //Tile is occupied, check if enemy
                if(!nextmove.getPiece().getPlayer().getColor().equals(p.getColor()))
                {
                    //Enemy piece
                    movelist.add(nextmove);
                }
                //End piece hit, cannot jump pieces so end incrementing
                break;
            }
            else
            {
                //Tile is not occupied
                movelist.add(nextmove);
            }
        }
        return movelist;
    }

    //Lazy helper function, pass piece instead of parts of piece
    public static ArrayList<Tile> getValidMoves(Piece p, int incx, int incy)
    {
        return getValidMoves(p.getXcoordinate(), p.getYcoordinate(), incx, incy, p.getBoard(), p.getPlayer());
    }
}
