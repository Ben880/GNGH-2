package gngh;

/*
    BenjaminWilcox
    Nov 9, 2016
    GNGH_2
 */
public class GUIHandler
{

    LabelHandler label;
    ButtonDisplayHandler button;
    FrameHandler frame;
    ConsoleHandler console;
    private static GUIHandler instance;

    private GUIHandler()
    {
        label = new LabelHandler();
        button = new ButtonDisplayHandler();
        console = new ConsoleHandler();
    }

    public static GUIHandler getInstance()
    {
        if (instance == null)
            instance = new GUIHandler();
        return (instance);
    }

    public LabelHandler label()
    {
        return label;
    }

    public ButtonDisplayHandler button()
    {
        return button;
    }

    public FrameHandler frame()
    {
        return frame;
    }

    public ConsoleHandler console()
    {
        return console;
    }

    public void passFrame(MainFrame f)
    {
        frame = new FrameHandler(f);
    }
}
