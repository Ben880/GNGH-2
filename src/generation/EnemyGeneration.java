package generation;

import cell.CellHolder;
import enemy.EnemyInfo;
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
        int i = 0;
        int x = 0;
        int y = 0;
        while (i < 400)
        {
            if (x == 20)
            {
                x = 0;
                y++;
            }
            if (!(cell.getCell(x, y).biome().getType() == 2))
            {
                if (rand.nextInt(100) < 35)
                {
                    enemy.setType(x, y, rand.nextInt(25));
                    enemy.setSkill(x, y, 19 - (int) Math.round(Math.sqrt(rand.nextInt(400))));
                    enemy.setAmount(x, y, 19 - (int) Math.round(Math.sqrt(rand.nextInt(400))));

                }//end create enemy if
                else
                {
                    enemy.setType(x, y, -1);
                }
            }//end land check if
            else
            {
                enemy.setType(x, y, -1);
            }
            i++;
            x++;
        }
    }
}
