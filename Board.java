import java.util.HashMap;
import java.util.Map;

public class Board
{
    private static final int MAX_COLS = 26;
    private HashMap<String, Tile> board = null;
    private int columns = 0, rows = 0;
    //Placeholder for tile object
    Object TILE;

    Board(int cols, int rows)
    {
        this.buildTable(cols, rows);
    }

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
                //How should we build the tile? default constr?
                Tile newtile = new Tile();
                board.put(column + row, newtile);
            }
        }
    }

    private static char getCharValue(int i)
    {
        return (char)(i+97);
    }

    public HashMap<String, Tile> getBoard()
    {
        return board;
    }

    public int colCount()
    {
        return columns;
    }

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

    //TODO: change this to add pieces to a tile rather than tiles to the board
    public void placeOnTile(String position, Tile newtile)
    {
        board.put(position, newtile);
    }
}