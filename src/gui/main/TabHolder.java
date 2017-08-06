package gui.main;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
import java.awt.Dimension;
import javax.swing.JTabbedPane;

public class TabHolder extends JTabbedPane
{

    private WorldTab world = new WorldTab();
    private JobTab jobs = new JobTab();
    private ResourcesTab resources = new ResourcesTab();
    private ResearchTab research = new ResearchTab();
    private DebugTab debug = new DebugTab();

    //holds all the tabs
    public TabHolder()
    {
        new UpdateGUI().passTabHolder(this);
        setPreferredSize(new Dimension(390, 540));
        addTab("World", world);
        addTab("Jobs", jobs);
        addTab("Resources", resources);
        addTab("Research", research);
        addTab("Debug", debug);

    }

    public void setSelected(int i)
    {
        setSelectedIndex(i);
    }

}
