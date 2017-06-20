package gui.main;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import util.GUIPallet;

/*
    BenjaminWilcox
    Jun 11, 2017
    GNGH_2
 */
class ResourcesTab extends JPanel
{

    GUIPallet pallet = new GUIPallet();

    public ResourcesTab()
    {
        new UpdateGUI().passTab(this);
        setLayout(new BorderLayout());
        setBackground(pallet.getPanel());
    }

    public void updte()
    {

    }

}
