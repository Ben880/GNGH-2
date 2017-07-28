package gui.main;

/*
    BenjaminWilcox
    Jun 11, 2017
    GNGH_2
 */
public class UpdateGUI
{

    private static JobTab job;
    private static ResearchTab research;
    private static WorldTab world;
    private static ResourcesTab resources;
    private static DebugTab debug;

    //accepts gui elements for use in updating entire gui
    public UpdateGUI()
    {

    }

    public void update()
    {
        job.update();
        research.update();
        world.update();
        resources.updte();
        debug.update();
    }

    public void passTab(JobTab tab)
    {
        job = tab;
    }

    public void passTab(WorldTab tab)
    {
        world = tab;
    }

    public void passTab(ResearchTab tab)
    {
        research = tab;
    }

    public void passTab(ResourcesTab tab)
    {
        resources = tab;
    }

    public void passTab(DebugTab tab)
    {
        debug = tab;
    }

}
