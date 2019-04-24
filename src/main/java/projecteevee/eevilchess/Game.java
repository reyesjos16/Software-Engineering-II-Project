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

    private Integer p1_eevil_num;
    private Integer p2_eevil_num;

    private String p1_piece_list;
    private String p2_piece_list;

    private Integer board_dimensions;

    private String p1_move_list;
    private String p2_move_list;

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

    public Integer getBoardDimensions()
    {
        return board_dimensions;
    }

    public void setBoardDimensions(Integer dimensions)
    {
        this.board_dimensions = dimensions;
    }

    public Integer getEevilNumber(Integer playerNumber)
    {
        if(playerNumber == 1)
        {
            return p1_eevil_num;
        }
        else
        {
            return p2_eevil_num;
        }
    }

    public void setEevilNumber(Integer playerNumber, Integer eevilNum)
    {
        if(playerNumber == 1)
        {
            this.p1_eevil_num = eevilNum;
        }
        else
        {
            this.p2_eevil_num = eevilNum;
        }
    }

    public void initializePieceList(String playerID, String pieceList)
    {
        Integer playerNumber;

        if(this.player1.contentEquals(playerID))
        {
            playerNumber = 1;
        }
        else
        {
            playerNumber = 2;
        }
        
        if(playerNumber == 1)
        {
            this.p1_piece_list = pieceList;
        }
        else
        {
            this.p2_piece_list = pieceList;
        }
    }

    public String showStartingPieces(Integer playerNumber, String pieceList)
    {
        if(playerNumber == 1)
        {
            return this.p1_piece_list;
        }
        else
        {
            return this.p2_piece_list;
        }
    }

    public void updateMoveList(String playerID, String move)
    {
        /* System.out.println(this.player1);
        System.out.println(this.player2);
        System.out.println(this.player1 == playerID);
        System.out.println(this.player1.length());
        System.out.println(playerID.length());
        System.out.println(this.player1.contentEquals(playerID)); */

        if(this.player1.contentEquals(playerID))
        {
            this.p1_move_list = p1_move_list + move;
        }
        else
        {
            this.p2_move_list = p2_move_list + move;
        }
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