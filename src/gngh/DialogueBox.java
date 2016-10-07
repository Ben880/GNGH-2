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

    MyFrame frame;

    public DialogueBox()
    {

    }

    public int troops()
    {
        frame = MyFrame.getInstance("GNGH");
        String s = JOptionPane.showInputDialog(frame, "How many troops do you want to send", "Attack", -1);
        int troops = Integer.parseInt(s);
        return troops;
    }

}
