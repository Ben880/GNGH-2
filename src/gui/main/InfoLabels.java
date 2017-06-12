package gui.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import util.GUIPallet;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class InfoLabels extends JPanel
{

    LabelHandler lableHandle;
    //info main components
    JLabel infoLabel = new JLabel("Actions");
    JPanel rightCol = new JPanel();
    ///debug panel components
    JPanel debugInfo = new JPanel();
    JLabel buttonInfo = new JLabel();
    JLabel isOwned = new JLabel();
    //palet
    GUIPallet pallet = new GUIPallet();
    Dimension sideD = new Dimension(400, 15);
    Dimension debugInfoD = new Dimension(290, 145);
    LabelHandler label = new LabelHandler();

    InfoTabs tp;

    InfoLabels()
    {
        setLayout(new BorderLayout());
        label.init2(this);
        //main holder
        rightCol.setPreferredSize(sideD);
        rightCol.setBackground(pallet.getBackground());
        add(rightCol, BorderLayout.LINE_END);
        //main heading
        infoLabel.setFont(new Font("Arial", Font.BOLD, 20));
        rightCol.add(infoLabel);

        //debug panel (migrate to sub class)
        debugInfo.setLayout(new GridLayout(4, 1));
        debugInfo.setBackground(pallet.getPanel());
        debugInfo.setPreferredSize(debugInfoD);
        buttonInfo.setText("  Button: ? ([x][y])");
        buttonInfo.setBorder(BorderFactory.createEmptyBorder());
        debugInfo.add(buttonInfo);
        isOwned.setText("  Owned: ? ");
        isOwned.setBorder(BorderFactory.createEmptyBorder());
        debugInfo.add(isOwned);
        debugInfo.setVisible(false);
        //looks and feels of tabbs
        UIManager.put("TabbedPane.selected", pallet.getPanel());
        UIManager.getDefaults().put("TabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));
        UIManager.getDefaults().put("TabbedPane.tabAreaInsets", new Insets(0, 0, 0, 0));
        UIManager.put("TabbedPane.selected", pallet.getPanel());
        UIManager.put("TabbedPane.borderHightlightColor", pallet.getPanel());
        UIManager.put("TabbedPane.hilight", pallet.getPanel());
        UIManager.put("TabbedPane.selectHighlight", pallet.getPanel());
        UIManager.put("TabbedPane.focus", pallet.getPanel());
        UIManager.put("TabbedPane.darkShadow", pallet.getBackground());
        UIManager.put("TabbedPane.light", pallet.getBackground());
        //creation of tabbed panel
        tp = new InfoTabs();
        //add stuff
        rightCol.add(tp, BorderLayout.CENTER);
        rightCol.add(debugInfo);
        rightCol.add(new DayPanel());

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
