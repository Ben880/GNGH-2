package world.event;

import player.citizens.CitizenHolder;

/*
    BenjaminWilcox
    Jun 26, 2017
    GNGH2
 */
public class CitizenReleaseEvent
{

    private String name;
    private int count;
    private int wounded = 0;
    private int dead = 0;

    CitizenHolder holder = new CitizenHolder();

    public CitizenReleaseEvent(String citizen, int count)
    {
        name = citizen;
        this.count = count;
        holder.getCitizen(name).subtractCitizen(count);
    }

    public void addDead()
    {
        count -= 1;
        dead += 1;
    }

    public void addWounded()
    {
        count -= 1;
        wounded += 1;
    }

    public void release()
    {
        holder.getCitizen(name).addCitizen(count);
    }

}
