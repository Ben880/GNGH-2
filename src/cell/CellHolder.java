package cell;

import util.Location;

/*
    BenjaminWilcox
    Dec 6, 2016
    GNGH_2
 */
public class CellHolder
{

    private static Cell[][] cell = new Cell[20][20];
    private static boolean initialize = true;

    public CellHolder()
    {
        if (initialize)
            initialize();
    }

    public void initialize()
    {
        for (int x = 0; x < 20; x++)
        {
            for (int y = 0; y < 20; y++)
            {
                cell[x][y] = new Cell();
            }
        }
        initialize = false;
    }

    public Cell getCell(Location l)
    {
        return cell[l.getX()][l.getY()];
    }

    public Cell getCell(int x, int y)
    {
        return cell[x][y];
    }
}
