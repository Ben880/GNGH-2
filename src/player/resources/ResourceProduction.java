package player.resources;

import util.Resource;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class ResourceProduction
{

    private Resource food = new Resource();
    private static ResourceProduction instance = null;
    ResourceHolder resources = new ResourceHolder();

    private ResourceProduction()
    {
        setup();
    }

    private void setup()
    {
//        food.setNumStipulations(5);
//        food.modifyStipulation(0, 100, 1);
//        food.modifyStipulation(1, resources.people().get(), -2);
//        food.modifyStipulation(2, resources.troops().get(), -3);
//        food.modifyStipulation(3, resources.animals().get(), -4);
//        food.modifyStipulation(4, resources.horses().get(), -5);
    }

    private void update()
    {
//        food.modifyBase(1, resources.people().get());
//        food.modifyBase(2, resources.troops().get());
//        food.modifyBase(3, resources.animals().get());
//        food.modifyBase(4, resources.horses().get());
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
//        update();
//        resources.food().set(resources.food().get() + food());
    }

    public int food()
    {
        return food.calculate();
    }
}
