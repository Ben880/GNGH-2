package gngh;

import event.EventDispatcher;
import resources.ResourceProduction;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class DayTracker
{

    private static int day = 0;
    private static LabelHandler label = new LabelHandler();
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
        label.resourceUpdate();
    }

    public int getDay()
    {
        return day;
    }
}
