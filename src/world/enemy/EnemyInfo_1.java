package world.enemy;

import java.util.Random;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class EnemyInfo_1
{

    private int[][] type = new int[20][20];
    private String[][] stype = new String[20][20];
    private int[][] amount = new int[20][20];
    private int[][] skill = new int[20][20];
    Random rand = new Random();

    public EnemyInfo_1()
    {

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
    public void setType(int x, int y, int i)
    {
        type[x][y] = i;
        setTypeString(x, y, i);
    }

    public void setTypeString(int x, int y, int i)
    {
        switch (i)
        {
            case -1:
                stype[x][y] = "none";
                break;
            case 0:
                stype[x][y] = "Bear";
                break;
            case 1:
                stype[x][y] = "Boar";
                break;
            case 2:
                stype[x][y] = "Mamoth";
                break;
            case 3:
                stype[x][y] = "Savages";
                break;
            case 4:
                stype[x][y] = "Outlaws";
                break;
            case 5:
                stype[x][y] = "Giants";
                break;
            case 6:
                stype[x][y] = "Bandits";
                break;
            case 7:
                stype[x][y] = "Dragon";
                break;
            case 8:
                stype[x][y] = "Killer bees";
                break;
            case 9:
                stype[x][y] = "Witches";
                break;
            case 10:
                stype[x][y] = "Unnamed";
                break;
            default:
                stype[x][y] = "Default Enemy";
                break;

        }

    }

    public void setAmount(int x, int y, int type)
    {
        this.amount[x][y] = type;
    }

    public void setSkill(int x, int y, int type)
    {
        this.skill[x][y] = type;
    }

    //get
    public int getType(int x, int y)
    {
        return type[x][y];
    }

    public String getTypeString(int x, int y)
    {
        return stype[x][y];
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
