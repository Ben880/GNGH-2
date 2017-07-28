package gngh;

import gui.main.MainFrame;
import gui.main.UpdateGUI;
import javax.swing.*;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class GNGH
{

    public static void main(String[] args)
    {
        //class to execute test files
        new Test().testClasses();
        //constructing main frame
        MainFrame frame = new MainFrame("GNGH");
        frame.setSize(1200, 1028);
        frame.setLocation(250, 2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        new UpdateGUI().update();
    }
}
