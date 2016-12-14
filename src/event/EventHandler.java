package event;

/*
    BenjaminWilcox
    Dec 13, 2016
    GNGH_2
 */
public class EventHandler
{

    public void eventFinished(Event e)
    {
        e.end();
        System.out.println("Event End");

    }

}
