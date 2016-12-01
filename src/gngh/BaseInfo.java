package gngh;

/*
    BenjaminWilcox
    Nov 28, 2016
    GNGH_2
 */
public class BaseInfo
{

    int[][] tile = new int[20][20];

    public BaseInfo()
    {
        int x = 0;
        int y = 0;
        for (int i = 0; i < 400; i++, x++)
        {
            if (x == 20)
            {
                x = 0;
                y++;
            }
            tile[x][y] = 0;
        }
        tile[9][9] = 1;
        tile[10][9] = 1;
        tile[9][10] = 1;
        tile[10][10] = 1;
    }

}
