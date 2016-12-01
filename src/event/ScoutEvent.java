package event;

import gngh.GUIHandler;
import gngh.Info;
import gngh.Tracker;
import util.Location;

/*
    BenjaminWilcox
    Nov 30, 2016
    GNGH_2
 */
public class ScoutEvent extends Event
{

    Location location;
    int people;
    int days;
    Info info = Info.getInstance();
    Tracker tracker = Tracker.getInstance();
    GUIHandler gui = GUIHandler.getInstance();

    public void create(Location l)
    {
        people = 10;
        location = l;
        days = (int) Math.round(location.baseDistance() * 1.5);
        setCompleet(days + tracker.day().getDay());
        setMessage("Scouts have returned and found a " + info.visible().getBiome(location.getX(), location.getY(), true) + " biome!");
        info.resources().setPeople(info.resources().getPeople() - 10);
        info.resources().setFood(people * days);
    }

    public void end()
    {
        gui.console().append(message);
        info.resources().setPeople(info.resources().getPeople() + 10);
        gui.tile().dispBiomeSquare(location.getX(), location.getY());
        info.visible().setStatsVisible(location.getX(), location.getY(), true);

    }
}
