package gngh;

import java.util.Random;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class Calculator
{
//calculates most things (excluding resources and world gen)

    VisibleInfo info;
    DayTracker day;
    ResourceTracker resources;
    EnemyInfo enemy;
    Random rand = new Random();

    public int disEQ(int x, int y)
    {
        int distance = (int) Math.round(Math.sqrt(Math.pow(19 - x, 2) + Math.pow(19 - y, 2)));
        return distance;
    }

    public int scoutDays(int x, int y)
    {
        day = DayTracker.getInstance();
        int days = disEQ(x, y) * 6 + day.getDay();
        return days;
    }

    public int forageDays(int x, int y)
    {
        return (disEQ(x, y) * 8 + day.getDay());
    }

    public double forageFood(int x, int y)
    {
        info = VisibleInfo.getInstance();
        return (info.getFertility(x, y) * 500);
    }

    public void attack(int x, int y, int troops, EventHolder event)
    {
        enemy = EnemyInfo.getInstance();
        int treturn = troops;
        int enemies = enemy.getAmount(x, y);
        int ratio = (int) (enemy.getSkill(x, y) / .2);
        int i = 0;
        while (enemies > 0 && treturn > 0)
        {
            if (rand.nextInt(100) > ratio)
            {
                enemies--;
            } else
            {
                treturn--;
            }
        }
        if (enemy.getAmount(x, y) == enemies)
        {
            event.setMessage("Troops did not return from battle");
        } else
        {
            event.setTroops(treturn);
            event.setEnemies(enemies);
        }
    }

}
