package conditions;

import resources.Resources;

/*
    BenjaminWilcox
    Dec 16, 2016
    GNGH_2
 */
public class FoodCondition
{

    Resources resources = new Resources();

    public FoodCondition()
    {

    }

    public boolean compare()
    {
        if (resources.getFood() <= 0)
            return true;
        return false;
    }

}
