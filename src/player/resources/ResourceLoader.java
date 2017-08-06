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

        for (int i = 0; i < parser.size(); i++)
        {
            holder.createType(parser.getNameAt(i));
            try
            {
                holder.getNumber(i).set(Integer.parseInt(parser.getString(i, "count")));
                holder.getNumber(i).setImageString(parser.getString(i, "image"));
            } catch (NoMatchException ex)
            {
                Logger.getLogger(ResourceLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        holder.printResources();

    }

}
