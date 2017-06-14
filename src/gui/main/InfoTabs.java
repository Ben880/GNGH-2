package gui.main;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;

public class InfoTabs extends JTabbedPane
{

    Color background = new Color(100, 100, 100);
    Color panel = new Color(170, 170, 170);
    Border emptyBorder = BorderFactory.createEmptyBorder();
    TabPanel world;
    JobTab jobs;
    TabPanel resources;
    TabPanel research;

    public InfoTabs()
    {
        setPreferredSize(new Dimension(390, 540));
        world = new TabPanel(0);
        jobs = new JobTab();
        resources = new TabPanel(2);
        research = new TabPanel(3);
        addTab("World", world);
        addTab("Jobs", jobs);
        addTab("Resources", resources);
        addTab("Research", research);
        setBackgroundAt(0, new Color(250, 250, 250));
        setBackgroundAt(1, new Color(250, 250, 250));
        setBackgroundAt(2, new Color(250, 250, 250));
        setBackgroundAt(3, new Color(250, 250, 250));

    }

    public void setText(int l, int i, String s)
    {
        if (l == 0)
            world.setText(i, s);
//        if (l == 1)
//            jobs.setText(i, s);
        if (l == 2)
            resources.setText(i, s);
        if (l == 3)
            research.setText(i, s);
    }
}
