package player.resources;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
    BenjaminWilcox
    Aug 6, 2017
    GNGH2
 */
public class BaseProduction
{

    private static ResourceProduction production = new ResourceProduction();
    private static ResourceHolder resources = new ResourceHolder();

    public BaseProduction()
    {

        try
        {
            production.addProducer(resources.getType("food"), 100);
            production.addProducer(resources.getType("ore"), -10);
        } catch (NoSuchResourceException ex)
        {
            Logger.getLogger(BaseProduction.class.getName()).log(Level.SEVERE, null, ex);
        }
        production.printProducers();

    }

}
