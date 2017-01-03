package event;

import static event.Event.resources;
import java.util.Random;
import winow.Slider;

/*
    BenjaminWilcox
    Dec 16, 2016
    GNGH_2
 */
public class ChopEvent extends Event
{

    Random rand = new Random();
    int people = 0;
    int recruiters = 0;
    int wood = 0;

    public void create()
    {

        Slider slider = new Slider();
        people = slider.getNumber("send", "people") / 10;
        if (people != 0)
        {
            resources.people().subtrat(people);
            wood = rand.nextInt(3) * people * 10;
            setCompleet(rand.nextInt(10) + day.getDay());
            setMessage("Chopers have returned with " + wood + " wood");
            console.append("The " + people + " Chopers will return in 10  days");
            label.resourceUpdate();
        } else
        {
            dispatch.cancelEvent();
        }
    }

    public void end()
    {
        console.append(message);
        resources.lumber().add(wood);
        resources.people().add(people);
        label.resourceUpdate();
    }

}
