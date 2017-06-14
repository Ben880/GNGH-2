package event;

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

    public void create(Location l)
    {
        Slider slider = new Slider();
        troops = slider.getNumber("send", "troops") / 10;
        if (troops != 0)
        {
            location = l;
            days = (int) Math.round(location.baseDistance() * 4.0);
            setCompleet(days + day.getDay());
            resources.troops().subtrat(troops);
            resources.food().subtrat(troops * days * 5);
            console.append("Troops set to return on day " + compleet);
//            label.resourceUpdate();
        } else
        {
            dispatch.cancelEvent();
        }
    }

    public void end()
    {
        battle.simulate(location, troops);
        if (battle.winResults())
        {
            cell.getCell(location).visible().setAllVisible(true);
            render.render();
            console.append(battle.troopResults() + " troops have returned from battle");

            if (battle.badHealth() && resources.medicine().get() <= 0)
            {
                console.append("A troop has returned wounded but died due to lack of medicine");
                resources.troops().subtrat(1);
            } else if (battle.badHealth())
            {
                console.append("A troop has returned wounded and is being treated");
                resources.medicine().subtrat(1);
            } else if (battle.criticalHealth())
            {
                console.append("The wounded troop has died");
                resources.troops().set(1);
            }
        } else
        {
            console.append("Troops have not returned from battle");
        }
        console.append(message);
        battle.pushEnemyResults(location);
        resources.troops().add(battle.troopResults());
//        label.resourceUpdate();
    }
}
