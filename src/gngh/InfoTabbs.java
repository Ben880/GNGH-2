package gngh;

/*
    BenjaminWilcox
    Oct 21, 2016
    CIS 2151 O1500
    Teusday 6-10
 */
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;

public class InfoTabbs extends JTabbedPane
{

    Color background = new Color(100, 100, 100);
    Color panel = new Color(170, 170, 170);
    Border emptyBorder = BorderFactory.createEmptyBorder();
    TabbPanel biome;
    TabbPanel base;
    TabbPanel resources;
    TabbPanel research;

    public InfoTabbs()
    {
        biome = new TabbPanel(0);
        base = new TabbPanel(1);
        resources = new TabbPanel(2);
        research = new TabbPanel(3);
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
