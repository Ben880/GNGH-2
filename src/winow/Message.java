package winow;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import util.GUIPallet;

/*
    BenjaminWilcox
    Dec 22, 2016
    GNGH_2
 */
public class Message
{

    JLabel message = new JLabel();
    GUIPallet pallet = new GUIPallet();

    public boolean confirm(String dialouge, String title)
    {
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", pallet.getPanel());
        UI.put("Panel.background", pallet.getPanel());
        message.setText(dialouge + "?");
        final JComponent[] inputs = new JComponent[]
        {
            message
        };
        int result = JOptionPane.showConfirmDialog(null, inputs, title, JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE);
        System.out.println("User aknowledged dialouge result = " + result);
        return true;

    }
}
