/*
*   Piece is an abstract class that provides each game piece with
*   common functions.
*
*
* */

public abstract class Piece
{

    // Member variables
    protected int xcoordinate;  // X coordinate
    protected int ycoordinate;  // Y coordinate
    protected String name;      // Piece name (knight, rook, pawn, king, queen, bishop)
    protected Player player;    // Player this piece belongs to (black, white?)
    protected String imagePath; // Path to piece image, for GUI purposes
    protected Board board;      // Current chess board

    // Constructor
    public Piece(String pieceName, Player player, Board board) {
        this.name = pieceName;
        this.player = player;
        this.name = name;
        this.xcoordinate = -1;   // Set location to "null"
        this.ycoordinate = -1;   // TODO: Discuss what should be used for null value?
        this.board = board;
    }

    // Abstract functions each piece must have
    
    // Changed move() to validMoveList(). Might make more sense for the player to move,
    // and each piece knows it's own valid moves
    public abstract ArrayList<Tile> validMoveList();

    // TODO: Decide if capture() and captured() are still necessary

    // Capture opponents piece
    public abstract void capture();

    // Recognize and handle being captured
    public abstract boolean captured();

    /* Getters */

    public int getXcoordinate() { return this.xcoordinate; }

    public int getYCoordinate() { return this.ycoordinate; }

    public String getName() { return this.name; }

    public Player getPlayer() { return this.player; }

    public String getImagePath() { return this.imagePath; }

    public String getBoard() { return this.board; }

    /* Setters */

    public void setXCoordinate(int newX) { this.xcoordinate = newX; }

    public void setYCoordinate(int newY) { this.ycoordinate = newY; }

    public void setName(String pieceName) { this.name = pieceName; }

    public void setPlayer(Player player) { this.player = player; }

    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public void setBoard(Board board) { this.board = board; }
    // King will implement it's own "threatened" method

    // Special moves (since not all pieces have them) should be handled for each piece
}
