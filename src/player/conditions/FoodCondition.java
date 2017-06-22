package player.conditions;

import player.resources.ResourceHolder;

/*
    BenjaminWilcox
    Dec 16, 2016
    GNGH_2
 */
public class FoodCondition
{

    ResourceHolder resources = new ResourceHolder();

    public FoodCondition()
    {

    }

    public boolean compare()
    {
        if (resources.food().get() <= 0)
            return true;
        return false;
    }

}
