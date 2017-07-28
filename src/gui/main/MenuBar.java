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
        //action listener
        menuOpen.addActionListener(new Menu());
        menuSave.addActionListener(new Menu());
        menuReset.addActionListener(new Menu());
        menuExit.addActionListener(new Menu());
        menuDebug.addActionListener(new Menu());
        menuOpen.setActionCommand("Open");
        menuSave.setActionCommand("Save");
        menuReset.setActionCommand("Reset");
        menuExit.setActionCommand("Exit");
        //adding things to things
        fileMenu.add(menuOpen);
        fileMenu.add(menuSave);
        add(fileMenu);
        //top.add(fileBar);
        optionsMenu.add(menuReset);
        optionsMenu.add(menuExit);
        optionsMenu.add(menuDebug);
        add(optionsMenu);
        //Finishing things off
        //this.setJMenuBar(menuBar);
    }

    class Menu implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent event)
        {
            //gets and preforms proper action
            if (event.getActionCommand() == "Exit")
                System.exit(0);
            if (event.getSource() == menuDebug)
            {
                debug.toggleDebug();
                gui.update();
            }
        }
    }
}
