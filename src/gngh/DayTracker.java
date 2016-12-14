package gngh;

import event.EventDispatcher;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class DayTracker
{

    private int day;
    Tracker tracker;
    GUIHandler gui;
    EventDispatcher event = new EventDispatcher();

    public DayTracker(Tracker t)
    {
        tracker = t;
        day = 0;
        gui = GUIHandler.getInstance();
    }

    public void Initialize(Tracker t)
    {

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
            event.dayChange(day);
            production.dayChange();
            i++;
        }
        gui.label().resourceUpdate();
    }

    public int getDay()
    {
        return day;
    }
}
