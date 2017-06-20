package gui.main;

import gui.main.JobTab;
import gui.main.ResearchTab;
import gui.main.ResourcesTab;
import gui.main.WorldTab;

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

    public UpdateGUI()
    {

    }

    public void update()
    {
        job.update();
        research.update();
        world.update();
        resources.updte();
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

}
