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

    public GUIHandler()
    {
        label = new LabelHandler();
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

    public void setFrame(MainFrame f)
    {
        frame = new FrameHandler(f);
    }
}
