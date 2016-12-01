package util;

/*
    BenjaminWilcox
    Nov 30, 2016
    GNGH_2
 */
public class Location
{

    int x;
    int y;

    public Location(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public double baseDistance()
    {
        double distance = (new LocationDistance().distance(this, new Location(19, 19)));
        return distance;
    }
}
