package projecteevee.eevilchess;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;


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
            for(int j = 0; j < rws; j++)
            {
                //Build row string part
                String row = "" + (j+1);
                //Build tile
                board.put(column + row, new Tile(i, j));
            }
        }
    }


    private Piece getRandomPieceWeighted(int xpos, int ypos, Player p, int difficultyfactor)
    {
        //Config constants for function
        //Random number will be 1 to RAND_BOUND-1
        final int RAND_BOUND = 101;
        //Random number must be <= the difficulty of the piece to become that piece
        //This is determined by lowest order piece first (Pawn < Knight < Rook < Bishop < Queen)
        final int PAWN_DIFFICULTY = (RAND_BOUND - 1)/5;
        final int KNIGHT_DIFFICULTY = 2*(RAND_BOUND - 1)/5;
        final int ROOK_DIFFICULTY = 3*(RAND_BOUND - 1)/5;
        final int BISHOP_DIFFICULTY = 4*(RAND_BOUND - 1)/5;
        final int QUEEN_DIFFICULTY = (RAND_BOUND - 1);
        //"Middle ground" of Eevil chess, the further away from this number you get,
        //the less RNG this function becomes
        //ex: on difficultyfactor of 10 it is impossible to get any piece other than pawns, knights and rooks
        final int NORMAL_DIFFICULTY = 5;

        double difficultysensitivity = difficultyfactor/(NORMAL_DIFFICULTY + 0.0);

        final int random = ThreadLocalRandom.current().nextInt(1, RAND_BOUND);

        if(random <= (PAWN_DIFFICULTY*difficultysensitivity))
        {
            //Pawn
            return new Pawn(xpos, ypos, p, this);
        }
        else if(random <= ((KNIGHT_DIFFICULTY*difficultysensitivity)))
        {
            //Knight
            return new Knight(xpos, ypos, p, this);
        }
        else if(random <= ((ROOK_DIFFICULTY*difficultysensitivity)))
        {
            //Rook
            return new Rook(xpos, ypos, p, this);
        }
        else if(random <= ((BISHOP_DIFFICULTY*difficultysensitivity)))
        {
            //Bishop
            return new Bishop(xpos, ypos, p, this);
        }
        else if(random <= ((QUEEN_DIFFICULTY*difficultysensitivity)))
        {
            //Queen
            return new Queen(xpos, ypos, p, this);
        }
        //This will never be hit unless the random number generator breaks
        return null;
    }

    private Piece getRandomPiece(int xpos, int ypos, Player p)
    {
        int random = ThreadLocalRandom.current().nextInt(0, 5);
        switch(random)
        {
            case 0:
                return new Pawn(xpos, ypos, p, this);
            case 1:
                return new Rook(xpos, ypos, p, this);
            case 2:
                return new Knight(xpos, ypos, p, this);
            case 3:
                return new Bishop(xpos, ypos, p, this);
            case 4:
                return new Queen(xpos, ypos, p, this);
            default:
                //Unless time breaks this will never be hit but it stops intellij from whining
                return null;
        }
    }

    //Helper function for populateTable
    //given a column number return the piece it matches on a normal chessboard on row 0
    private Piece getSpecialPiece(int num, int xpos, int ypos, Player p)
    {
        switch(num)
        {
            case 0:
            case 7:
                return new Rook(xpos, ypos, p, this);
            case 1:
            case 6:
                return new Knight(xpos, ypos, p, this);
            case 2:
            case 5:
                return new Bishop(xpos, ypos, p, this);
            case 3:
                return new King(xpos, ypos, p, this);
            case 4:
                return new Queen(xpos, ypos, p, this);
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
    public void populateTableNormal(Player white, Player black)
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

    public String getPieceImage(String pos)
    {
        Piece x = board.get(pos).getPiece();
        if(x == null)
        {
            return "";
        }
        return x.getImagePath();
    }

    public String getPieceImage(int x, int y)
    {
        return getPieceImage(("" + getCharValue(x)) + (y + 1));
    }

    public JSONObject getBoardJSON()
    {
        JSONObject fullboard = new JSONObject();
        JSONArray boardjson = new JSONArray();
        Iterator i = this.board.entrySet().iterator();
        while(i.hasNext())
        {
            JSONObject tilejson = new JSONObject();
            JSONObject piecejson = new JSONObject();
            JSONArray movelistjson = new JSONArray();

            Map.Entry tilekey = (Map.Entry)i.next();
            String tilename = (String)tilekey.getKey();

            //Location of the tile
            tilejson.put("tilename", tilename);
            tilejson.put("x", board.get(tilename).getX());
            tilejson.put("y", board.get(tilename).getY());

            //Check if tile is empty
            if(!board.get(tilename).isEmpty())
            {
                //Tile has a piece so add the name and its movelist
                for(Tile validmove : board.get(tilename).getPiece().validMoveList())
                {
                    JSONObject validmovejson = new JSONObject();
                    validmovejson.put("x", validmove.getX());
                    validmovejson.put("y", validmove.getY());
                    movelistjson.put(validmovejson);
                }
                piecejson.put(board.get(tilename).getPiece().getName(), movelistjson);
            }
            tilejson.put("piece", piecejson);
            boardjson.put(tilejson);
            i.remove();
        }
        fullboard.put("tiles", boardjson);
        return fullboard;
    }
}