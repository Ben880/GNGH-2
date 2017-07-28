package gui.main;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
//feed stuff
import gui.BackEnd.ConsoleHandler;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

public class Console extends JPanel
{

    private JTextArea feed = new JTextArea(10, 50);
    private JScrollPane feedScroll = new JScrollPane();
    private JScrollBar consolScroll = new JScrollBar();
    private StringBuilder sb = new StringBuilder();
    private DayTracker day = new DayTracker();

    //builds console
    Console()
    {
        setLayout(new BorderLayout());
        new ConsoleHandler().initialize(this);
        feed.setEditable(false);
        feed.setBackground(Color.black);
        feed.setForeground(Color.white);
        feed.setText("");
        feedScroll.setVerticalScrollBar(consolScroll);
        feedScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        feedScroll.setViewportView(feed);
        add(feedScroll, BorderLayout.CENTER);
    }

    //appends string to console preceded by day
    public void append(String string)
    {

        sb.insert(0, "  " + day.getDay() + " > " + string + "\n");
        feed.setText(sb.toString());
        feed.setCaretPosition(0);
    }
}
