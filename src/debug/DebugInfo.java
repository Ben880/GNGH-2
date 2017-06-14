package debug;

import gui.main.ButtonDisplayHandler;
import gui.main.ConsoleHandler;
import gui.main.LabelHandler;

/*
    BenjaminWilcox
    Nov 17, 2016
    GNGH_2
 */
public class DebugInfo
{

    private static boolean debug = false;
    private static ConsoleHandler console = new ConsoleHandler();
    private static ButtonDisplayHandler buttons = new ButtonDisplayHandler();
    private static LabelHandler labels = new LabelHandler();

    public DebugInfo()
    {
    }

    public void toggleDebug()
    {
        if (debug)
            debug = false;
        else
            debug = true;
        console.append("Debug: " + debug);
//        buttons.debug(debug);
//        labels.debug(debug);
    }

    public boolean getDebug()
    {
        return debug;
    }

    public void setDebug(boolean b)
    {
        if (b != debug)
            toggleDebug();
    }
}
