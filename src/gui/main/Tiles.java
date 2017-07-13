package gui.main;

import gui.BackEnd.SelectedTile;
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
import util.GUIPallet;
import util.Location;
import world.render.RenderFog;
import world.render.RenderTile;

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
    JButton[][] btn = new JButton[20][20];
    //holder for the buttons
    JPanel main = new JPanel();
//    JPanel mainHolder = new JPanel();
    GUIPallet pallet = new GUIPallet();

    //back end
    SelectedTile selected = new SelectedTile();
    UpdateGUI updater = new UpdateGUI();

    public Tiles()
    {
        RenderTile tile = new RenderTile();
        tile.initialize(this);
        RenderFog fog = new RenderFog();
        fog.initialize(this);

        //builds tiles
        main.setLayout(new GridLayout(20, 20));
        main.setBackground(pallet.getBackground());
        main.setPreferredSize(new Dimension(800, 800));
//        mainHolder.add(main);
//        mainHolder.setPreferredSize(new Dimension(800, 800));
        setBackground(pallet.getBackground());
        //add(mainHolder);
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
        add(main);
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
            btn[selected.getSelected().getX()][selected.getSelected().getY()].setBorder(emptyBorder);
            int i = Integer.parseInt(event.getActionCommand());
            int y = i / 20;
            int x = i % 20;
            //display attack options here
            selected.setSelected(new Location(x, y));
            updater.update();
            btn[x][y].setBorder(lineBorder);

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
            JButton button = (JButton) e.getSource();
            button.setBorder(emptyBorder);
            btn[selected.getSelected().getX()][selected.getSelected().getY()].setBorder(lineBorder);
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
