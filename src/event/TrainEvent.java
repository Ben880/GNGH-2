package event;

import static event.Event.resources;
import java.util.Random;
import gui.winow.Slider;

/*
    BenjaminWilcox
    Dec 16, 2016
    GNGH_2
 */
public class TrainEvent extends Event
{

    Random rand = new Random();
    int people = 0;
    int troops = 0;

    public void create()
    {
        Slider slider = new Slider();
        int desired = slider.getNumber("train", "troops") / 10;
        if (desired != 0)
        {
            troops = desired - rand.nextInt(desired / 2);
            people = desired - troops;
            resources.people().subtrat(desired);
            setCompleet(rand.nextInt(10) + day.getDay() + 5);
            setMessage(troops + " trainees have compeeted their training. " + (people) + " have failed their training.");
            console.append(desired + " people have been set to train");
            label.resourceUpdate();
        } else
        {
            dispatch.cancelEvent();
        }
    }

    public void end()
    {
        console.append(message);
        resources.troops().add(troops);
        resources.people().add(people);
        label.resourceUpdate();
    }
}
