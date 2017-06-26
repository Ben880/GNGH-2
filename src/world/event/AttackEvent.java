package world.event;

import gui.winow.Slider;
import util.Location;
import world.enemy.Battle;

/*
    BenjaminWilcox
    Dec 14, 2016
    GNGH_2
 */
public class AttackEvent extends Event
{

    Location location;
    Battle battle = new Battle();
    int troops;
    int days;
    CitizenReleaseEvent citizens;

    public void create(Location l)
    {
        Slider slider = new Slider();
        troops = slider.getNumber("send", "troops") / 10;

        if (troops != 0)
        {
            citizens = new CitizenReleaseEvent("soldier", troops);
            location = l;
            days = (int) Math.round(location.baseDistance() * 4.0);
            setCompleet(days + day.getDay());
            gui.update();
            console.append("Troops set to return on day " + compleet);
        } else
        {
            dispatch.cancelEvent();
        }
    }

    public void end()
    {
        battle.simulate(location, citizens);
        if (citizens.getCount() > 0 || citizens.getWounded() > 0)
        {
            cell.getCell(location).visible().setAllVisible(true);
            render.render();
            console.append("===============================");
            console.append(citizens.getDead() + " troops have died");
            console.append(citizens.getWounded() + " troops have been wounded");
            console.append(citizens.getCount() + " troops have returned from battle");
            console.append("==========Battle Report==========");
        } else
        {
            console.append("Troops have not returned from battle");
        }
        citizens.release();
        //console.append(message);
        battle.pushEnemyResults(location);
        gui.update();
    }
}
