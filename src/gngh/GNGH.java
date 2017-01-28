package gngh;

import javax.swing.*;
import research.AvalibleClass;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class GNGH
{

    public static void main(String[] args)
    {
        //testing here
//        AvalibleXML avalibleX = new AvalibleXML();
//        avalibleX.summary();
        AvalibleClass avalibleC = new AvalibleClass();
        avalibleC.summary();
        //end tests
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
