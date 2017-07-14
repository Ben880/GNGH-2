package world.enemy;

/*
    BenjaminWilcox
    Jul 13, 2017
    GNGH2
 */
public class EnemyType
{

    private String name;
    private double attack = 0;
    private double defense = 0;
    private double multiplyer = 0;
    private double chance = 0;

    public EnemyType(String n)
    {
        name = n;
    }

    public double getAttack()
    {
        return attack;
    }

    public void setAttack(double attack)
    {
        this.attack = attack;
    }

    public double getMultiplyer()
    {
        return multiplyer;
    }

    public void setMultiplyer(double multiplyer)
    {
        this.multiplyer = multiplyer;
    }

    public double getChance()
    {
        return chance;
    }

    public void setChance(double chance)
    {
        this.chance = chance;
    }

    public double getDefense()
    {
        return defense;
    }

    public void setDefense(double defense)
    {
        this.defense = defense;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

}
