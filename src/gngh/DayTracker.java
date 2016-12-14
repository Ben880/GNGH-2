package gngh;

import event.EventDispatcher;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class DayTracker
{

    private static int day = 0;
    private static GUIHandler gui = GUIHandler.getInstance();
    private static EventDispatcher event = new EventDispatcher();

    public DayTracker()
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
