package gngh;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class InfoLabels extends JPanel
{

    LabelHandler lableHandle;
    //info labels
    JLabel infoLabel = new JLabel("Info");
    JPanel rightCol = new JPanel();
    JPanel rightInner = new JPanel();
    JLabel[] infoLabels = new JLabel[80];
    ///debug
    JPanel debugInfo = new JPanel();
    JLabel buttonInfo = new JLabel();
    JLabel isOwned = new JLabel();
    //palet
    Color background = new Color(100, 100, 100);
    Color panel = new Color(170, 170, 170);
    Dimension sideD = new Dimension(300, 15);
    Dimension rightSideD = new Dimension(290, 610);
    Dimension debugInfoD = new Dimension(290, 150);
    Dimension debugD = new Dimension(290, 180);

    InfoLabels()
    {
        setLayout(new BorderLayout());
        //main holder
        rightCol.setPreferredSize(sideD);
        rightCol.setBackground(background);
        add(rightCol, BorderLayout.LINE_END);
        //main heading
        infoLabel.setFont(new Font("Arial", Font.BOLD, 20));
        rightCol.add(infoLabel);
        //sub holder
        rightInner.setPreferredSize(rightSideD);
        rightInner.setBackground(panel);
        rightInner.setLayout(new GridLayout(40, 2));
        rightCol.add(rightInner);
        //lables
        int i = 1;
        lableHandle = LabelHandler.getInstance();
        while (i < 40)
        {
            infoLabels[i] = new JLabel();
            infoLabels[i].setFont(new Font("Arial", Font.PLAIN, 12));
            infoLabels[i].setText("  " + i);
            rightInner.add(infoLabels[i]);
            infoLabels[i].setText(lableHandle.getDefaultText(i));
            i++;
        }
        //debug
        debugInfo.setLayout(new GridLayout(4, 1));
        debugInfo.setBackground(panel);
        debugInfo.setPreferredSize(debugInfoD);
        rightCol.add(debugInfo);
        buttonInfo.setText("  Button: ? ([x][y])");
        buttonInfo.setBorder(BorderFactory.createEmptyBorder());
        debugInfo.add(buttonInfo);
        isOwned.setText("  Owned: ? ");
        isOwned.setBorder(BorderFactory.createEmptyBorder());
        debugInfo.add(isOwned);
        debugInfo.setVisible(false);
        //add main holder to panel
        add(rightCol, BorderLayout.CENTER);
    }

    public void setText(int i, String s)
    {
        infoLabels[i].setText("  " + s);
    }

    public void toggleDebug(boolean b)
    {
        //System.out.println("Toggle debug action recived: " + b);
        debugInfo.setVisible(b);
    }

}
