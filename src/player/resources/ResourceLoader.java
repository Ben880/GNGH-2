package player.resources;

import config.ConfigLoader;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.cfl.FileFormatException;
import util.cfl.NoMatchException;
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
    ResourceHolder holder = new ResourceHolder();

    public ResourceLoader()
    {

        try
        {
            parser = new Parse(config.getConfigFile("resources"));
        } catch (FileFormatException | FileNotFoundException ex)
        {
            Logger.getLogger(ResourceLoader.class.getName()).log(Level.SEVERE, null, ex);
        }

        createType("food");
        createType("lumber");
        createType("stone");
        createType("ore");
        createType("tools");
        createType("medicine");
        holder.printResources();

    }

    private void createType(String s)
    {
        try
        {
            holder.createType(s, Integer.parseInt(parser.getString(s, "count")));
        } catch (NoMatchException ex)
        {
            Logger.getLogger(ResourceLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
