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

    void update()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
