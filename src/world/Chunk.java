package world;

/*
    BenjaminWilcox
    Jun 1, 2017
    GNGH_2
 */
public class Chunk
{

    private static Cell[][] cell = new Cell[20][20];

    public Chunk()
    {

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

    }

    public Cell getCell(int x, int y)
    {
        return cell[x][y];
    }

}
