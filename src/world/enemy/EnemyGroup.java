package world.enemy;

/*
    BenjaminWilcox
    Jul 13, 2017
    GNGH2
 */
public class EnemyGroup
{

    private int count = 0;
    private String name = "none";
    private double attack = 0;
    private double defense = 0;

    public EnemyGroup()
    {

    }

    public void reset()
    {
        setCount(0);
        setName("none");
        setAttack(0);
        setDefense(0);
    }

    public void populate(EnemyType type, int count)
    {

    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public void subtract(int i)
    {
        setCount(getCount() - i);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getAttack()
    {
        return attack;
    }

    public void setAttack(double attack)
    {
        this.attack = attack;
    }

    public double getDefense()
    {
        return defense;
    }

    public void setDefense(double defense)
    {
        this.defense = defense;
    }

}
