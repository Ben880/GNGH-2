package gngh;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

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
    Dimension debugInfoD = new Dimension(290, 145);

    InfoTabbs tp;

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
        //========================start old code===============================
        //sub holder
        rightInner.setPreferredSize(rightSideD);
        rightInner.setBackground(panel);
        rightInner.setLayout(new GridLayout(40, 2));
        //rightCol.add(rightInner);
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
        //===================end old code==================================
        //debug
        debugInfo.setLayout(new GridLayout(4, 1));
        debugInfo.setBackground(panel);
        debugInfo.setPreferredSize(debugInfoD);

        buttonInfo.setText("  Button: ? ([x][y])");
        buttonInfo.setBorder(BorderFactory.createEmptyBorder());
        debugInfo.add(buttonInfo);
        isOwned.setText("  Owned: ? ");
        isOwned.setBorder(BorderFactory.createEmptyBorder());
        debugInfo.add(isOwned);
        debugInfo.setVisible(false);
        //formatting some stuff
        UIManager.put("TabbedPane.selected", panel);
        UIManager.getDefaults().put("TabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));
        UIManager.getDefaults().put("TabbedPane.tabAreaInsets", new Insets(0, 0, 0, 0));
        //UIManager.getDefaults().put("TabbedPane.tabInsets", new Insets(0, 0, 0, 0));
        UIManager.put("TabbedPane.selected", panel);
        UIManager.put("TabbedPane.borderHightlightColor", panel);
        UIManager.put("TabbedPane.hilight", panel);
        UIManager.put("TabbedPane.selectHighlight", panel);
        UIManager.put("TabbedPane.focus", panel);
        UIManager.put("TabbedPane.darkShadow", background);
        UIManager.put("TabbedPane.light", background);
        tp = new InfoTabbs();
        tp.setPreferredSize(new Dimension(290, 595));
        //add stuff
        rightCol.add(tp, BorderLayout.CENTER);
        rightCol.add(debugInfo);

    }

    //=====================old code =======================
    public void setText(int i, String s)
    {
        infoLabels[i].setText("  " + s);
    }

    public void setText(int l, int i, String s)
    {
        tp.setText(l, i, s);
    }

    public void toggleDebug(boolean b)
    {
        //System.out.println("Toggle debug action recived: " + b);
        debugInfo.setVisible(b);
    }

}
