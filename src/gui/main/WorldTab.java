package gui.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import util.GUIPallet;

/*
    BenjaminWilcox
    Jun 10, 2017
    GNGH_2
 */
public class WorldTab extends JPanel
{

    //main components
    JPanel infoHolder = new JPanel();
    JPanel infoHeaderHolder = new JPanel();
    JPanel bannerHolder = new JPanel();
    JLabel bannerLabel = new JLabel();
    JPanel actionHolder = new JPanel();

    JLabel infoHeader = new JLabel("Info");
    JLabel actionHeader = new JLabel("Actions");

    //pallet
    GUIPallet pallet = new GUIPallet();

    public WorldTab()
    {
        new UpdateGUI().passTab(this);
        setLayout(new BorderLayout());
        setBackground(pallet.getPanel());
        //configuring components
        infoHeaderHolder.setBackground(pallet.getPanel());
        bannerHolder.setBackground(pallet.getPanel());
        bannerHolder.setPreferredSize(new Dimension(390, 120));
        infoHolder.setBackground(pallet.getPanel());
        infoHeader.setFont(new Font("Arial", Font.BOLD, 16));
        infoHolder.setLayout(new BorderLayout());
        //tring some shit
        try
        {
            BufferedImage img = ImageIO.read(new File("C:\\Users\\bmwla\\Desktop\\forest.jpg"));
            Image image = ImageIO.read(new File("C:\\Users\\bmwla\\Desktop\\forest.jpg"));
            Image resize = image.getScaledInstance(390, 120, 1);
            bannerLabel = new JLabel(new ImageIcon(resize));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        //adding in order
        infoHeaderHolder.add(infoHeader);
        infoHolder.add(bannerHolder, BorderLayout.NORTH);
        bannerHolder.add(bannerLabel);
        infoHolder.add(infoHeaderHolder, BorderLayout.CENTER);
        add(infoHolder, BorderLayout.NORTH);
    }

    void update()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
