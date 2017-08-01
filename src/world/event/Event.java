package world.event;

import gui.BackEnd.ConsoleHandler;
import gui.BackEnd.DayTracker;
import gui.main.UpdateGUI;
import player.resources.ResourceHolder;
import world.CellHolder;
import world.render.RenderTiles;

/*
    BenjaminWilcox
    Dec 13, 2016
    GNGH_2
 */
public class Event
{

    String message;
    int compleet;
    int eventId;
    static EventDispatcher dispatch = new EventDispatcher();
    static RenderTiles render = new RenderTiles();
    static DayTracker day = new DayTracker();
    static CellHolder cell = new CellHolder();
    static ResourceHolder resources = new ResourceHolder();
    static ConsoleHandler console = new ConsoleHandler();
    static UpdateGUI gui = new UpdateGUI();

    public void setCompleet(int c)
    {
        compleet = c;
    }

    public void setMessage(String s)
    {
        message = s;
    }

    public int getCompleet()
    {
        return compleet;
    }

    public String getMessage()
    {
        return message;
    }

    public int getId()
    {
        return eventId;
    }

    public void setID(int i)
    {
        eventId = i;
    }

    public void end()
    {

    }

}
