package player.conditions;

/*
    BenjaminWilcox
    Dec 16, 2016
    GNGH_2
 */
public class DayCondition
{

    int day = 2000;

    public DayCondition()
    {

    }

    public boolean compare(int d)
    {
        if (d >= day)
            return true;
        return false;
    }
}
