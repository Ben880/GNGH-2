package event;

import static event.Event.resources;
import java.util.Random;

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
        people = rand.nextInt(10);
        if (people < 3)
            people = 3;
        troops = people - (rand.nextInt(3));
        resources.people().subtrat(people);
        setCompleet(rand.nextInt(10) + day.getDay() + 5);
        setMessage(troops + " trainees have compeeted their training. " + (people - troops) + " have failed their training.");
        console.append(people + " people have been set to train");
        label.resourceUpdate();
    }

    public void end()
    {
        console.append(message);
        resources.troops().add(troops);
        resources.people().add(people - troops);
        label.resourceUpdate();
    }
}
