package world.event;

import java.util.logging.Level;
import java.util.logging.Logger;
import player.citizens.CitizenHolder;
import player.resources.NoSuchResourceException;
import player.resources.ResourceHolder;

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
    ResourceHolder resources = new ResourceHolder();

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

    public int getCount()
    {
        return count;
    }

    public int getWounded()
    {
        return wounded;
    }

    public int getDead()
    {
        return dead;
    }

    public String getType()
    {
        return name;
    }

    public void release()
    {
        holder.getCitizen(name).addCitizen(count);

    }

    public void releaseWounded()
    {
        try
        {
            holder.getCitizen(name).addCitizen(wounded);
            resources.getType("medicine").subtrat(wounded);
        } catch (NoSuchResourceException ex)
        {
            Logger.getLogger(CitizenReleaseEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
