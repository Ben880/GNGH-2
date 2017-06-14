package debug;

import gui.main.ConsoleHandler;


/*
    BenjaminWilcox
    Nov 17, 2016
    GNGH_2
 */
public class DebugInfo
{

    private static boolean debug = false;
    private static ConsoleHandler console = new ConsoleHandler();

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
