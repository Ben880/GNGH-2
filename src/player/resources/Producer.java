package player.resources;

/*
    BenjaminWilcox
    Aug 5, 2017
    GNGH2
 */
public class Producer
{

    private static ResourceHolder resources = new ResourceHolder();
    private Resource resource;
    private int count;

    public Producer(Resource resource, int count)
    {
        this.resource = resource;
        this.count = count;
    }

    public int getProduction()
    {
        return count;
    }

    public void produce()
    {
        resource.add(count);
    }

    public String getResourceName()
    {
        return resource.getName();
    }

}
