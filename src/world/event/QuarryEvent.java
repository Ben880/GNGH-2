package world.event;

import gui.winow.Slider;
import util.Location;
import static world.event.Event.day;

/*
    BenjaminWilcox
    Dec 16, 2016
    GNGH_2
 */
public class QuarryEvent extends Event
{

    Location location;
    CitizenReleaseEvent citizen;
    ResourceReleaseEvent stoneRelease;
    ResourceReleaseEvent oreRelease;

    int miners = 0;
    int ore = 0;
    int stone = 0;
    int days = 0;

    public QuarryEvent(Location l)
    {
        create(l);
    }

    public void create(Location l)
    {
        Slider slider = new Slider();
        miners = slider.getNumber("send", "miners") / 10;

        if (miners != 0)
        {
            //set amount values
            ore = 5;
            stone = 20;
            location = l;
            days = (int) Math.round(location.baseDistance() * 5.0 + 8);
            //set up release events and message
            citizen = new CitizenReleaseEvent("miner", miners);
            stoneRelease = new ResourceReleaseEvent("stone", stone);
            oreRelease = new ResourceReleaseEvent("ore", ore);
            setMessage("Miners have returned with " + stone + " wood and " + ore + " ore!");
            //set completion day an update gui
            setCompleet(days + day.getDay());
            gui.update();
            console.append("Miners set to return on day " + compleet);
        } else
        {
            dispatch.cancelEvent();
        }
    }

    public void end()
    {
        citizen.release();
        stoneRelease.release();
        oreRelease.release();
        gui.update();
        console.append(message);
//        resources.lumber().add(wood);
//        resources.people().add(people);
    }
}
