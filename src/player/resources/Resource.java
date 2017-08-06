package player.resources;

/*
    BenjaminWilcox
    Dec 16, 2016
    GNGH_2
 */
public class Resource
{

    private String name;
    private int count;
    private String image;
    private double production;

    public Resource(String name)
    {
        this.name = name;
    }

    public void setPercentage(double d)
    {
        production = d;
    }

    public double getProduction()
    {
        return production;
    }

    public void setImageString(String s)
    {
        image = s;
    }

    public String getImageString()
    {
        return image;
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
