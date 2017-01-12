package event;

import static event.Event.day;
import java.util.Random;
import winow.Slider;

/*
    BenjaminWilcox
    Dec 16, 2016
    GNGH_2
 */
public class RecruitEvent extends Event
{

    Random rand = new Random();
    int people = 0;
    int recruiters = 0;

    public void create()
    {

        Slider slider = new Slider();
        int recruiters = slider.getNumber("send", "recruiters") / 10;
        if (recruiters != 0)
        {
            people = (int) Math.round(recruiters * rand.nextDouble() * 2);
            resources.people().subtrat(recruiters);
            setCompleet(rand.nextInt(10) + day.getDay());
            setMessage("Recruiters have returned with " + people + " new people");
            console.append("Recruiters have been sent out");
            label.resourceUpdate();
        } else
        {
            dispatch.cancelEvent();
        }
    }

    public void end()
    {
        console.append(message);
        resources.people().add(recruiters);
        resources.people().add(people);
        label.resourceUpdate();
    }
}
