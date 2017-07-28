package content;

import java.io.File;

/*
    BenjaminWilcox
    Jul 28, 2017
    GNGH2
 */
public class ContentLoader
{

    public ContentLoader()
    {

    }

    public File getConfigFile(String s)
    {
        File file = new File(System.getProperty("user.dir") + "\\config\\" + s);
        return file;
    }

}
