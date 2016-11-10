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
    MainFrame frame;
    Info info;
    DayTracker day;
    ResourceInfo resources;
    LabelHandler labels;
    Random rand = new Random();
    //singleton
    private static EventTracker instance = null;

    private EventTracker()
    {

        info = Info.getInstance();
        day = DayTracker.getInstance();
        resources = ResourceInfo.getInstance();
        labels = LabelHandler.getInstance();

    }

    public static EventTracker getInstance()
    {
        if (instance == null)
        {
            instance = new EventTracker();
        }
        return instance;
    }

    //regular methods
    public void dayChange(int day)
    {
        frame = MainFrame.getInstance("GNGH");
        int i = 0;
        while (i < events.size())
        {

            if (events.get(i).getCompleet() == day)
            {
                events.get(i).finish();
            }
            if (frame.debug)
            {
                frame.console("Event #" + i + " type: " + events.get(i).getType() + " is to compleet on " + events.get(i).getCompleet());
            }
            i++;

            if (rand.nextInt(100) == 90)
            {
                frame.console("Random Event Trigger");
            }
        }
    }

    public void scout(int x, int y)
    {
        frame = MainFrame.getInstance("GNGH");
        Calculator calc = new Calculator();
        events.add(new EventHolder());
        events.get(eventNumber).setPos(x, y);
        events.get(eventNumber).setType(0);
        events.get(eventNumber).setCompleet(calc.scoutDays(x, y));
        events.get(eventNumber).setMessage("Scouts returned and found a " + info.visible.getBiomeString(x, y) + " biome.");
        calc = null;
        frame.console("scouts are to return on day " + events.get(eventNumber).getCompleet());
        eventNumber++;
    }

    public void forage(int x, int y)
    {
        frame = MainFrame.getInstance("GNGH");
        Calculator calc = new Calculator();
        events.add(new EventHolder());
        events.get(eventNumber).setType(2);
        events.get(eventNumber).setPos(x, y);
        events.get(eventNumber).setCompleet(calc.scoutDays(x, y));
        events.get(eventNumber).setPeople(30);
        events.get(eventNumber).setFood((int) calc.forageFood(x, y));
        events.get(eventNumber).setMessage("Foraging at " + x + ", " + y + " compleet!");
        resources.setFood(resources.getFood() - (50 * (events.get(eventNumber).getCompleet() - day.getDay())));
        resources.setPeople(resources.getPeople() - 30);
        LabelHandler.getInstance().resourceUpdate();

        calc = null;
        frame.console("foaragers are to return on day " + events.get(eventNumber).getCompleet());
        eventNumber++;
    }

    public void attack(int x, int y)
    {
        frame = MainFrame.getInstance("GNGH");
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
        frame.console("Attackers are to return on day " + events.get(eventNumber).getCompleet());
        resources.setTroops(resources.getTroops() - troops);
        labels.resourceUpdate();
        resources.setFood(resources.getFood() - (50 * (events.get(eventNumber).getCompleet() - day.getDay())));
        System.out.print("here");
        eventNumber++;
    }
}
