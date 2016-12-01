package util;

import java.util.ArrayList;

/*
    BenjaminWilcox
    Nov 28, 2016
    GNGH_2
 */
public class Resource
{

    ArrayList<ResourceStipulation> stipulation = new ArrayList<ResourceStipulation>();

    public Resource()
    {

    }

    public int calculate()
    {
        int total = 0;
        for (int i = 0; i < stipulation.size(); i++)
        {
            total += stipulation.get(i).calculate();
        }
        return total;
    }

    public void setNumStipulations(int number)
    {
        for (int i = 0; i < number; i++)
        {
            stipulation.add(new ResourceStipulation());
        }
    }

    public int addStiplulation()
    {
        stipulation.add(new ResourceStipulation());
        return stipulation.size();
    }

    public void modifyStipulation(int num, int base, double multiplier)
    {
        stipulation.get(num).set(base, multiplier);
    }

    public void modifyBase(int num, int base)
    {
        stipulation.get(num).setBase(base);
    }

    public void midifyMultiplier(int num, int multiplier)
    {
        stipulation.get(num).setMultiplier(multiplier);
    }

    public void clearStipulation(int num)
    {
        stipulation.get(num).set(0, 0);
    }

    public void removeStipulation(int stipulation)
    {
//currently will break things use clear instead
    }
}
