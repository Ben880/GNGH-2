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
    TileHandler tile;
    FrameHandler frame;

    public GUIHandler(Handler h)
    {
        label = new LabelHandler(h);
    }

    public LabelHandler label()
    {
        return label;
    }

    public ButtonDisplayHandler button()
    {
        return button;
    }

    public TileHandler tile()
    {
        return tile;
    }

    public FrameHandler frame()
    {
        return frame;
    }

    public void passFrame(MainFrame f)
    {
        frame = new FrameHandler(f);
    }
}
