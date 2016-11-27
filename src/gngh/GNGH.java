package gngh;

import javax.swing.*;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class GNGH
{

    public static void main(String[] args)
    {
        MainFrame frame = new MainFrame("GNGH");
        frame.setSize(1410, 1005);
        frame.setLocation(250, 15);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        //frame.getRootPane().setVisible(true);
        //frame.getRootPane().validate();
    }
}
