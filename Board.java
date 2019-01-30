import java.util.HashMap;
import java.util.Map;

public class board
{
    private static final int MAX_COLS = 26;
    private Map<String, Object> board = null;
    //Placeholder for tile object
    Object TILE;

    board(int cols, int rows)
    {
        this.buildTable(cols, rows);
    }

    private void buildTable(int cols, int rows)
    {
        //Temp solution
        //TODO: Make columns infinitely expandable like rows
        if(cols > MAX_COLS)
        {
            cols = MAX_COLS;
        }
        for(int i = 0; i < cols; i++)
        {
            String column = "" + getCharValue(i);
            for(int j = 1; j < rows+1; j++)
            {
                String row = "" + i;
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

    public TILE getTile(String position)
    {
        if(board.containsKey(position))
        {
            return board.get(position);
        }
        else
        {
            return null;
        }
    }

    public void placeOnTile(String position, Object TILE)
    {
        board.put(position, TILE);
    }
}