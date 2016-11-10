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
        MainFrame frame;
        frame = MainFrame.getInstance("GNGH");
        frame.setSize(1410, 1005);
        frame.setLocation(250, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        initialize(frame);
    }

    private static void initialize(MainFrame frame)
    {
        Info info = Info.getInstance();
        Tracker tracker = Tracker.getInstance();
    }
}
