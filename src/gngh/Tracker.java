package gngh;

/*
    BenjaminWilcox
    Nov 9, 2016
    GNGH_2
 */
public class Tracker
{

    private DayTracker day;

    private static Tracker instance = null;

    private Tracker()
    {
        day = new DayTracker(this);
    }

    public static Tracker getInstance()
    {
        if (instance == null)
            instance = new Tracker();
        return instance;
    }

    public DayTracker day()
    {
        return day;
    }

}
