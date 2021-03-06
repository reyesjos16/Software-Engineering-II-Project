package projecteevee.eevilchess.chessgame;

//join() must be called before the main thread exits to clean up
public class EevilClock extends Thread
{
    //Mutex lock
    static private boolean lock = false;

    //TODO: How will the timer contact the player client?
    //Thread starts paused
    private boolean paused = true;
    private int tickrate;
    private int time;
    private boolean thread_alive = true;

    //Customize time, 1s tickrate
    EevilClock(int ticks)
    {
        super();
        time = ticks;
        tickrate = 1000;
    }

    //Customize time and tickrate
    EevilClock(int ticks, int tickr)
    {
        super();
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

    public boolean done()
    {
        return time <= 0;
    }

    public void end()
    {
        while(true)
        {
            if(!lock)
            {
                lock = true;
                thread_alive = false;
                time = 0;
                lock = false;
                break;
            }
        }
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

    private void tick()
    {
        while(true)
        {
            if(!lock)
            {
                lock = true;
                if(thread_alive)
                {
                    time--;
                    System.out.println(time);
                }
                lock = false;
                break;
            }
        }
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

    @Override
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
                    time = -1;
                }
            }
        }
        //TODO: what should the timer do when it runs out of time?
    }
}
