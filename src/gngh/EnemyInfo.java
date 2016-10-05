package gngh;

import java.util.Random;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class EnemyInfo
{

    private int[][] type = new int[20][20];
    private int[][] amount = new int[20][20];
    private int[][] skill = new int[20][20];
    private static EnemyInfo instance = null;
    Random rand = new Random();
    VisibleInfo info;

    private EnemyInfo()
    {

    }

    public static EnemyInfo getInstance()
    {
        if (instance == null)
        {
            instance = new EnemyInfo();
        }
        return instance;
    }

    public void dayChange()
    {
        int r;
        int i;
        int x;
        int y;
        r = rand.nextInt(8);
        i = 0;
        while (i <= i)
        {
            x = rand.nextInt(20);
            y = rand.nextInt(20);
            if (this.amount[x][y] != 0)
                this.amount[x][y] += rand.nextInt(2);
            i++;
        }
        r = rand.nextInt(1);
        i = 0;
        while (i <= i)
        {
            x = rand.nextInt(20);
            y = rand.nextInt(20);
            if (this.amount[x][y] != 0)
                this.skill[x][y] += rand.nextInt(1);
            i++;
        }
    }

    //getters and setters
    public void setType(int x, int y, int type)
    {
        this.type[x][y] = type;
    }

    public void setAmount(int x, int y, int type)
    {
        this.amount[x][y] = type;
    }

    public void setSkill(int x, int y, int type)
    {
        this.skill[x][y] = type;
    }

    public int getType(int x, int y)
    {
        return type[x][y];
    }

    public int getAmount(int x, int y)
    {
        return amount[x][y];
    }

    public int getSkill(int x, int y)
    {
        return skill[x][y];
    }
}
