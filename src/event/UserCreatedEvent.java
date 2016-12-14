package event;

import util.Location;

/*
    BenjaminWilcox
    Dec 13, 2016
    GNGH_2
 */
public class UserCreatedEvent
{

    EventDispatcher dispatch = new EventDispatcher();

    public UserCreatedEvent()
    {

    }

    public void create(Location l, int type)
    {
        if (type == 0) //scout
        {
            ScoutEvent scout = new ScoutEvent();
            scout.create(l);
            dispatch.storeEvent(scout);
        } else if (type == 1) //attack
        {

        } else if (type == 2) //attack
        {

        }
    }

}
