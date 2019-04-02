package projecteevee.eevilchess;

public class EevilClock
{
    //TODO: How will the timer contact the player client?
    boolean paused = true;
    int time;

    public boolean isPaused()
    {
        return paused;
    }

    public int getTime()
    {
        return time;
    }

    public void die()
    {
        time = 0;
    }

    private void second()
    {
        time--;
        //TODO: Send client new time?
    }

    public void start()
    {
        paused = false;
    }

    public void pause()
    {
        paused = true;
    }

    public void run(int secs)
    {
        time = secs;
        while(true)
        {
            if(!paused)
            {
                try
                {
                    Thread.sleep(1000);
                    second();
                    if(time <= 0)
                    {
                        //TODO: what should the timer do when it runs out of time?
                        break;
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                    this.die();
                }
            }
        }
    }
}
