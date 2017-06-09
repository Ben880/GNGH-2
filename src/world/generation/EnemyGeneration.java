package world.generation;

import world.CellHolder;
import world.enemy.EnemyInfo;
import java.util.Random;

/*
    BenjaminWilcox
    Dec 5, 2016
    GNGH_2
 */
public class EnemyGeneration
{

    EnemyInfo enemy = new EnemyInfo();
    CellHolder cell = new CellHolder();
    Random rand = new Random();

    public void populate()
    {
        //enemy types
        //
        for (int x = 0; x < 20; x++)
        {
            for (int y = 0; y < 20; y++)
            {
                if (!(cell.getCell(x, y).biome().getType() == 2))
                {
                    if (rand.nextInt(100) < 35)
                    {
                        cell.getCell(x, y).setEnemy(rand.nextInt(25));
                        cell.getCell(x, y).enemy().setNumber(19 - (int) Math.round(Math.sqrt(rand.nextInt(400))));
                    } else
                        setNone(x, y);
                } else
                    setNone(x, y);
            }
        }
    }

    void setNone(int x, int y)
    {
        cell.getCell(x, y).setEnemy(0);
    }
}
