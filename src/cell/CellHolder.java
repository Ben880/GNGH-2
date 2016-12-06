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

    public void initialize()
    {
        for (int x = 0; x < 20; x++)
        {
            for (int y = 0; y < 20; y++)
            {
                cell[x][y] = new Cell();
            }
        }
    }

    public Cell getCell(Location l)
    {
        return cell[l.getX()][l.getY()];
    }
}
