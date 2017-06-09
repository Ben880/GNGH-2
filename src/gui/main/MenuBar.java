package gui.main;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/*
    BenjaminWilcox
    Oct 19, 2016
    CIS 2151 O1500
    Teusday 6-10
 */
public class MenuBar extends JMenuBar
{

    JMenu fileMenu = new JMenu("File");
    JMenuItem menuOpen = new JMenuItem("Open", KeyEvent.VK_O);
    JMenuItem menuSave = new JMenuItem("Save", KeyEvent.VK_S);
    JMenu optionsMenu = new JMenu("Options");
    JMenuItem menuReset = new JMenuItem("Reset", KeyEvent.VK_R);
    JMenuItem menuExit = new JMenuItem("Exit", KeyEvent.VK_E);

    public MenuBar()
    {
        //formating things
        menuOpen.setPreferredSize(new Dimension(200, 30));
        menuSave.setPreferredSize(new Dimension(200, 30));
        menuReset.setPreferredSize(new Dimension(200, 30));
        menuExit.setPreferredSize(new Dimension(200, 30));
        //keybord shortcuts
        fileMenu.setMnemonic(KeyEvent.VK_1);
        optionsMenu.setMnemonic(KeyEvent.VK_2);
        menuOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        menuSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        menuReset.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        menuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        //action listener
        menuOpen.addActionListener(new Menu());
        menuSave.addActionListener(new Menu());
        menuReset.addActionListener(new Menu());
        menuExit.addActionListener(new Menu());
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
//            if (event.getActionCommand() == "Save")
//            if (event.getActionCommand() == "Open")
//            if (event.getActionCommand() == "Reset")
        }
    }
}
