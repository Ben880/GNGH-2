package event;

import java.util.ArrayList;
import util.Location;

/*
    BenjaminWilcox
    Nov 30, 2016
    GNGH_2
 */
public class EventHandler
{

    private static ArrayList<ScoutEvent> scout = new ArrayList();
    private static ArrayList<AttackEvent> attack = new ArrayList();
    private static ArrayList<ForageEvent> forage = new ArrayList();

    public void create()
    {

    }

    public void createLocation(Location l, int type)
    {
        if (type == 0) //scout
        {
            scout.add(new ScoutEvent());
            scout.get(scout.size() - 1).create(l);
        } else if (type == 1) //attack
        {
            attack.add(new AttackEvent());
            attack.get(attack.size() - 1).create(l);
        } else if (type == 2) //attack
        {

        }
    }
}
