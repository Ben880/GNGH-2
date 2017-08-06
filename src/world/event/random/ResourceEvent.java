package world.event.random;

import gui.main.UpdateGUI;
import java.util.logging.Level;
import java.util.logging.Logger;
import player.resources.NoSuchResourceException;
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
        try
        {
            resources.getType(resource).add(i);
        } catch (NoSuchResourceException ex)
        {
            Logger.getLogger(ResourceEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        new UpdateGUI().update();
    }

}
