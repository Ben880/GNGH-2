package resources;

/*
    BenjaminWilcox
    Dec 16, 2016
    GNGH_2
 */
public class ResourceHolder
{

    private static Resource food = new Resource();
    private static Resource lumber = new Resource();
    private static Resource stone = new Resource();
    private static Resource ore = new Resource();
    private static Resource tools = new Resource();
    private static Resource animals = new Resource();
    private static Resource horses = new Resource();
    private static Resource people = new Resource();
    private static Resource troops = new Resource();
    private static Resource medicine = new Resource();
    private static boolean cfgloaded = false;

    public ResourceHolder()
    {
        if (!cfgloaded)
        {
            new LoadCFG(this);
            cfgloaded = true;
        }
    }

    public static Resource food()
    {
        return food;
    }

    public static Resource lumber()
    {
        return lumber;
    }

    public static Resource stone()
    {
        return stone;
    }

    public static Resource ore()
    {
        return ore;
    }

    public static Resource tools()
    {
        return tools;
    }

    public static Resource animals()
    {
        return animals;
    }

    public static Resource horses()
    {
        return horses;
    }

    public static Resource people()
    {
        return people;
    }

    public static Resource troops()
    {
        return troops;
    }

    public static Resource medicine()
    {
        return medicine;
    }
}
