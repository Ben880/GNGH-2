package gui;

import conditions.LoseCondition;
import event.EventDispatcher;
import javax.swing.Timer;
import resources.ResourceProduction;
import winow.Confirm;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class DayTracker
{

    private static int day = 0;
    private static LabelHandler label = new LabelHandler();
    private static EventDispatcher event = new EventDispatcher();
    private static LoseCondition loss = new LoseCondition();
    private static Confirm confirm = new Confirm();
    Timer timer;

    public DayTracker()
    {

    }

    public void incriment(int amount)
    {
        int i = 0;
        //migrate to hierarchy
        ResourceProduction production;
        production = ResourceProduction.getInstance();

        if (confirm.confirm("Do you want to simulate " + amount + " days", "Start days"))
        {
            while (i < amount)
            {
                day++;
                System.out.println("Day: " + day);
                event.dayChange(day);
                production.dayChange();
                loss.dayChange(day);
                i++;
            }
            label.resourceUpdate();
        }
    }

    public int getDay()
    {
        return day;
    }
}
