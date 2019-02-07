import java.util.HashMap;
import java.util.Map;

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
    public Tile getTile(String position)
    {
        return board.get(position);
    }

    public Tile getTile(int col, int row)
    {
        return this.getTile("" + getCharValue(col) + row);
    }

    public void placeOnTile(String position, Piece chesspiece)
    {
        this.board.get(position).setPiece(chesspiece);
    }
}