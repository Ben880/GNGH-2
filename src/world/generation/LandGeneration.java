package world.generation;

import world.CellHolder;
import java.util.Random;

/*
    BenjaminWilcox
    Dec 5, 2016
    GNGH_2
 */
public class LandGeneration
{

    CellHolder cell = new CellHolder();
    Random rand = new Random();

    public void layGrass()
    {
        for (int x = 0; x < 20; x++)
        {
            for (int y = 0; y < 20; y++)
            {
                cell.getCell(x, y).setBiome(0);
                cell.getCell(x, y).visible().setBiomeVisible(false);
                cell.getCell(x, y).visible().setStatsVisible(false);
                cell.getCell(x, y).owned().setOwned(false);
                cell.getCell(x, y).owned().setNeutral(true);
            }
        }
    }

    public void desert() //4
    {
        int desert = rand.nextInt(399);
        int shape = rand.nextInt(5);
        int y = desert / 20;
        int x = desert % 20;
        if (shape >= 0)
        {
            setBiome(x + 0, y + 0, 4);
            setBiome(x + 1, y + 0, 4);
            setBiome(x + 0, y + 1, 4);
            setBiome(x - 1, y + 0, 4);
            setBiome(x + 0, y - 1, 4);
            setBiome(x + 1, y + 1, 4);
            setBiome(x + 2, y + 0, 4);
        }
        if (shape > 0)
        {
            setBiome(x + 2, y + 1, 4);
            setBiome(x + 3, y + 0, 4);
            setBiome(x + 2, y - 1, 4);
            setBiome(x + 1, y - 1, 4);
        }
        if (shape > 1)
        {
            setBiome(x + 3, y + 1, 4);
            setBiome(x + 1, y + 2, 4);
            setBiome(x + 4, y + 0, 4);
        }
        if (shape > 2)
        {
            setBiome(x - 1, y - 1, 4);
            setBiome(x - 1, y + 1, 4);
            setBiome(x - 2, y + 0, 4);
            setBiome(x + 2, y + 2, 4);
            setBiome(x + 0, y - 2, 4);
            setBiome(x + 1, y - 2, 4);
        }
    } //end method

    public void forest() //3
    {
        int forest = rand.nextInt(399);
        int shape = rand.nextInt(5);
        int y = forest / 20;
        int x = forest % 20;
        if (shape >= 0)
        {
            setBiome(x + 0, y + 0, 3);
            setBiome(x + 1, y + 0, 3);
            setBiome(x + 0, y + 1, 3);
            setBiome(x - 1, y + 0, 3);
            setBiome(x + 0, y - 1, 3);
            setBiome(x + 1, y + 1, 3);
            setBiome(x + 2, y + 0, 3);

            setBiome(x + 2, y + 1, 3);
            setBiome(x + 3, y + 0, 3);
            setBiome(x + 2, y - 1, 3);
            setBiome(x + 1, y - 1, 3);
        }
        if (shape > 0)
        {
            setBiome(x + 3, y + 1, 3);
            setBiome(x + 1, y + 2, 3);
            setBiome(x + 4, y + 0, 3);
        }
        if (shape > 1)
        {
            setBiome(x - 1, y - 1, 3);
            setBiome(x - 1, y + 1, 3);
            setBiome(x - 2, y + 0, 3);
            setBiome(x + 2, y + 2, 3);
            setBiome(x + 0, y - 2, 3);
            setBiome(x + 1, y - 2, 3);
        }
    } //end method

    public void water() //2
    {
        int water = rand.nextInt(399);
        int shape = rand.nextInt(5);
        int y = water / 20;
        int x = water % 20;
        if (shape >= 0)
        {
            setBiome(x + 0, y + 0, 2);
            setBiome(x + 1, y + 0, 2);
        }
        if (shape > 0)
        {
            setBiome(x + 0, y + 1, 2);
        }
        if (shape > 1)
        {
            setBiome(x - 1, y + 0, 2);
        }
        if (shape > 2)
        {
            setBiome(x + 0, y - 1, 2);
        }
        if (shape > 3)
        {
            setBiome(x + 1, y + 1, 2);
        }
    } //end method

    public void mountian() //1
    {
        boolean fail = true;
        while (fail)
        {
            int mountian = rand.nextInt(399);
            int shape = rand.nextInt(5);
            int y = mountian / 20;
            int x = mountian % 20;
            if (cell.getCell(x, y).biome().getType() == 0)
            {
                fail = false;
                if (shape >= 0)
                {
                    setBiome(x + 0, y + 0, 1);
                    setBiome(x + 1, y + 0, 1);
                    setBiome(x + 0, y + 1, 1);
                    setBiome(x - 1, y + 0, 1);
                    setBiome(x + 0, y - 1, 1);
                    setBiome(x + 1, y + 1, 1);
                    setBiome(x + 2, y + 0, 1);
                }
                if (shape > 0)
                {
                    setBiome(x + 2, y + 1, 1);
                    setBiome(x + 3, y + 0, 1);
                }
                if (shape > 1)
                {
                    setBiome(x + 2, y - 1, 1);
                    setBiome(x + 1, y - 1, 1);
                }
                if (shape > 2)
                {
                    setBiome(x + 3, y + 1, 1);
                    setBiome(x + 1, y + 2, 1);
                    setBiome(x + 4, y + 0, 1);
                }
                if (shape > 2)
                {
                    setBiome(x - 1, y - 1, 1);
                    setBiome(x - 1, y + 1, 1);
                    setBiome(x - 2, y + 0, 1);
                    setBiome(x + 2, y + 2, 1);
                    setBiome(x + 0, y - 2, 1);
                    setBiome(x + 1, y - 2, 1);
                }
            }
        }

    } //end method

    public void setBiome(int x, int y, int i)
    {
        try
        {
            cell.getCell(x, y).setBiome(i);
        } catch (Exception e)
        {

        }
    }
}
