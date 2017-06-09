package world;

/*
    BenjaminWilcox
    Jun 1, 2017
    GNGH_2
 */
public class WorldMap
{

    private static Chunk[][] chunk = new Chunk[20][20];

    public WorldMap()
    {
        if (chunk[0][0] == null)
            initialize();
    }

    private void initialize()
    {
        for (int x = 0; x < 20; x++)
        {
            for (int y = 0; y < 20; y++)
            {
                chunk[x][y] = new Chunk();
                chunk[x][y].initialize();
            }
        }
    }

    public Chunk getChunk(int x, int y)
    {
        return chunk[x][y];
    }

    public Cell getCell(Location l)
    {
        return chunk[l.getWorldX()][l.getWorldY()].getCell(l.getCellX(), l.getCellY());

    }

}
