package gui.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import player.resources.ResourceHolder;
import util.GUIPallet;

/*
    BenjaminWilcox
    Jun 21, 2017
    GNGH_2
 */
public class ResourceBox extends JPanel
{

    JPanel imageHolder = new JPanel();
    JLabel imageLabel = new JLabel();
    JPanel infoHolder = new JPanel();
    JLabel info = new JLabel();
    JLabel nameLabel = new JLabel();
    GUIPallet pallet = new GUIPallet();

    ResourceHolder resources = new ResourceHolder();

    public ResourceBox()
    {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
        imageHolder.setBackground(pallet.getPanel());
        infoHolder.setBackground(pallet.getPanel());
        infoHolder.setLayout(new GridLayout(2, 1));
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        info.setText("Count: ?");
        setImage("");
        //adding in order?
        add(imageHolder, BorderLayout.WEST);
        add(infoHolder, BorderLayout.CENTER);
        imageHolder.add(imageLabel);
        infoHolder.add(nameLabel);
        infoHolder.add(info);
    }

    public void update(int i)
    {
        if (resources.getNumber(i) != null)
        {
            setImage(resources.getNumber(i).getName());
            nameLabel.setText(resources.getNumber(i).getName());
            info.setText("Count: " + resources.getNumber(i).get());
            setVisible(true);
        } else
        {
            setVisible(false);
        }
        validate();
    }

    public void setImage(String s)
    {
        try
        {
            BufferedImage img = ImageIO.read(new File(System.getProperty("user.dir") + "\\content\\icons\\resource\\axe.png"));
            Image image = ImageIO.read(new File(System.getProperty("user.dir") + "\\content\\icons\\resource\\axe.png"));
            Image resize = image.getScaledInstance(40, 40, 1);
            imageLabel = new JLabel(new ImageIcon(resize));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
