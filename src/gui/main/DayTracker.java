package gui.main;

import gui.winow.Confirm;
import player.conditions.LoseCondition;
import player.resources.ResourceProduction;
import world.event.EventDispatcher;
import world.event.random.RandomEventDispatcher;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class DayTracker
{

    private static int day = 0;
    private static EventDispatcher event = new EventDispatcher();
    private static LoseCondition loss = new LoseCondition();
    private static Confirm confirm = new Confirm();
    private static RandomEventDispatcher random = new RandomEventDispatcher();

    //tracks days
    public DayTracker()
    {

    }

    public void incriment(int amount)
    {
        int i = 0;
        //code needs updating
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
                random.dayChange();
                loss.dayChange(day);
                i++;
            }
        }
    }//end incriment

    public int getDay()
    {
        return day;
    }
}
