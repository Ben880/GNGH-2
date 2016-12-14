package event;

import cell.CellHolder;
import gngh.ConsoleHandler;
import gngh.DayTracker;
import render.RenderTiles;
import resources.Resources;
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
    DayTracker day = new DayTracker();
    CellHolder cell = new CellHolder();
    Resources resources = new Resources();
    ConsoleHandler console = new ConsoleHandler();

    public void create(Location l)
    {
        troops = 10;
        location = l;
        days = (int) Math.round(location.baseDistance() * 2.5);
        setCompleet(days + day.getDay());
        setMessage("Scouts have returned and found a " + cell.getCell(l).biome().getName() + " biome!");
        resources.setPeople(resources.getPeople() - 10);
        resources.setFood(troops * days);
    }

    public void end()
    {
        console.append(message);
        resources.setPeople(resources.getPeople() + 10);
        cell.getCell(location).visible().setAllVisible(true);
        cell.getCell(location.getX() - 1, location.getY()).visible().setBiomeVisible(true);
        cell.getCell(location.getX() + 1, location.getY()).visible().setBiomeVisible(true);
        cell.getCell(location.getX(), location.getY() - 1).visible().setBiomeVisible(true);
        cell.getCell(location.getX(), location.getY() + 1).visible().setBiomeVisible(true);
        RenderTiles render = new RenderTiles();
        render.render();

    }
}
