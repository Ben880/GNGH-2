package player.citizens;

import config.ConfigLoader;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import player.resources.ResourceLoader;
import util.cfl.FileFormatException;
import util.cfl.NoMatchException;
import util.cfl.Parse;

/*
    BenjaminWilcox
    Jun 26, 2017
    GNGH2
 */
public class CitizenLoader
{

    private ConfigLoader config = new ConfigLoader();
    private Parse parser;
    CitizenHolder holder = new CitizenHolder();

    public CitizenLoader()
    {
        try
        {
            parser = new Parse(config.getConfigFile("jobs"));
        } catch (FileFormatException | FileNotFoundException ex)
        {
            Logger.getLogger(ResourceLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < parser.size(); i++)
        {
            createType(parser.getNameAt(i));
        }
        holder.printCitizens();

    }

    public void createType(String s)
    {
        try
        {
            holder.createCitizen(s, Integer.parseInt(parser.getString(s, "count")));
        } catch (NoMatchException ex)
        {
            Logger.getLogger(ResourceLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
