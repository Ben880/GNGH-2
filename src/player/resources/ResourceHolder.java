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

    public Resource getType(String name) throws NoSuchResourceException
    {
        for (int i = 0; i < resource.size(); i++)
        {
            if (resource.get(i).getName().equalsIgnoreCase(name))
                return resource.get(i);
        }
        throw new NoSuchResourceException(name);
    }

    public Resource getNumber(int i)
    {
        if (i < resource.size())
            return resource.get(i);
        return null;
    }

    public void createType(String name)
    {
        resource.add(new Resource(name));
    }

    public void printResources()
    {
        System.out.println("----Current Resources----");
        for (int i = 0; i < resource.size(); i++)
        {
            System.out.println(resource.get(i).getName() + ": " + resource.get(i).get());
        }
    }

}
