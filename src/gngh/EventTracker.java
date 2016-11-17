package gngh;

import java.util.ArrayList;
import java.util.Random;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class EventTracker
{

    //feilds
    ArrayList<EventHolder> events = new ArrayList<EventHolder>();
    int eventNumber = 0;

    Info info;
    Tracker tracker;
    GUIHandler gui;
    LabelHandler labels;
    Random rand = new Random();

    public EventTracker(Tracker t)
    {
        tracker = t;
        info = Info.getInstance();
        gui = GUIHandler.getInstance();
    }

    //regular methods
    public void dayChange(int day)
    {
        int i = 0;
        while (i < events.size())
        {

            if (events.get(i).getCompleet() == day)
            {
                events.get(i).finish();
            }
            if (info.debug().getDebug())
            {
                gui.frame().getFrame().console("Event #" + i + " type: " + events.get(i).getType() + " is to compleet on " + events.get(i).getCompleet());
            }
            i++;

            if (rand.nextInt(100) == 90)
            {
                gui.frame().getFrame().console("Random Event Trigger");
            }
        }
    }

    public void scout(int x, int y)
    {
        Calculator calc = new Calculator();
        events.add(new EventHolder());
        events.get(eventNumber).setPos(x, y);
        events.get(eventNumber).setType(0);
        events.get(eventNumber).setCompleet(calc.scoutDays(x, y));
        events.get(eventNumber).setMessage("Scouts returned and found a " + info.visible.getBiomeString(x, y) + " biome.");
        calc = null;
        gui.frame().getFrame().console("scouts are to return on day " + events.get(eventNumber).getCompleet());
        eventNumber++;
    }

    public void forage(int x, int y)
    {
        Calculator calc = new Calculator();
        events.add(new EventHolder());
        events.get(eventNumber).setType(2);
        events.get(eventNumber).setPos(x, y);
        events.get(eventNumber).setCompleet(calc.scoutDays(x, y));
        events.get(eventNumber).setPeople(30);
        events.get(eventNumber).setFood((int) calc.forageFood(x, y));
        events.get(eventNumber).setMessage("Foraging at " + x + ", " + y + " compleet!");
        info.resources().setFood(info.resources().getFood() - (50 * (events.get(eventNumber).getCompleet() - tracker.day().getDay())));
        info.resources().setPeople(info.resources().getPeople() - 30);
        gui.label().resourceUpdate();

        calc = null;
        gui.frame().getFrame().console("foaragers are to return on day " + events.get(eventNumber).getCompleet());
        eventNumber++;
    }

    public void attack(int x, int y)
    {
        Calculator calc = new Calculator();
        DialogueBox box = new DialogueBox();
        int troops = box.troops();
        System.out.print("here");
        events.add(new EventHolder());
        System.out.print("here");
        events.get(eventNumber).setType(2);
        events.get(eventNumber).setPos(x, y);
        events.get(eventNumber).setCompleet((int) (calc.scoutDays(x, y) * 1.3));
        calc.attack(x, y, troops, events.get(eventNumber));
        events.get(eventNumber).setMessage("Attack on " + x + ", " + y + " compleet!");
        gui.frame().getFrame().console("Attackers are to return on day " + events.get(eventNumber).getCompleet());
        info.resources().setTroops(info.resources().getTroops() - troops);
        labels.resourceUpdate();
        info.resources().setFood(info.resources().getFood() - (50 * (events.get(eventNumber).getCompleet() - tracker.day().getDay())));
        System.out.print("here");
        eventNumber++;
    }
}
