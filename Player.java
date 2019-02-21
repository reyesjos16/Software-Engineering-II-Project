public class Player
{
    private boolean iswhite;

    //clr should always be white or black, case insensitive
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
