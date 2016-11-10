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

    Handler handler;

    public DialogueBox()
    {
        handler = Handler.getInstance();
    }

    public int troops()
    {
        String s = JOptionPane.showInputDialog(handler.gui().frame().getFrame(), "How many troops do you want to send", "Attack", -1);
        int troops = Integer.parseInt(s);
        return troops;
    }

}
