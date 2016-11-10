package gngh;

/*
    BenjaminWilcox
    Nov 9, 2016
    GNGH_2
 */
public class Handler
{

    ActionHandler action;
    GUIHandler gui;

    public static Handler instance;

    private Handler()
    {
        action = new ActionHandler();
        gui = new GUIHandler();
    }

    public static Handler getInstance()
    {
        if (instance == null)
            instance = new Handler();
        return instance;
    }

    public ActionHandler action()
    {
        return action;
    }

    public GUIHandler gui()
    {
        return gui;
    }
}
