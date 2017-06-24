package config;

import java.io.File;

/*
    BenjaminWilcox
    Jun 13, 2017
    GNGH_2
 */
public class ConfigLoader
{

    public ConfigLoader()
    {

    }

    public File getConfigFile(String s)
    {
        File file = new File(System.getProperty("user.dir") + "\\config\\" + s + ".txt");
        return file;
    }

}
