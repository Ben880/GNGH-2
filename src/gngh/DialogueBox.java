package gngh;

import javax.swing.JOptionPane;

/*
    BenjaminWilcox
    Oct 6, 2016
    CIS 2151 O1500
    Teusday 6-10
 */
public class DialogueBox
{

    GUIHandler gui;

    public DialogueBox()
    {
        gui = GUIHandler.getInstance();
    }

    public int troops()
    {
        String s = JOptionPane.showInputDialog(gui.frame().getFrame(), "How many troops do you want to send", "Attack", -1);
        int troops = Integer.parseInt(s);
        return troops;
    }

}
