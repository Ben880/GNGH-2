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

    void updte()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
