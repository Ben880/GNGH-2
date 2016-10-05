package gngh;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class DayTracker
{

    private static DayTracker instance = null;
    private int day;
    EventHandler event;
    //EventCreation event;

    private DayTracker()
    {
        day = 0;
    }

    public static DayTracker getInstance()
    {
        if (instance == null)
        {
            instance = new DayTracker();
        }
        return instance;
    }

    public void incriment(int amount)
    {
        int i = 0;
        ResourceProduction production;
        production = ResourceProduction.getInstance();
        event = EventHandler.getInstance();
        while (i < amount)
        {
            day++;
            event.dayChange(day);
            production.dayChange();
            i++;
        }
        LabelHandler lables;
        lables = LabelHandler.getInstance();
        lables.resourceUpdate();
    }

    public int getDay()
    {
        return day;
    }

}
