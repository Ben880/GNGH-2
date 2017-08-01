package gui.BackEnd;

import gui.main.UpdateGUI;
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
    private static ResourceProduction production;

    //tracks days
    public DayTracker()
    {

    }

    public void incriment(int amount)
    {
        if (confirm.confirm("Do you want to simulate " + amount + " days", "Start days"))
        {
            startDays(amount);
        }
    }//end incriment

    private void startDays(int amount)
    {
        for (int i = 0; i < amount; i++)
        {
            day++;
            System.out.println("Day: " + day);
            event.dayChange(day);
            random.dayChange();
            loss.dayChange(day);
        }
        new UpdateGUI().update();
    }

    public int getDay()
    {
        return day;
    }

}
