package research;

/*
    BenjaminWilcox
    Jan 28, 2017
    GNGH_2
 */
public class Tech
{

    private String name;
    private boolean aquired;
    private int time;
    private String dep1;
    private String dep2;
    private Tech dependant1;
    private Tech dependant2;
    private double multiplier;
    private String stat;

    public Tech()
    {

    }

    public void buildTech(String name, boolean aquired, String dep1, String dep2, int time, double multiplier, String stat)
    {
        this.name = name;
        this.aquired = aquired;
        this.dep1 = dep1;
        this.dep2 = dep2;
        this.time = time;
        this.multiplier = multiplier;
        this.stat = stat;
    }

    public void setDependant(Tech tech1, Tech tech2)
    {
        dependant1 = tech1;
        dependant2 = tech2;
    }

    //getters
    public Tech getDependant(int i)
    {
        if (i == 1)
            return getDependant1();
        else
            return getDependant2();
    }

    public String getName()
    {
        return name;
    }

    public boolean isAquired()
    {
        return aquired;
    }

    public int getTime()
    {
        return time;
    }

    public String getDep1()
    {
        return dep1;
    }

    public String getDep2()
    {
        return dep2;
    }

    public Tech getDependant1()
    {
        return dependant1;
    }

    public Tech getDependant2()
    {
        return dependant2;
    }

    public double getMultiplier()
    {
        return multiplier;
    }

    public String getStat()
    {
        return stat;
    }
}
