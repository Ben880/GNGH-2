package gngh;

import util.Resource;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class ResourceProduction
{

    private Resource food = new Resource();
    private static ResourceProduction instance = null;
    private Info info;

    private ResourceProduction()
    {
        info = Info.getInstance();
        setup();
    }

    private void setup()
    {
        food.setNumStipulations(5);
        food.modifyStipulation(0, 100, 1);
        food.modifyStipulation(1, info.resources().getPeople(), -2);
        food.modifyStipulation(2, info.resources().getTroops(), -3);
        food.modifyStipulation(3, info.resources().getAnimals(), -4);
        food.modifyStipulation(4, info.resources().getHorses(), -5);
    }

    private void update()
    {
        food.modifyBase(1, info.resources().getPeople());
        food.modifyBase(2, info.resources().getTroops());
        food.modifyBase(3, info.resources().getAnimals());
        food.modifyBase(4, info.resources().getHorses());
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
        info.resources().setFood(info.resources().getFood() + food());
        info.resources().setLumber(info.resources().getLumber() + 50);
        info.resources().setStone(info.resources().getStone() + 10);
        info.resources().setOre(info.resources().getOre() + 5);
        info.resources().setPeople(info.resources().getPeople() + 2);
    }

    public int food()
    {
        return food.calculate();
    }
}
