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
import player.resources.ResourceProduction;
import util.GUIPallet;

/*
    BenjaminWilcox
    Jun 21, 2017
    GNGH_2
 */
public class ResourceBox extends JPanel
{

    private JPanel imageHolder = new JPanel();
    private JLabel imageLabel = new JLabel();
    private JPanel infoHolder = new JPanel();
    private JLabel info = new JLabel();
    private JLabel nameLabel = new JLabel();
    private JPanel productionHolder = new JPanel();
    private JLabel productionLabel = new JLabel();
    private GUIPallet pallet = new GUIPallet();

    ResourceHolder resources = new ResourceHolder();
    ResourceProduction production = new ResourceProduction();

    public ResourceBox()
    {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
        imageHolder.setBackground(pallet.getPanel());
        infoHolder.setBackground(pallet.getPanel());
        productionHolder.setBackground(pallet.getPanel());
        productionHolder.setLayout(new GridLayout(3, 1));
        infoHolder.setLayout(new GridLayout(2, 1));
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        productionLabel.setForeground(Color.GREEN);
        setImage("");
        //adding in order?
        add(imageHolder, BorderLayout.WEST);
        add(infoHolder, BorderLayout.CENTER);
        imageHolder.add(imageLabel);
        infoHolder.add(nameLabel);
        infoHolder.add(info);
        add(productionHolder, BorderLayout.EAST);
        productionHolder.add(productionLabel);
    }

    public void update(int i)
    {
        if (resources.getNumber(i) != null)
        {
            setImage(resources.getNumber(i).getName());
            nameLabel.setText(resources.getNumber(i).getName());
            info.setText("Count: " + resources.getNumber(i).get());
            productionLabel.setText("+ " + production.pollProduction(resources.getNumber(i)) + " ");
            if (production.pollProduction(resources.getNumber(i)) < 0)
            {
                productionLabel.setForeground(Color.RED);
                productionLabel.setText(production.pollProduction(resources.getNumber(i)) + " ");
            } else if (production.pollProduction(resources.getNumber(i)) >= 0)
            {
                productionLabel.setForeground(Color.GREEN);
                productionLabel.setText("+ " + production.pollProduction(resources.getNumber(i)) + " ");
            }

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
