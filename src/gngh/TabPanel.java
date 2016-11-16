package gngh;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class TabPanel extends JPanel
{

    Color background = new Color(100, 100, 100);
    Color panel = new Color(170, 170, 170);
    Border emptyBorder = BorderFactory.createEmptyBorder();
    JLabel[] label = new JLabel[80];
    GUIHandler gui;
    int index;

    public TabPanel(int j)
    {
        index = j;
        gui = GUIHandler.getInstance();
        setLayout(new GridLayout(40, 1));
        for (int i = 0; i < 40; i++)
        {
            label[i] = new JLabel();
            label[i].setText("    " + i);
            add(label[i]);
            label[i].setFont(new Font("Arial", Font.PLAIN, 12));
            setText(i, gui.label().getDefaultText(index, i));
        }
        this.setBackground(panel);
        this.setBorder(emptyBorder);
    }

    public void setText(int i, String s)
    {
        label[i].setText("    " + s);
    }

}
