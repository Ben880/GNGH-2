package event;

import util.Location;
import winow.Slider;

/*
    BenjaminWilcox
    Dec 14, 2016
    GNGH_2
 */
public class AttackEvent extends Event
{

    Location location;
    int troops;
    int days;

    public void create(Location l)
    {
        Slider slider = new Slider();
        troops = slider.getNumber("send", "troops") / 10;
        if (troops != 0)
        {
            location = l;
            days = (int) Math.round(location.baseDistance() * 4.0);
            setCompleet(days + day.getDay());
            setMessage("Troops have returned");
            resources.troops().subtrat(troops);
            resources.food().subtrat(troops * days * 5);
            console.append("Troops set to return on day " + compleet);
            label.resourceUpdate();
        } else
        {
            dispatch.cancelEvent();
        }
    }

    public void end()
    {
        console.append(message);
        resources.troops().add(10);
        cell.getCell(location).visible().setAllVisible(true);
        cell.getCell(location.getX() - 1, location.getY()).visible().setBiomeVisible(true);
        cell.getCell(location.getX() + 1, location.getY()).visible().setBiomeVisible(true);
        cell.getCell(location.getX(), location.getY() - 1).visible().setBiomeVisible(true);
        cell.getCell(location.getX(), location.getY() + 1).visible().setBiomeVisible(true);
        render.render();
        label.resourceUpdate();
    }
}
