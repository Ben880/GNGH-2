package gngh;

/*
    BenjaminWilcox
    Nov 9, 2016
    GNGH_2
 */
public class ActionHandler
{

    ButtonHandler button;

    public ActionHandler()
    {
        button = ButtonHandler.getInstance();
    }

    public ButtonHandler button()
    {
        return button;
    }
}
