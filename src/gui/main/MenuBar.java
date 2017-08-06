package gui.main;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import util.debug.DebugInfo;

/*
    BenjaminWilcox
    Oct 19, 2016
    CIS 2151 O1500
    Teusday 6-10
 */
public class MenuBar extends JMenuBar
{

    Dimension def = new Dimension(200, 30);
    private JMenu fileMenu = new JMenu("File");
    private JMenuItem menuOpen = new JMenuItem("Open", KeyEvent.VK_O);
    private JMenuItem menuSave = new JMenuItem("Save", KeyEvent.VK_S);
    private JMenu optionsMenu = new JMenu("Options");
    private JMenuItem menuReset = new JMenuItem("Reset", KeyEvent.VK_R);
    private JMenuItem menuExit = new JMenuItem("Exit", KeyEvent.VK_E);
    private JMenuItem menuDebug = new JMenuItem("Debug", KeyEvent.VK_D);
    private JMenu tabsMenu = new JMenu("Tabs");
    private JMenuItem world = new JMenuItem("World", KeyEvent.VK_1);
    private JMenuItem jobs = new JMenuItem("Jobs", KeyEvent.VK_2);
    private JMenuItem resources = new JMenuItem("Resources", KeyEvent.VK_3);
    private JMenuItem research = new JMenuItem("World", KeyEvent.VK_4);
    //needed classes
    private UpdateGUI gui = new UpdateGUI();
    private DebugInfo debug = new DebugInfo();

    public MenuBar()
    {
        //formating things
        menuOpen.setPreferredSize(def);
        menuSave.setPreferredSize(def);
        menuReset.setPreferredSize(def);
        menuExit.setPreferredSize(def);
        menuDebug.setPreferredSize(def);
        //keybord shortcuts
        fileMenu.setMnemonic(KeyEvent.VK_1);
        optionsMenu.setMnemonic(KeyEvent.VK_2);
        menuOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        menuSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        menuReset.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        menuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        menuDebug.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        world.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.SHIFT_MASK));
        jobs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.SHIFT_MASK));
        resources.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.SHIFT_MASK));
        research.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.SHIFT_MASK));
        //action listener
        world.addActionListener(new Menu());
        jobs.addActionListener(new Menu());
        resources.addActionListener(new Menu());
        research.addActionListener(new Menu());
        menuOpen.addActionListener(new Menu());
        menuSave.addActionListener(new Menu());
        menuReset.addActionListener(new Menu());
        menuExit.addActionListener(new Menu());
        menuDebug.addActionListener(new Menu());
        //adding file menu
        fileMenu.add(menuOpen);
        fileMenu.add(menuSave);
        add(fileMenu);
        //adding options menu
        optionsMenu.add(menuReset);
        optionsMenu.add(menuExit);
        optionsMenu.add(menuDebug);
        add(optionsMenu);
        //adding tab menu
        tabsMenu.add(world);
        tabsMenu.add(jobs);
        tabsMenu.add(resources);
        tabsMenu.add(research);
        add(tabsMenu);
    }

    class Menu implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent event)
        {
            //gets and preforms proper action
            if (event.getSource() == menuExit)
                System.exit(0);
            if (event.getSource() == menuDebug)
            {
                debug.toggleDebug();
                gui.update();
            }
            if (event.getSource() == world)
            {
                gui.setSelected(0);
            }
            if (event.getSource() == jobs)
            {
                gui.setSelected(1);
            }
            if (event.getSource() == resources)
            {
                gui.setSelected(2);
            }
            if (event.getSource() == research)
            {
                gui.setSelected(3);
            }
        }
    }
}
