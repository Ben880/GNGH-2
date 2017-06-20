package gui.main;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import util.GUIPallet;

/*
    BenjaminWilcox
    Jun 10, 2017
    GNGH_2
 */
public class ResearchTab extends JPanel
{

    GUIPallet pallet = new GUIPallet();

    public ResearchTab()
    {
        new UpdateGUI().passTab(this);
        setLayout(new BorderLayout());
        setBackground(pallet.getPanel());
    }

    public void update()
    {

    }

}
