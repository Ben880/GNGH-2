package world.event;

import gui.winow.Slider;
import java.util.Random;
import util.Location;

/*
    BenjaminWilcox
    Dec 14, 2016
    GNGH_2
 */
public class ForageEvent extends Event
{

    Location location;
    int people;
    int days;
    int food;
    Random rand = new Random();

    public ForageEvent(Location l)
    {
        create(l);
    }

    public void create(Location l)
    {
        Slider slider = new Slider();
        people = slider.getNumber("send", "people") / 10;
        if (people != 0)
        {
            location = l;
            food = (int) Math.round(100 * people * cell.getCell(location).resources().getFertility());
            days = (int) Math.round(location.baseDistance() * 6);
            setCompleet(days + day.getDay());
            setMessage("Foragers have returned with " + food + " units of food");
//            resources.people().subtrat(people);
            console.append(people + " foragers set to return on day " + compleet);
        } else
        {
            dispatch.cancelEvent();
        }

    }

    public void end()
    {
        console.append(message);
//        resources.food().add(food);
//        resources.people().add(people);
    }

}
