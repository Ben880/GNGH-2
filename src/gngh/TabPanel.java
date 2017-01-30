package gngh;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import util.GUIPallet;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class TabPanel extends JPanel
{

    GUIPallet pallet = new GUIPallet();
    Border emptyBorder = BorderFactory.createEmptyBorder();
    JLabel[] label = new JLabel[80];
    LabelHandler labelHandler = new LabelHandler();
    int index;

    public TabPanel(int j)
    {
        index = j;
        setLayout(new GridLayout(40, 1));
        for (int i = 0; i < 40; i++)
        {
            label[i] = new JLabel();
            label[i].setText("    " + i);
            add(label[i]);
            label[i].setFont(new Font("Arial", Font.PLAIN, 12));
            setText(i, labelHandler.getDefaultText(index, i));
        }
        this.setBackground(pallet.getPanel());
        this.setBorder(emptyBorder);
    }

    public void setText(int i, String s)
    {
        label[i].setText("    " + s);
    }

}
