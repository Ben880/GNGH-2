package player.resources;

import java.util.ArrayList;

/*
    BenjaminWilcox
    Dec 16, 2016
    GNGH_2
 */
public class ResourceHolder
{

    private static ArrayList<Resource> resource = new ArrayList();
    private static ResourceLoader loader = new ResourceLoader();

    public ResourceHolder()
    {

    }

    public Resource getType(String name)
    {
        for (int i = 0; i < resource.size(); i++)
        {
            if (resource.get(i).getName().equalsIgnoreCase(name))
                return resource.get(i);
        }
        return null;
    }

    public void createType(String name, int count)
    {

    }

}
