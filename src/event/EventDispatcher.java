package event;

import java.util.ArrayList;

/*
    BenjaminWilcox
    Dec 13, 2016
    GNGH_2
 */
public class EventDispatcher
{

    private static EventHandler handler = new EventHandler();
    private static ArrayList<Event> event = new ArrayList<Event>();
    private static boolean cancleNext = false;

    public EventDispatcher()
    {

    }

    public void dayChange(int d)
    {
        for (int i = 0; i < event.size(); i++)
        {
            if (event.get(i).compleet == d)
            {
                handler.eventFinished(event.get(i));
                event.remove(i);
            }
        }
    }

    public void storeEvent(Event e)
    {
        if (!cancleNext)
        {
            event.add(e);
            e.setID(event.size());
            System.out.println("Event with id: " + e.getId() + " stored");
        }
        cancleNext = false;
    }

    public void removeEvent(int i)
    {
        event.remove(i);
        System.out.println("Event with id: " + i + " removed");
    }

    public void cancelEvent()
    {
        cancleNext = true;
        System.out.println("Event with id: " + event.size() + " cancled");
    }
}
