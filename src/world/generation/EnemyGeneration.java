package world.generation;

import java.util.Random;
import world.CellHolder;
import world.enemy.EnemyTypeHolder;

/*
    BenjaminWilcox
    Dec 5, 2016
    GNGH_2
 */
public class EnemyGeneration
{

    private static EnemyTypeHolder type = new EnemyTypeHolder();
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
                        createEnemy(x, y);
                    } else
                        setNone(x, y);
                } else
                    setNone(x, y);
            }
        }
    }

    private void createEnemy(int x, int y)
    {
        int temp = decision();
        cell.getCell(x, y).enemy().setName(type.getEnemy(temp).getName());
        cell.getCell(x, y).enemy().setAttack(type.getEnemy(temp).getAttack());
        cell.getCell(x, y).enemy().setDefense(type.getEnemy(temp).getDefense());
        cell.getCell(x, y).enemy().setCount((int) Math.ceil(type.getEnemy(temp).getMultiplyer() * rand.nextInt(10)));
    }

    private int decision()
    {
        int temp = 0;
        while (true)
        {
            temp = rand.nextInt(type.size() - 1);
            if (rand.nextInt(100) <= type.getEnemy(temp).getChance())
                return temp;
        }
    }

    void setNone(int x, int y)
    {
        cell.getCell(x, y).enemy().reset();
    }
}
