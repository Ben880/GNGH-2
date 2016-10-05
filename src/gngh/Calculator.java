package gngh;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class Calculator
{
//calculates most things (excluding resources and world gen)

    VisibleInfo info;
    DayTracker day;
    ResourceTracker resources;

    public int disEQ(int x, int y)
    {
        int distance = (int) Math.round(Math.sqrt(Math.pow(19 - x, 2) + Math.pow(19 - y, 2)));
        return distance;
    }

    public int scoutDays(int x, int y)
    {
        day = DayTracker.getInstance();
        int days = disEQ(x, y) * 6 + day.getDay();
        return days;
    }

    public int forageDays(int x, int y)
    {
        return (disEQ(x, y) * 8 + day.getDay());
    }

    public double forageFood(int x, int y)
    {
        info = VisibleInfo.getInstance();
        return (info.getFertility(x, y) * 500);
    }

}
