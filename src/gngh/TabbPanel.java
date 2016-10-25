package gngh;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/*
    BenjaminWilcox
    Oct 21, 2016
    CIS 2151 O1500
    Teusday 6-10
 */
public class TabbPanel extends JPanel
{

    Color background = new Color(100, 100, 100);
    Color panel = new Color(170, 170, 170);
    Border emptyBorder = BorderFactory.createEmptyBorder();
    JLabel[] label = new JLabel[80];
    LabelHandler lableHandle;
    int index;

    public TabbPanel(int j)
    {
        index = j;
        lableHandle = LabelHandler.getInstance();
        setLayout(new GridLayout(40, 1));
        for (int i = 0; i < 40; i++)
        {
            label[i] = new JLabel();
            label[i].setText("    " + i);
            add(label[i]);
            label[i].setFont(new Font("Arial", Font.PLAIN, 12));
            setText(i, lableHandle.getDefaultText(index, i));
        }
        this.setBackground(panel);
        this.setBorder(emptyBorder);
    }

    public void setText(int i, String s)
    {
        label[i].setText("    " + s);
    }

}
