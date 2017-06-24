package player.resources;

/*
    BenjaminWilcox
    Dec 16, 2016
    GNGH_2
 */
public class Resource
{

    String name;
    int count;

    public Resource(String name, int count)
    {
        this.name = name;
        this.count = count;
    }

    public String getName()
    {
        return name;
    }

    public int get()
    {
        return count;
    }

    public void set(int i)
    {
        count = i;
    }

    public void add(int i)
    {
        count += i;
    }

    public void subtrat(int i)
    {
        count -= i;
    }

}
