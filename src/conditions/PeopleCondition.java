package conditions;

import resources.Resources;

/*
    BenjaminWilcox
    Dec 16, 2016
    GNGH_2
 */
public class PeopleCondition
{

    Resources resources = new Resources();

    public PeopleCondition()
    {

    }

    public boolean compare()
    {
        if (resources.getPeople() <= 0)
            return true;
        return false;
    }

}
