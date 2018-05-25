package world.event;

import gui.winow.Slider;
import java.util.Random;
import util.Location;
import world.CellHolder;

/*
    BenjaminWilcox
    Dec 16, 2016
    GNGH_2
 */
public class ChopEvent extends Event
{

    CellHolder cells = new CellHolder();
    CitizenReleaseEvent citizens;
    ResourceReleaseEvent resource;
    Location location;
    Random rand = new Random();
    int days;
    int lumberjack = 0;
    int recruiters = 0;
    int wood = 0;

    public ChopEvent(Location l)
    {
        create(l);
    }

    public void create(Location l)
    {
        Slider slider = new Slider();
        lumberjack = slider.getNumber("send", "lumberjack") / 10;

        if (lumberjack != 0)
        {
            wood = 10;
            setMessage("Lumberjacks have returned with " + wood + " wood");
            citizens = new CitizenReleaseEvent("citizen", lumberjack);
            resource = new ResourceReleaseEvent("lumber", wood);
            location = l;
            days = (int) Math.round(location.baseDistance() * 4.0 + 4);
            setCompleet(days + day.getDay());
            gui.update();
            console.append("Lumberjacks set to return on day " + compleet);
        } else
        {
            dispatch.cancelEvent();
        }
    }

    public void end()
    {
        citizens.release();
        resource.release();
        gui.update();
        console.append(message);
//        resources.lumber().add(wood);
//        resources.people().add(people);
    }

}
