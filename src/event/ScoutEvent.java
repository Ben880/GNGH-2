package event;

import cell.CellHolder;
import gngh.ConsoleHandler;
import gngh.DayTracker;
import render.RenderTiles;
import resources.Resources;
import util.Location;

/*
    BenjaminWilcox
    Dec 13, 2016
    GNGH_2
 */
public class ScoutEvent extends Event
{

    Location location;
    int people;
    int days;
    CellHolder cell = new CellHolder();
    DayTracker day = new DayTracker();
    Resources resources = new Resources();
    ConsoleHandler console = new ConsoleHandler();

    public void create(Location l)
    {
        people = 10;
        location = l;
        days = (int) Math.round(location.baseDistance() * 4);
        setCompleet(days + day.getDay());
        setMessage("Scouts have returned and found a " + cell.getCell(l).biome().getName() + " biome!");
        resources.setPeople(resources.getPeople() - 10);
        resources.setFood(people * days);
        console.append("Scouts are to return on day: " + compleet);
    }

    @Override
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
