package debug;

/*
    BenjaminWilcox
    Nov 17, 2016
    GNGH_2
 */
public class DebugInfo
{

    private static boolean debug = false;

    public DebugInfo()
    {
    }

    public void toggleDebug()
    {
        if (debug)
            debug = false;
        else
            debug = true;
    }

    public boolean getDebug()
    {
        return debug;
    }

    public void setDebug(boolean b)
    {
        debug = b;
    }
}