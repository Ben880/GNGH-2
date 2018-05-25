package world.event;

import java.util.logging.Level;
import java.util.logging.Logger;
import player.resources.NoSuchResourceException;
import player.resources.ResourceHolder;

/*
    BenjaminWilcox
    Jun 26, 2017
    GNGH2
 */
public class ResourceReleaseEvent
{

    String type;
    int count;

    ResourceHolder holder = new ResourceHolder();

    public ResourceReleaseEvent(String type, int count)
    {
        this.type = type;
        this.count = count;

    }

    public void release()
    {
        try
        {
            holder.getType(type).add(count);
        } catch (NoSuchResourceException ex)
        {
            Logger.getLogger(ResourceReleaseEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
