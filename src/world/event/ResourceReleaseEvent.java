package world.event;

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
        holder.getType(type).add(count);
    }

}
