package player.citizens;

/*
    BenjaminWilcox
    Jun 26, 2017
    GNGH2
 */
public class CitizenType
{

    private String name;
    private int count = 0;

    public CitizenType(String name, int count)
    {
        this.name = name;
        this.count = count;
    }

    public String getType()
    {
        return name;
    }

    public void addCitizen(int count)
    {
        this.count += count;
    }

    public void subtractCitizen(int count)
    {
        this.count -= count;
    }

    public int getCount()
    {
        return count;
    }

}
