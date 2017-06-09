package world;

/*
    BenjaminWilcox
    Jun 7, 2017
    GNGH_2
 */
public class Location
{

    private int worldX;
    private int worldY;
    private int cellX;
    private int cellY;

    public Location(int x, int y, int x1, int y1)
    {
        worldX = x;
        worldY = y;
        cellX = x1;
        cellY = y1;

    }

    public int getWorldX()
    {
        return worldX;
    }

    public int getWorldY()
    {
        return worldY;
    }

    public int getCellX()
    {
        return cellX;
    }

    public int getCellY()
    {
        return cellY;
    }

}
