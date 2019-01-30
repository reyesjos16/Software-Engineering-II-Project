import java.util.HashMap;
import java.util.Map;

public class board
{
    private static final int MAX_COLS = 26;
    private Map<String, Object> board = null;
    private int columns = 0, rows = 0;
    //Placeholder for tile object
    Object TILE;

    board(int cols, int rows)
    {
        this.buildTable(cols, rows);
    }

    private void buildTable(int cols, int rws)
    {
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
                board.put(column + row, TILE);
            }
        }
    }

    private char getCharValue(int i)
    {
        return (char)(i+97);
    }

    public Map<String, Object> getBoard()
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
    public TILE getTile(String position)
    {
        return board.get(position);
    }

    public void placeOnTile(String position, Object TILE)
    {
        board.put(position, TILE);
    }
}