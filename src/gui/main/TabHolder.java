package gui.main;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
import java.awt.Dimension;
import javax.swing.JTabbedPane;

public class TabHolder extends JTabbedPane
{

    //
    WorldTab world = new WorldTab();
    JobTab jobs = new JobTab();
    ResourcesTab resources = new ResourcesTab();
    ResearchTab research = new ResearchTab();

    public TabHolder()
    {
        setPreferredSize(new Dimension(390, 540));
        addTab("World", world);
        addTab("Jobs", jobs);
        addTab("Resources", resources);
        addTab("Research", research);
//        setBackgroundAt(0, new Color(250, 250, 250));
//        setBackgroundAt(1, new Color(250, 250, 250));
//        setBackgroundAt(2, new Color(250, 250, 250));
//        setBackgroundAt(3, new Color(250, 250, 250));

    }

}
