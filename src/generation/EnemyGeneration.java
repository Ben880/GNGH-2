package generation;

/*
    BenjaminWilcox
    Dec 5, 2016
    GNGH_2
 */
public class EnemyGeneration
{

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
            if (!(getBiome(x, y) == 2))
            {
                if (rand.nextInt(100) < 35)
                {
                    info.enemy.setType(x, y, rand.nextInt(25));
                    info.enemy.setSkill(x, y, 19 - (int) Math.round(Math.sqrt(rand.nextInt(400))));
                    info.enemy.setAmount(x, y, 19 - (int) Math.round(Math.sqrt(rand.nextInt(400))));

                }//end create enemy if
                else
                {
                    info.enemy.setType(x, y, -1);
                }
            }//end land check if
            else
            {
                info.enemy.setType(x, y, -1);
            }
            i++;
            x++;
        }
    }
}
