package projecteevee.eevilchess;

public class Game
{
    private String game_id;
    private String player1_id;
    private String player2_id;
    private String turn_duration;
    private String board_dimensions;
    private Boolean randomize_pieces;

    public String getGameID()
    {
        return this.game_id;
    }

    public void setGameID(String id)
    {
        this.game_id = id;
    }

    public String getPlayer1_ID()
    {
        return this.player1_id;
    }

    public void setPlayer1_ID(String id)
    {
        this.player1_id = id;
    }

    public String getPlayer2_ID()
    {
        return this.player2_id;
    }

    public void setPlayer2_ID(String id)
    {
        this.player2_id = id;
    }

    public String getBoardDimensions()
    {
        return this.board_dimensions;
    }

    public void setBoardDimensions(String dimensions)
    {
        this.board_dimensions = dimensions;
    }

    public String getTurnDuration()
    {
        return this.turn_duration;
    }

    public void setTurnDuration(String duration)
    {
        this.turn_duration = duration;
    }

    public Boolean isRandomized()
    {
        return this.randomize_pieces;
    }

    public void setRandomizedGame(Boolean random_game)
    {
        this.randomize_pieces = random_game;
    }
}

