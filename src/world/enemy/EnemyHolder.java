package world.enemy;

import util.Location;

/*
    BenjaminWilcox
    Jul 13, 2017
    GNGH2
 */
public class EnemyHolder
{

    private static EnemyGroup[][] enemy = new EnemyGroup[20][20];
    private static boolean init = true;

    public EnemyHolder()
    {
        if (init)
            initialize();
    }

    private void initialize()
    {
        for (int x = 0; x < 20; x++)
        {
            for (int y = 0; y < 20; y++)
            {
                enemy[x][y] = new EnemyGroup();
            }
        }
        init = false;
    }

    public EnemyGroup getEnemy(Location l)
    {
        return enemy[l.getX()][l.getY()];
    }

}
