package gngh;

/*
    BenjaminWilcox
    Nov 9, 2016
    GNGH_2
 */
public class Initialize
{

    static MainFrame frame;
    static Info info;
    static Tracker tracker;
    static Handler handler;

    Initialize(MainFrame f)
    {
        frame = f;
        info = Info.getInstance();
        tracker = Tracker.getInstance();
        handler = Handler.getInstance();
        tracker.day().Initialize(tracker, handler);
        tracker.event().Initialize(info, tracker, handler);
        handler.gui().label().initialize(info, frame, tracker);
        handler.action().button().initialize(info, tracker, frame);

    }
}
