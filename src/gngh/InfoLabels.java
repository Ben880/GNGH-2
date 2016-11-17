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
    //info main components
    JLabel infoLabel = new JLabel("Info");
    JPanel rightCol = new JPanel();
    ///debug panel components
    JPanel debugInfo = new JPanel();
    JLabel buttonInfo = new JLabel();
    JLabel isOwned = new JLabel();
    //palet
    Color background = new Color(100, 100, 100);
    Color panel = new Color(170, 170, 170);
    Dimension sideD = new Dimension(300, 15);
    Dimension debugInfoD = new Dimension(290, 145);
    
    InfoTabs tp;

    InfoLabels()
    {
        setLayout(new BorderLayout());
        GUIHandler.getInstance().label.init2(this);
        //main holder
        rightCol.setPreferredSize(sideD);
        rightCol.setBackground(background);
        add(rightCol, BorderLayout.LINE_END);
        //main heading
        infoLabel.setFont(new Font("Arial", Font.BOLD, 20));
        rightCol.add(infoLabel);

        //debug panel (migrate to sub class)
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
        //looks and feels of tabbs
        UIManager.put("TabbedPane.selected", panel);
        UIManager.getDefaults().put("TabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));
        UIManager.getDefaults().put("TabbedPane.tabAreaInsets", new Insets(0, 0, 0, 0));
        UIManager.put("TabbedPane.selected", panel);
        UIManager.put("TabbedPane.borderHightlightColor", panel);
        UIManager.put("TabbedPane.hilight", panel);
        UIManager.put("TabbedPane.selectHighlight", panel);
        UIManager.put("TabbedPane.focus", panel);
        UIManager.put("TabbedPane.darkShadow", background);
        UIManager.put("TabbedPane.light", background);
        //creation of tabbed panel
        tp = new InfoTabs();
        //add stuff
        rightCol.add(tp, BorderLayout.CENTER);
        rightCol.add(debugInfo);

    }

    public void setText(int l, int i, String s)
    {
        tp.setText(l, i, s);
    }

    public void toggleDebug(boolean b)
    {
        debugInfo.setVisible(b);
    }

}
