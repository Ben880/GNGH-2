package gui.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import player.citizens.CitizenHolder;
import util.GUIPallet;
import util.debug.DebugInfo;

/*
    BenjaminWilcox
    Jun 11, 2017
    GNGH_2
 */
public class JobBox extends JPanel
{

    private JLabel nameLabel = new JLabel();
    private JLabel statsLabel = new JLabel();
    private JPanel imageHolder = new JPanel();
    private JPanel textHolder = new JPanel();
    private JLabel imageLabel = new JLabel();
    private GUIPallet pallet = new GUIPallet();
    private CitizenHolder citizens = new CitizenHolder();
    private int number;
    private String name;

    public JobBox(int number)
    {
        load(number);
        setLayout(new BorderLayout());
        setBackground(pallet.getPanel());
        setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
        setPreferredSize(new Dimension(190, 50));
        imageHolder.setBackground(pallet.getPanel());
        textHolder.setBackground(pallet.getPanel());
        textHolder.setLayout(new GridLayout(2, 1));
        //adding image
        imageHolder.add(imageLabel);
        //ading to textHolder
        textHolder.add(nameLabel);
        textHolder.add(statsLabel);
        //adding to JPanel
        add(imageHolder, BorderLayout.WEST);
        add(textHolder, BorderLayout.CENTER);

    }

    private void load(int number)
    {
        this.number = number;
        if (citizens.getNumber(number) != null)
            name = citizens.getNumber(number).getType();
        setImage();

    }

    public void update()
    {
        if (citizens.getNumber(number) != null)
        {
            if (new DebugInfo().getDebug())
            {
                System.out.println("Job box: " + number + " upatate count: " + citizens.getNumber(number).getCount());
            }
            nameLabel.setText(citizens.getNumber(number).getType());
            statsLabel.setText("Count: " + citizens.getNumber(number).getCount());
            setVisible(true);
        } else
        {
            setVisible(false);
        }
        validate();
    }

    public void setImage()
    {
        try
        {
            Image image = ImageIO.read(new File(System.getProperty("user.dir") + "\\content\\icons\\job\\" + "axe" + ".png"));
            Image resize = image.getScaledInstance(40, 40, 1);
            imageLabel = new JLabel(new ImageIcon(resize));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
