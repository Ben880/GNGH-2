package gngh;

/*
    BenjaminWilcox
    Oct 12, 2016
    CIS 2151 O1500
    Teusday 6-10
 */
public class ResearchHandler
{

    private static ResearchHandler instance = null;

    MyFrame frame;
    boolean researching = false;

    private ResearchHandler()
    {
        frame = MyFrame.getInstance("GNGH");
    }

    public static ResearchHandler getInstance()
    {
        if (instance == null)
        {
            instance = new ResearchHandler();
        }
        return instance;
    }

    public void research(String s)
    {
        if (researching)
        {
            frame.console("You are already researching a project");
        } else
        {
            //project selector
        }
    }

}
