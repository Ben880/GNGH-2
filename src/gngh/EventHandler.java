package gngh;

import java.util.ArrayList;
import java.util.Random;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class EventHandler
{

    //feilds
    ArrayList<EventHolder> events = new ArrayList<EventHolder>();
    int eventNumber = 0;
    MyFrame frame;
    VisibleInfo Info;
    DayTracker day;
    ResourceTracker resources;
    Random rand = new Random();
    //singleton
    private static EventHandler instance = null;

    private EventHandler()
    {
        frame = MyFrame.getInstance("GNGH");
        Info = VisibleInfo.getInstance();
        day = DayTracker.getInstance();
        resources = ResourceTracker.getInstance();

    }

    public static EventHandler getInstance()
    {
        if (instance == null)
        {
            instance = new EventHandler();
        }
        return instance;
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
        Calculator calc = new Calculator();
        events.add(new EventHolder());
        events.get(eventNumber).setPos(x, y);
        events.get(eventNumber).setType(0);
        events.get(eventNumber).setCompleet(calc.scoutDays(x, y));
        events.get(eventNumber).setMessage("Scouts returned and found a " + Info.getBiomeString(x, y) + " biome.");
        calc = null;
        frame.console("scouts are to return on day " + events.get(eventNumber).getCompleet());
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
        resources.setFood(resources.getFood() - (50 * (events.get(eventNumber).getCompleet() - day.getDay())));
        resources.setPeople(resources.getPeople() - 30);
        LabelHandler.getInstance().resourceUpdate();

        calc = null;
        frame.console("foaragers are to return on day " + events.get(eventNumber).getCompleet());
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
        events.get(eventNumber).setTroops(troops);
        events.get(eventNumber).setMessage("Attack on " + x + ", " + y + " compleet!");
        frame.console("Attackers are to return on day " + events.get(eventNumber).getCompleet());
        resources.setTroops(resources.getTroops() - troops);
        resources.setFood(resources.getFood() - (50 * (events.get(eventNumber).getCompleet() - day.getDay())));
        System.out.print("here");
        eventNumber++;
    }
}
