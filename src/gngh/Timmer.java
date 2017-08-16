package gngh;

import gui.BackEnd.DayTracker;
import gui.BackEnd.UpdateDayProgress;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
    BenjaminWilcox
    Aug 16, 2017
    GNGH2
 */
public class Timmer extends Thread
{

    private static final int TIME = 1000;
    private static UpdateDayProgress progress = new UpdateDayProgress();

    @Override
    public void run()
    {
        System.out.println("Hello from a thread!");
        progress.setToltal(TIME);
        loop();
    }

    private void loop()
    {
        while (true)
        {
            for (int i = 0; i < TIME; i++)
            {
                try
                {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException ex)
                {
                    Logger.getLogger(Timmer.class.getName()).log(Level.SEVERE, null, ex);
                }
                progress.updateProgress(i);
            }

            new DayTracker().incrimentOverride(1);
        }
    }
}
