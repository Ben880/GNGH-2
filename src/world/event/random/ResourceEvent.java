package world.event.random;

import gui.main.UpdateGUI;
import player.resources.ResourceHolder;

/*
    BenjaminWilcox
    Jul 30, 2017
    GNGH2
 */
public class ResourceEvent extends RandomEvent
{

    private static ResourceHolder resources = new ResourceHolder();

    public void addResource(int i)
    {
        resources.getType(resource).add(i);
        new UpdateGUI().update();
    }

}
