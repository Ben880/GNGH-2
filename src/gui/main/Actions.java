package gui.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import util.GUIPallet;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class Actions extends JPanel
{

    //main components
    private JLabel heading = new JLabel("Actions");
    private JPanel holder = new JPanel();
    private JPanel bottomHolder = new JPanel();
    //palet
    private GUIPallet pallet = new GUIPallet();
    private Dimension sideD = new Dimension(400, 15);
    //sub classes
    private TabHolder tabHolder;
    private DayPanel dayP = new DayPanel();
    private DayProgress progress = new DayProgress();

    Actions()
    {
        setLayout(new BorderLayout());
        //main holder
        holder.setPreferredSize(sideD);
        holder.setBackground(pallet.getBackground());
        //heading
        heading.setFont(new Font("Arial", Font.BOLD, 20));
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
        tabHolder = new TabHolder();
        //bottom setup
        bottomHolder.setLayout(new GridLayout(1, 2));
        bottomHolder.setBackground(pallet.getBackground());
        //add stuff
        add(holder, BorderLayout.LINE_END);
        holder.add(heading);
        holder.add(tabHolder, BorderLayout.CENTER);
        holder.add(bottomHolder);
        bottomHolder.add(dayP);
        holder.add(progress);
    }

}
