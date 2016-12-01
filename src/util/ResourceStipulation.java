package util;

/*
    BenjaminWilcox
    Nov 28, 2016
    GNGH_2
 */
public class ResourceStipulation
{

    int base;
    double multiplier;

    public ResourceStipulation()
    {
        base = 0;
        multiplier = 0;
    }

    public void set(int b, double m)
    {
        base = b;
        multiplier = m;
    }

    public void setBase(int b)
    {
        base = b;
    }

    public void setMultiplier(int m)
    {
        multiplier = m;
    }

    public int calculate()
    {
        return (int) Math.round(base * multiplier);
    }
}
