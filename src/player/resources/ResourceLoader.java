package player.resources;

import config.ConfigLoader;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.cfl.FileFormatException;
import util.cfl.Parse;

/*
    BenjaminWilcox
    Jun 23, 2017
    GNGH_2
 */
public class ResourceLoader
{

    private ConfigLoader config = new ConfigLoader();
    private Parse parser;

    public ResourceLoader()
    {

        try
        {
            parser = new Parse(config.getConfigFile("resources"));
        } catch (FileFormatException | FileNotFoundException ex)
        {
            Logger.getLogger(ResourceLoader.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
