package util;

/*
    BenjaminWilcox
    Nov 30, 2016
    GNGH_2
 */
public class LocationDistance
{

    public double distance(Location L1, Location L2)
    {
        return Math.sqrt(Math.pow(L1.getX() - L2.getX(), 2) + Math.pow((L1.getY() - L2.getY()), 2));
    }
}
