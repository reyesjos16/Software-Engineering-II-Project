package projecteevee.eevilchess.chessgame;

public class Player
{
    private boolean iswhite;
    Player(String clr)
    {
        iswhite = clr.toLowerCase().equals("white");
    }



    public String getColor()
    {
        if(iswhite)
        {
            return "white";
        }
        else return "black";
    }

    public void move(int x, int y)
    {

    }


}
