package event;

import util.Location;

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
        troops = 10;
        location = l;
        days = (int) Math.round(location.baseDistance() * 4.0);
        setCompleet(days + day.getDay());
        setMessage("Troops have returned");
        resources.setTroops(resources.getTroops() - 10);
        resources.setFood(troops * days);
        console.append("Troops set to return on day " + compleet);
        label.resourceUpdate();
    }

    public void end()
    {
        console.append(message);
        resources.setTroops(resources.getTroops() + 10);
        cell.getCell(location).visible().setAllVisible(true);
        cell.getCell(location.getX() - 1, location.getY()).visible().setBiomeVisible(true);
        cell.getCell(location.getX() + 1, location.getY()).visible().setBiomeVisible(true);
        cell.getCell(location.getX(), location.getY() - 1).visible().setBiomeVisible(true);
        cell.getCell(location.getX(), location.getY() + 1).visible().setBiomeVisible(true);
        render.render();
        label.resourceUpdate();
    }
}
