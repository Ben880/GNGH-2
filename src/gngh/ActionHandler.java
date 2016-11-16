package gngh;

/*
    BenjaminWilcox
    Nov 9, 2016
    GNGH_2
 */
public class ActionHandler
{

    ButtonHandler button;
    private static ActionHandler instance;

    private ActionHandler()
    {
        button = new ButtonHandler();
    }

    public static ActionHandler getInstance()
    {
        if (instance == null)
            instance = new ActionHandler();
        return instance;
    }

    public ButtonHandler button()
    {
        return button;
    }
}
