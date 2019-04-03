package projecteevee.eevilchess;

public class EevilClock extends Thread
{
    //TODO: How will the timer contact the player client?
    //Thread starts paused
    private boolean paused = true;
    private int tickrate;
    private int time;

    //Customize time, 1s tickrate
    EevilClock(int ticks)
    {
        time = ticks;
        tickrate = 1000;
    }

    //Customize time and tickrate
    EevilClock(int ticks, int tickr)
    {
        time = ticks;
        tickrate = tickr;
    }

    public boolean isPaused()
    {
        return paused;
    }

    public void setTime(int t)
    {
        time = t;
    }

    public int getTime()
    {
        return time;
    }

    //Add time
    public void addTime(int t)
    {
        time = time + t;
    }

    //Remove time
    public void rmTime(int t)
    {
        time = time - t;
    }

    public void die()
    {
        time = 0;
    }

    private void tick()
    {
        time--;
        //TODO: Send client new time?
    }

    public void unpause()
    {
        paused = false;
    }

    public void pause()
    {
        paused = true;
    }

    public void run()
    {
        while(time > 0)
        {
            if(!paused)
            {
                try
                {
                    Thread.sleep(tickrate);
                    tick();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                    this.die();
                }
            }
        }
        //TODO: what should the timer do when it runs out of time?
    }
}
