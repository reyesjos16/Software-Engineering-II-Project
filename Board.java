import java.util.HashMap;

public class Board
{
    private static final int MAX_COLS = 26;
    private HashMap<String, Tile> board = null;
    private int columns = 0, rows = 0;

    Board(int cols, int rows)
    {
        this.buildTable(cols, rows);
    }

    //Builds a table given the dimensions wanted
    private void buildTable(int cols, int rws)
    {
        board = new HashMap<>();
        //Temp solution
        //TODO: Make columns infinitely expandable like rows
        if(cols > MAX_COLS)
        {
            cols = MAX_COLS;
        }
        columns = cols;
        rows = rws;
        for(int i = 0; i < cols; i++)
        {
            //Build column string part
            String column = "" + getCharValue(i);
            for(int j = 1; j < rws+1; j++)
            {
                //Build row string part
                String row = "" + j;
                //Build tile
                //TODO: How should we build the tile? default constr?
                Tile newtile = new Tile();
                board.put(column + row, newtile);
            }
        }
    }

    //Helper function for populateTable
    //given a column number return the piece it matches on a normal chessboard on row 0
    private Piece getSpecialPiece(int num, int xpos, int ypos, Player p)
    {
        switch(num)
        {
            case 0:
                return new Rook(xpos, ypos, p, this);
            case 1:
                return new Knight(xpos, ypos, p, this);
            case 2:
                return new Bishop(xpos, ypos, p, this);
            case 3:
                return new King(xpos, ypos, p, this);
            case 4:
                return new Queen(xpos, ypos, p, this);
            case 5:
                return new Bishop(xpos, ypos, p, this);
            case 6:
                return new Knight(xpos, ypos, p, this);
            case 7:
                return new Rook(xpos, ypos, p, this);
            default:
                return null;
        }
    }

    /* Populates a board with the normal initial chess pieces
     *
     * rows - 1 row
     * rows - 2 row (pawn row)
     * ...
     * row 1 (pawn row)
     * row 0
     *
     * white special pieces will always be row 0 while blacks will be rows - 1
     * white pawns will always be row 1 while blacks will be rows - 2
     * Taking these assumptions we only need to find the X starting positions to iterate on for white and black
     * Build white left to right and build black right to left
     *
     * MINIMUM BOARD SIZE OF 8 COLUMNS AND 4 ROWS
     */
    private void populateTableNormal(Player white, Player black)
    {
        if(columns < 8 || rows < 4)
        {
            System.err.println("populateTableNormal called on board with invalid size");
        }
        //Starting positions for iterations, assumes board is at least 8 columns
        int startcolW = (columns/2) - 4; //0 on an 8x? board
        int startcolB = (columns/2) + 3; //7 on an 8x? board
        //Place pieces
        for(int i = 0; i < 8; i++)
        {
            //White special piece
            this.placeOnTile(startcolW + i, 0, getSpecialPiece(i, startcolW + i, 0, white));
            //White pawn
            this.placeOnTile(startcolW + i, 1, new Pawn(startcolW + i, 1, white, this));
            //Black special piece
            this.placeOnTile(startcolB - i, rows - 1, getSpecialPiece(i, startcolB - i, rows - 1, black));
            //Black pawn
            this.placeOnTile(startcolB - i, rows - 2, new Pawn(startcolB - i, rows - 2, black, this));
        }
    }

    //ACII value of lowercase letters
    //0  = a
    //1  = b
    //...
    //25 = z
    private static char getCharValue(int i)
    {
        return (char)(i+97);
    }

    //Get the board
    public HashMap<String, Tile> getBoard()
    {
        return board;
    }

    //How many columns are on the board?
    public int colCount()
    {
        return columns;
    }

    //How many rows are on the board?
    public int rowCount()
    {
        return rows;
    }

    //Returns tile if it exists
    //null if tile doesn't exist
    //format: <column_char><row_index>
    //ex: "a1"; b6; d3; etc.
    public Tile getTile(String position)
    {
        return board.get(position);
    }

    //0,0 = a1; 1,1 = b2; 2,2 = c3; etc.
    public Tile getTile(int col, int row)
    {
        return this.getTile("" + getCharValue(col) + (row + 1));
    }

    public void placeOnTile(String position, Piece chesspiece)
    {
        this.board.get(position).setPiece(chesspiece);
    }

    public void placeOnTile(int x, int y, Piece chesspiece)
    {
        this.placeOnTile(("" + getCharValue(x)) + (y + 1), chesspiece);
    }
}