package projecteevee.eevilchess;

public class Game extends Thread
{
    private int starttime;
    private boolean timed, tournytime;
    private EevilClock player1_clock, player2_clock;
    private String game_id;
    private String player1_id;
    private String player2_id;
    private String turn_duration;
    private String board_dimensions;
    private Boolean randomize_pieces;

    Game()
    {
        super();
        timed = false;
    }

    Game(boolean singletime, int start)
    {
        super();
        tournytime = singletime;
        timed = true;
        player1_clock = new EevilClock(start);
        player2_clock = new EevilClock(start);
        starttime = start;
        player1_clock.start();
        player2_clock.start();
    }

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

    @Override
    public void run()
    {
        boolean gameover = false, player1turn = true;
        String winner = "";
        //TODO: Pass both players the board here
        while(!gameover)
        {
            if(timed && !tournytime)
            {
                player1_clock.setTime(starttime);
                player2_clock.setTime(starttime);
            }
            //Player1 turn
            if(timed)
            {
                player1_clock.unpause();
            }
            while(player1turn)
            {
                //TODO: Get response/move (might require another thread so this continues checking the timer)

                if(timed)
                {
                    if(player1_clock.done())
                    {
                        winner = player2_id;
                    }
                }
            }

            if(timed)
            {
                player1_clock.pause();
                //Player2 turn
                player2_clock.unpause();
            }
            if(!winner.equals(""))
            {
                while(!player1turn)
                {
                    //TODO: Get response/move (might require another thread so this continues checking the timer)

                    if(timed)
                    {
                        if(player2_clock.done())
                        {
                            winner = player1_id;
                        }
                    }
                }
            }

            if(timed)
            {
                player2_clock.pause();
            }

            gameover = !winner.equals("");
        }
        if(timed)
        {
            try
            {
                player1_clock.join();
                player2_clock.join();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
}

