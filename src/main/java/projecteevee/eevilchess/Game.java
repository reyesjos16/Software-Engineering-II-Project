package projecteevee.eevilchess;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Game
{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String gameID;

    private String player1;
    private String player2;

    public Integer getID()
    {
        return id;
    }

    public void setID(Integer id)
    {
        this.id = id;
    }

    public String getGameID()
    {
        return gameID;
    }

    public void setGameID(String game_id)
    {
        this.gameID = game_id;
    }

    public String getPlayer1()
    {
        return player1;
    }

    public void setPlayer1(String p)
    {
        this.player1 = p;
    }

    public String getPlayer2()
    {
        return player2;
    }

    public void setPlayer2(String p)
    {
        this.player2 = p;
    }

    @Override
    public String toString()
    {
        return String.format(
        "[Game[GameID='%s', Player1='%s', Player2='%s']",
        gameID, player1, player2
        );
    }
}