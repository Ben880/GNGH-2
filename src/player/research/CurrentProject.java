package player.research;

import gui.BackEnd.DayTracker;

/*
    BenjaminWilcox
    Nov 30, 2016
    GNGH_2
 */
public class CurrentProject
{

    private static Tech current;
    private static int compleet;
    private static DayTracker day = new DayTracker();
    private static boolean inProgress = false;
    private static ListReader list = new ListReader();

    public CurrentProject()
    {

    }

    public void DayChange(int i)
    {
        if (i == compleet)
        {

        }
    }

    public boolean isReasearching()
    {
        return inProgress;
    }

    public void newProject(String tech)
    {
        current = list.getTech(tech);
        compleet = current.getTime() + day.getDay();
    }

    public double getProgress()
    {
        return (compleet - day.getDay()) / current.getTime();
    }

}
