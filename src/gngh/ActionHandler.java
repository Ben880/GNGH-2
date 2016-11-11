package gngh;

/*
    BenjaminWilcox
    Nov 9, 2016
    GNGH_2
 */
public class ActionHandler
{

    ButtonHandler button;

    public ActionHandler(Handler h)
    {
        button = new ButtonHandler(h);
    }

    public ButtonHandler button()
    {
        return button;
    }
}
