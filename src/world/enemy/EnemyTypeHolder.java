package world.enemy;

import java.util.ArrayList;

/*
    BenjaminWilcox
    Jul 13, 2017
    GNGH2
 */
public class EnemyTypeHolder
{

    private static ArrayList<EnemyType> type = new ArrayList();
    private static EnemyTypeLoader loder = new EnemyTypeLoader();

    public EnemyTypeHolder()
    {

    }

    public void addEnemy(String name)
    {
        type.add(new EnemyType(name));
    }

    public EnemyType getEnemy(int i)
    {
        return type.get(i);
    }

    public int size()
    {
        return type.size();
    }

    public void print()
    {
        System.out.println("----Enemy List-------");
        for (int i = 0; i < type.size(); i++)
        {
            System.out.println(type.get(i).getName());
        }
    }
}
