package world.event;

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
        System.out.println("User CreatedEvent");
        if (type == 0) //scout
        {
            ScoutEvent scout = new ScoutEvent();
            scout.create(l);
            dispatch.storeEvent(scout);
            scout = null;
        } else if (type == 1) //attack
        {
            AttackEvent attack = new AttackEvent();
            attack.create(l);
            dispatch.storeEvent(attack);
            attack = null;
        } else if (type == 2) //forage
        {
            dispatch.storeEvent(new ForageEvent(l));
        }
    }

    public void create(int type)
    {
        if (type == 3)
        {
            RecruitEvent recruit = new RecruitEvent();
            recruit.create();
            dispatch.storeEvent(recruit);
        }
        if (type == 4)
        {
            TrainEvent train = new TrainEvent();
            train.create();
            dispatch.storeEvent(train);
        }
        if (type == 5)
        {
            ChopEvent chop = new ChopEvent();
            chop.create();
            dispatch.storeEvent(chop);
        }
    }

}
