package gui.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import player.citizens.CitizenHolder;
import util.GUIPallet;

/*
    BenjaminWilcox
    Jun 11, 2017
    GNGH_2
 */
public class JobBox extends JPanel
{

    private String jobName;
    private JLabel nameLabel = new JLabel();
    private JLabel statsLabel = new JLabel();
    private JPanel imageHolder = new JPanel();
    private JPanel textHolder = new JPanel();
    JLabel imageLabel = new JLabel();
    private Image image;
    GUIPallet pallet = new GUIPallet();
    private CitizenHolder citizens = new CitizenHolder();

    public JobBox()
    {
        setLayout(new BorderLayout());
        setBackground(pallet.getPanel());
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
        setPreferredSize(new Dimension(190, 50));
        imageHolder.setBackground(pallet.getPanel());
        textHolder.setBackground(pallet.getPanel());
        textHolder.setLayout(new GridLayout(2, 1));

        try
        {
            BufferedImage img = ImageIO.read(new File(System.getProperty("user.dir") + "\\content\\icons\\job\\axe.png"));
            Image image = ImageIO.read(new File(System.getProperty("user.dir") + "\\content\\icons\\job\\axe.png"));
            Image resize = image.getScaledInstance(40, 40, 1);
            imageLabel = new JLabel(new ImageIcon(resize));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        //adding image
        imageHolder.add(imageLabel);
        //ading to textHolder
        textHolder.add(nameLabel);
        textHolder.add(statsLabel);
        //adding to JPanel
        add(imageHolder, BorderLayout.WEST);
        add(textHolder, BorderLayout.CENTER);

    }

    public void update(int i)
    {
        if (citizens.getNumber(i) != null)
        {
            setImage(citizens.getNumber(i).getType());
            nameLabel.setText(citizens.getNumber(i).getType());
            statsLabel.setText("Count: " + citizens.getNumber(i).getCount());
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
