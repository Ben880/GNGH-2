package resources;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class Resources
{

    //tracks current amount of resources
    private static int food;
    private static int lumber;
    private static int stone;
    private static int ore;
    private static int tools;
    private static int animals;
    private static int horses;
    private static int people;
    private static int troops;
    private static int medicine;

    public Resources()
    {
        food = 2000;
        lumber = 300;
        ore = 20;
        tools = 10;
        animals = 10;
        people = 100;
        troops = 10;
        medicine = 10;
    }

    public void dayChange()
    {

    }

    //getters and setters
    public int getFood()
    {
        return food;
    }

    public void setFood(int food)
    {
        this.food = food;
    }

    public int getLumber()
    {
        return lumber;
    }

    public void setLumber(int lumber)
    {
        this.lumber = lumber;
    }

    public int getStone()
    {
        return stone;
    }

    public void setStone(int stone)
    {
        this.stone = stone;
    }

    public int getOre()
    {
        return ore;
    }

    public void setOre(int ore)
    {
        this.ore = ore;
    }

    public int getTools()
    {
        return tools;
    }

    public void setTools(int tools)
    {
        this.tools = tools;
    }

    public int getAnimals()
    {
        return animals;
    }

    public void setAnimals(int animals)
    {
        this.animals = animals;
    }

    public int getHorses()
    {
        return horses;
    }

    public void setHorses(int horses)
    {
        this.horses = horses;
    }

    public int getPeople()
    {
        return people;
    }

    public void setPeople(int people)
    {
        this.people = people;
    }

    public int getTroops()
    {
        return troops;
    }

    public void setTroops(int troops)
    {
        this.troops = troops;
    }

    public int getMedicine()
    {
        return medicine;
    }

    public void setMedicine(int medicine)
    {
        this.medicine = medicine;
    }
}