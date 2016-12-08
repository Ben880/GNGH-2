package enemy;

/*
    BenjaminWilcox
    Nov 30, 2016
    GNGH_2
 */
public class Enemy
{

    int type;
    String name;
    double health;
    int defense;
    int attack;
    int number;

    public int getType()
    {
        return type;
    }

    public String getName()
    {
        return name;
    }

    public double getDefense()
    {
        return defense;
    }

    public double getAttack()
    {
        return attack;
    }

    public int getAmount()
    {
        return number;
    }

    public void setNumber(int i)
    {
        number = i;
    }

    public void setHealth(double d)
    {
        health = d;
    }
}
