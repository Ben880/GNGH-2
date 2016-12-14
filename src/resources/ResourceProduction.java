package resources;

import util.Resource;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class ResourceProduction
{

    private Resource food = new Resource();
    private static ResourceProduction instance = null;
    Resources resources = new Resources();

    private ResourceProduction()
    {
        setup();
    }

    private void setup()
    {
        food.setNumStipulations(5);
        food.modifyStipulation(0, 100, 1);
        food.modifyStipulation(1, resources.getPeople(), -2);
        food.modifyStipulation(2, resources.getTroops(), -3);
        food.modifyStipulation(3, resources.getAnimals(), -4);
        food.modifyStipulation(4, resources.getHorses(), -5);
    }

    private void update()
    {
        food.modifyBase(1, resources.getPeople());
        food.modifyBase(2, resources.getTroops());
        food.modifyBase(3, resources.getAnimals());
        food.modifyBase(4, resources.getHorses());
    }

    public static ResourceProduction getInstance()
    {
        if (instance == null)
        {
            instance = new ResourceProduction();
        }
        return instance;
    }

    public void dayChange()
    {
        update();
        resources.setFood(resources.getFood() + food());
        resources.setLumber(resources.getLumber() + 50);
        resources.setStone(resources.getStone() + 10);
        resources.setOre(resources.getOre() + 5);
        resources.setPeople(resources.getPeople() + 2);
    }

    public int food()
    {
        return food.calculate();
    }
}
