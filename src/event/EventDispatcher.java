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

    public EventDispatcher()
    {

    }

    public void dayChange(int d)
    {
        for (int i = 0; i < event.size(); i++)
        {
            if (event.get(i).compleet == d)
                handler.eventFinished(event.get(i));
        }
    }

    public void storeEvent(Event e)
    {
        event.add(e);
        System.out.println("Event stored");
    }
}
