package gngh;

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
    TabPanel biome;
    TabPanel base;
    TabPanel resources;
    TabPanel research;

    public InfoTabs()
    {
        setPreferredSize(new Dimension(290, 595));
        biome = new TabPanel(0);
        base = new TabPanel(1);
        resources = new TabPanel(2);
        research = new TabPanel(3);
        addTab("Biome", biome);
        addTab("Base", base);
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
            biome.setText(i, s);
        if (l == 1)
            base.setText(i, s);
        if (l == 2)
            resources.setText(i, s);
        if (l == 3)
            research.setText(i, s);
    }
}
