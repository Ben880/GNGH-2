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
import util.GUIPallet;

/*
    BenjaminWilcox
    Jun 11, 2017
    GNGH_2
 */
public class JobBox extends JPanel
{

    private String jobName;
    private int numberWorkers;
    private JLabel nameLabel = new JLabel();
    private JLabel statsLabel = new JLabel();
    private JPanel imageHolder = new JPanel();
    private JPanel textHolder = new JPanel();
    private Image image;
    GUIPallet pallet = new GUIPallet();

    public JobBox(String name, int number)
    {
        setLayout(new BorderLayout());
        setBackground(pallet.getPanel());
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
        setPreferredSize(new Dimension(190, 50));
        imageHolder.setBackground(pallet.getPanel());
        textHolder.setBackground(pallet.getPanel());
        jobName = name;
        numberWorkers = number;
        nameLabel.setText(jobName + ": " + numberWorkers);
        textHolder.setLayout(new GridLayout(2, 1));
        JLabel imageLabel = new JLabel();
        try
        {
            BufferedImage img = ImageIO.read(new File("C:\\Users\\bmwla\\Desktop\\axe.png"));
            Image image = ImageIO.read(new File("C:\\Users\\bmwla\\Desktop\\axe.png"));
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

    public void setName(String s)
    {
        jobName = s;
        nameLabel.setText(jobName + ": " + numberWorkers);
    }

    public void addNumber(int i)
    {
        numberWorkers = numberWorkers = i;
        nameLabel.setText(jobName + ": " + numberWorkers);

    }

    public void updateStats(String s)
    {
        statsLabel.setText(s);
    }

    public void updateNumber()
    {

    }

}
