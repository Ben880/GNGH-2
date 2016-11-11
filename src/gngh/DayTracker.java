package gngh;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class DayTracker
{

    private int day;
    Tracker tracker;
    Handler handler;

    public DayTracker(Tracker t)
    {
        tracker = t;
        day = 0;
    }

    public void Initialize(Tracker t, Handler h)
    {
        handler = h;
    }

    public void incriment(int amount)
    {
        int i = 0;
        //migrate to hierarchy
        ResourceProduction production;
        production = ResourceProduction.getInstance();

        while (i < amount)
        {
            day++;
            tracker.event().dayChange(day);
            production.dayChange();
            i++;
        }
        handler.gui().label().resourceUpdate();
    }

    public int getDay()
    {
        return day;
    }
}
