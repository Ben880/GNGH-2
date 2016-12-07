package generation;

import cell.CellHolder;

/*
    BenjaminWilcox
    Dec 6, 2016
    GNGH_2
 */
public class ResourceGeneration
{

    CellHolder cell = new CellHolder();

    public void fertility()
    {

        double temp;
        for (int x = 0; x < 20; x++)
        {
            for (int y = 0; y < 20; y++)
            {
                temp = 1;
                //water check
                if (getBiome(x - 1, y - 1) == 2)
                {
                    temp += .25;
                }
                if (getBiome(x + 1, y - 1) == 2)
                {
                    temp += .25;
                }
                if (getBiome(x - 1, y + 1) == 2)
                {
                    temp += .25;
                }
                if (getBiome(x + 1, y + 1) == 2)
                {
                    temp += .25;
                }
                if (getBiome(x - 1, y) == 2)
                {
                    temp += .5;
                }
                if (getBiome(x + 1, y) == 2)
                {
                    temp += .5;
                }
                if (getBiome(x, y - 1) == 2)
                {
                    temp += .5;
                }
                if (getBiome(x, y + 1) == 2)
                {
                    temp += .5;
                }
                //desert check
                if (getBiome(x - 1, y - 1) == 4)
                {
                    temp -= .25;
                }
                if (getBiome(x + 1, y - 1) == 4)
                {
                    temp -= .25;
                }
                if (getBiome(x - 1, y + 1) == 4)
                {
                    temp -= .25;
                }
                if (getBiome(x + 1, y + 1) == 4)
                {
                    temp -= .25;
                }
                if (getBiome(x - 1, y) == 4)
                {
                    temp -= .5;
                }
                if (getBiome(x + 1, y) == 4)
                {
                    temp -= .5;
                }
                if (getBiome(x, y - 1) == 4)
                {
                    temp -= .5;
                }
                if (getBiome(x, y + 1) == 4)
                {
                    temp -= .5;
                }
                // desert tile check
                if (getBiome(x, y) == 4)
                {
                    temp = .2;
                }
                if (temp < 0)

                {
                    temp = .25;
                }
                cell.getCell(x, y).resources().setFertility(temp);
            }
        }
    } //end method

    public void mining()
    {
        double temp;
        for (int x = 0; x < 20; x++)
        {
            for (int y = 0; y < 20; y++)
            {
                temp = 1;
                //desert check
                if (getBiome(x - 1, y - 1) == 4)
                {
                    temp += .15;
                }
                if (getBiome(x + 1, y - 1) == 4)
                {
                    temp += .15;
                }
                if (getBiome(x - 1, y + 1) == 4)
                {
                    temp += .15;
                }
                if (getBiome(x + 1, y + 1) == 4)
                {
                    temp += .15;
                }
                if (getBiome(x - 1, y) == 4)
                {
                    temp += .25;
                }
                if (getBiome(x + 1, y) == 4)
                {
                    temp += .25;
                }
                if (getBiome(x, y - 1) == 4)
                {
                    temp += .25;
                }
                if (getBiome(x, y + 1) == 4)
                {
                    temp += .25;
                }
                // desert tile check
                if (getBiome(x, y) == 4)
                {
                    temp = 2;
                }
                //moutian check
                if (getBiome(x - 1, y - 1) == 1)
                {
                    temp += .25;
                }
                if (getBiome(x + 1, y - 1) == 1)
                {
                    temp += .25;
                }
                if (getBiome(x - 1, y + 1) == 1)
                {
                    temp += .25;
                }
                if (getBiome(x + 1, y + 1) == 1)
                {
                    temp += .25;
                }
                if (getBiome(x - 1, y) == 1)
                {
                    temp += .5;
                }
                if (getBiome(x + 1, y) == 1)
                {
                    temp += .5;
                }
                if (getBiome(x, y - 1) == 1)
                {
                    temp += .5;
                }
                if (getBiome(x, y + 1) == 1)
                {
                    temp += .5;
                }
                if (temp < 0)

                {
                    temp = .25;
                }
                cell.getCell(x, y).resources().setMining(temp);
            }
        }
    }//end method

    public void lumber()
    {
        double temp;
        for (int x = 0; x < 20; x++)
        {
            for (int y = 0; y < 20; y++)
            {
                temp = 1;
                //water check
                if (getBiome(x - 1, y - 1) == 3)
                {
                    temp += .25;
                }
                if (getBiome(x + 1, y - 1) == 3)
                {
                    temp += .25;
                }
                if (getBiome(x - 1, y + 1) == 3)
                {
                    temp += .25;
                }
                if (getBiome(x + 1, y + 1) == 3)
                {
                    temp += .25;
                }
                if (getBiome(x - 1, y) == 3)
                {
                    temp += .5;
                }
                if (getBiome(x + 1, y) == 3)
                {
                    temp += .5;
                }
                if (getBiome(x, y - 1) == 3)
                {
                    temp += .5;
                }
                if (getBiome(x, y + 1) == 3)
                {
                    temp += .5;
                }
                //desert check
                if (getBiome(x - 1, y - 1) == 4)
                {
                    temp -= .25;
                }
                if (getBiome(x + 1, y - 1) == 4)
                {
                    temp -= .25;
                }
                if (getBiome(x - 1, y + 1) == 4)
                {
                    temp -= .25;
                }
                if (getBiome(x + 1, y + 1) == 4)
                {
                    temp -= .25;
                }
                if (getBiome(x - 1, y) == 4)
                {
                    temp -= .5;
                }
                if (getBiome(x + 1, y) == 4)
                {
                    temp -= .5;
                }
                if (getBiome(x, y - 1) == 4)
                {
                    temp -= .5;
                }
                if (getBiome(x, y + 1) == 4)
                {
                    temp -= .5;
                }
                // desert tile check
                if (getBiome(x, y) == 4)
                {
                    temp = .2;
                }
                if (temp < 0)

                {
                    temp = .25;
                }
                if (getBiome(x, y) == 3)
                {
                    temp = 4;
                }
                cell.getCell(x, y).resources().setLumber(temp);
                x++;
            }
        }
    } //end method

    public int getBiome(int x, int y)
    {
        try
        {
            return cell.getCell(x, y).biome().getType();
        } catch (Exception e)
        {
        }
        return -2;
    }
}
