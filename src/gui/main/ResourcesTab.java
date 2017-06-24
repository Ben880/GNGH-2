package gui.main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import util.GUIPallet;

/*
    BenjaminWilcox
    Jun 11, 2017
    GNGH_2
 */
class ResourcesTab extends JPanel
{

    final int NUMRESOURCES = 20;
    GUIPallet pallet = new GUIPallet();

    ResourceBox[] resource = new ResourceBox[NUMRESOURCES];

    public ResourcesTab()
    {
        new UpdateGUI().passTab(this);
        setLayout(new BorderLayout());
        setBackground(pallet.getPanel());
        setLayout(new GridLayout(10, 2));
        for (int i = 0; i < NUMRESOURCES; i++)
        {
            resource[i] = new ResourceBox();
            add(resource[i]);
        }
    }

    public void updte()
    {
        for (int i = 0; i < NUMRESOURCES; i++)
        {
            resource[i].update(i);
        }
    }

}
