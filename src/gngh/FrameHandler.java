package gngh;

/*
    BenjaminWilcox
    Oct 26, 2016
    GNGH_2
 */
public class FrameHandler
{

    private static FrameHandler instance = null;
    MainFrame frame;

    private FrameHandler(MainFrame f)
    {
        frame = f;
    }

    public static FrameHandler getInstance(MainFrame f)
    {
        if (instance == null)
            instance = new FrameHandler(f);
        return instance;
    }

    public static FrameHandler getInstance()
    {
        return instance;
    }

    public MainFrame getFrame()
    {
        return frame;
    }

}
