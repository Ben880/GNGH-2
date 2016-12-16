package event;

import cell.CellHolder;
import gngh.ConsoleHandler;
import gngh.DayTracker;
import gngh.LabelHandler;
import render.RenderTiles;
import resources.Resources;

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
    static RenderTiles render = new RenderTiles();
    static DayTracker day = new DayTracker();
    static CellHolder cell = new CellHolder();
    static Resources resources = new Resources();
    static ConsoleHandler console = new ConsoleHandler();
    static LabelHandler label = new LabelHandler();

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

    public void end()
    {

    }

}
