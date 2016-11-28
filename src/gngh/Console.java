package gngh;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
//feed stuff
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;

public class Console extends JPanel
{

    JTextArea feed = new JTextArea(10, 50);
    JScrollPane feedScroll = new JScrollPane();
    JScrollBar consolScroll = new JScrollBar();
    StringBuilder sb = new StringBuilder();

    Console()
    {
        setLayout(new BorderLayout());
        GUIHandler.getInstance().console().initialize(this);
        feed.setEditable(false);
        feed.setBackground(Color.black);
        feed.setForeground(Color.white);
        feed.setText("");
        feedScroll.setVerticalScrollBar(consolScroll);
        feedScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        feedScroll.setViewportView(feed);
        add(feedScroll, BorderLayout.CENTER);
    }

    public void append(String string)
    {
        sb.insert(0, ">" + string + "\n");
        feed.setText(sb.toString());
        feed.setCaretPosition(0);
    }
}
