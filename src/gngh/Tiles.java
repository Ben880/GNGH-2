package gngh;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class Tiles extends JPanel
{

    //borders for hover effect
    Border emptyBorder = BorderFactory.createEmptyBorder();
    Border lineBorder = BorderFactory.createLineBorder(new Color(100, 100, 100), 1);
    //the buttons themselves
    ActionHandler action;
    JButton[][] btn = new JButton[20][20];
    //holder for the buttons
    JPanel main = new JPanel();
    JPanel mainHolder = new JPanel();
    Color background = new Color(100, 100, 100);

    public Tiles()
    {
        action = ActionHandler.getInstance();
        GUIHandler.getInstance().tile().initialize(this);
        //builds tiles
        setLayout(new BorderLayout());
        main.setLayout(new GridLayout(20, 20));
        main.setBackground(background);
        main.setSize(1000, 1000);
        mainHolder.add(main);
        mainHolder.setBackground(background);
        add(mainHolder, BorderLayout.CENTER);
        int i = 0;
        int x = 0;
        int y = 0;
        while (i < 400)
        {
            if (x == 20)
            {
                x = 0;
                y++;
            }
            btn[x][y] = new JButton();
            btn[x][y].setName(Integer.toString(i));
            btn[x][y].setPreferredSize(new Dimension(40, 40));
            btn[x][y].setBorder(emptyBorder);
            btn[x][y].addMouseListener(new Tiles.hover());
            btn[x][y].setSize(new Dimension(10, 10));
            main.add(btn[x][y]);
            btn[x][y].addActionListener(new Tiles.Press());
            btn[x][y].setActionCommand(Integer.toString(i));
            btn[x][y].setText("?");
            i++;
            x++;
        } //end while
        add(main, BorderLayout.CENTER);
    }

    public void setColor(int x, int y, Color c)
    {
        btn[x][y].setBackground(c);
    }

    public void setText(int x, int y, String s)
    {
        btn[x][y].setText(s);
    }

    class Press implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent event)
        {
            int i = Integer.parseInt(event.getActionCommand());
            int y = i / 20;
            int x = i % 20;
            //display attack options here
            action.button().gameClick(x, y);

        }
    } //end press class

    class hover implements MouseListener
    {

        @Override
        public void mouseEntered(MouseEvent e)
        {
            JButton btn = (JButton) e.getSource();
            btn.setBorder(lineBorder);
        }

        @Override
        public void mouseExited(MouseEvent e)
        {
            JButton btn = (JButton) e.getSource();
            btn.setBorder(emptyBorder);
        }

        @Override
        public void mouseClicked(MouseEvent e)
        {
        }

        @Override
        public void mousePressed(MouseEvent e)
        {
        }

        @Override
        public void mouseReleased(MouseEvent e)
        {
        }

    }
}
