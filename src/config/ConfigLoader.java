package config;

import java.io.File;
import java.net.URL;

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
        URL location = getClass().getProtectionDomain().getCodeSource().getLocation();
        File f = new File(location.getPath());
        System.out.println(f.getAbsolutePath());
        File file = new File(System.getProperty("user.dir") + "\\config\\" + s + ".txt");
        return file;
    }

}
