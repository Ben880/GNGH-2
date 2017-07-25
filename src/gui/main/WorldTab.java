package gui.main;

import gui.BackEnd.SelectedTile;
import gui.BackEnd.WorldHandler;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import util.GUIPallet;
import util.Location;
import util.debug.DebugInfo;
import world.CellHolder;

/*
    BenjaminWilcox
    Jun 10, 2017
    GNGH_2
 */
public class WorldTab extends JPanel
{

    WorldHandler handler = new WorldHandler();
    DebugInfo debug = new DebugInfo();
    //main components
    //panels in order
    JPanel infoHolder = new JPanel();
    JPanel bannerHolder = new JPanel();
    JPanel infoHeaderHolder = new JPanel();
    JPanel labelHolder = new JPanel();
    JPanel actionHolder = new JPanel();
    JPanel actionHeaderHolder = new JPanel();
    JPanel buttonHolder = new JPanel();
    //assorted labels
    JLabel infoHeader = new JLabel("Info");
    JLabel actionHeader = new JLabel("Actions");
    JLabel bannerLabel = new JLabel();
    //info labels
    JLabel biome = new JLabel();
    JLabel enemyName = new JLabel();
    JLabel enemyCount = new JLabel();
    JLabel fertility = new JLabel();
    JLabel forestry = new JLabel();
    JLabel mining = new JLabel();
    JLabel location = new JLabel();
    //action buttons
    JButton attack = new JButton("attack");
    JButton scout = new JButton("scout");
    JButton forage = new JButton("forage");
    JButton hold = new JButton("hold position");
    JButton withdrawl = new JButton("withdrawl");
    JButton base = new JButton("build base");
    JButton abandon = new JButton("abandon");
    JButton outpost = new JButton("outpost");
    JButton btn = new JButton("btn");
    JButton btn1 = new JButton("btn1");
    JButton btn2 = new JButton("btn2");
    JButton btn3 = new JButton("btn3");

    //pallet
    GUIPallet pallet = new GUIPallet();

    SelectedTile selected = new SelectedTile();
    CellHolder cells = new CellHolder();

    public WorldTab()
    {
        new UpdateGUI().passTab(this);
        setLayout(new BorderLayout());
        //backgrounds
        this.setBackground(pallet.getPanel());
        infoHeaderHolder.setBackground(pallet.getPanel());
        labelHolder.setBackground(pallet.getPanel());
        bannerHolder.setBackground(pallet.getPanel());
        infoHolder.setBackground(pallet.getPanel());
        actionHolder.setBackground(pallet.getPanel());
        actionHeaderHolder.setBackground(pallet.getPanel());
        buttonHolder.setBackground(pallet.getPanel());
        //other layout things
        actionHolder.setLayout(new BorderLayout());
        bannerHolder.setPreferredSize(new Dimension(390, 120));
        labelHolder.setLayout(new GridLayout(15, 1));
        infoHeader.setFont(new Font("Arial", Font.BOLD, 16));
        actionHeader.setFont(new Font("Arial", Font.BOLD, 16));
        buttonHolder.setLayout(new GridLayout(5, 3));
        infoHolder.setLayout(new BorderLayout());

        //button action listener
        attack.addActionListener(new ActionPress());
        scout.addActionListener(new ActionPress());
        forage.addActionListener(new ActionPress());

        //tring some shit
        try
        {
            Image image = ImageIO.read(new File(System.getProperty("user.dir") + "\\content\\banners\\forest.jpg"));
            Image resize = image.getScaledInstance(390, 120, 1);
            bannerLabel = new JLabel(new ImageIcon(resize));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        //adding in order
        add(infoHolder, BorderLayout.NORTH);
        add(actionHolder, BorderLayout.CENTER);
        //infoHolder in order
        infoHolder.add(bannerHolder, BorderLayout.NORTH);
        infoHolder.add(infoHeaderHolder, BorderLayout.CENTER);
        infoHolder.add(labelHolder, BorderLayout.SOUTH);
        //infoHolder banner
        bannerHolder.add(bannerLabel);
        //infoHolder header
        infoHeaderHolder.add(infoHeader);
        //infoHolder lables
        labelHolder.add(location);
        labelHolder.add(biome);
        labelHolder.add(fertility);
        labelHolder.add(forestry);
        labelHolder.add(mining);
        labelHolder.add(enemyName);
        labelHolder.add(enemyCount);
        //actionHolder in order
        actionHolder.add(actionHeaderHolder, BorderLayout.NORTH);
        actionHolder.add(buttonHolder, BorderLayout.CENTER);
        //action header
        actionHeaderHolder.add(actionHeader);
        //buttons
        buttonHolder.add(attack);
        buttonHolder.add(scout);
        buttonHolder.add(forage);
        buttonHolder.add(hold);
        buttonHolder.add(withdrawl);
        buttonHolder.add(base);
        buttonHolder.add(abandon);
        buttonHolder.add(outpost);
        buttonHolder.add(btn);
        buttonHolder.add(btn1);
        buttonHolder.add(btn2);
        buttonHolder.add(btn3);

    }

    public void update()
    {
        Location tempLocation = selected.getSelected();
        //allways update
        location.setText("Location: (" + tempLocation.getX() + ", " + tempLocation.getY() + ")");
        //conditional updates
        if (cells.getCell(tempLocation).visible().isStatsVisible() || debug.getDebug())
        {
            //update all
            updateBanner(cells.getCell(selected.getSelected()).biome().getName());
            biome.setText("Biome: " + cells.getCell(selected.getSelected()).biome().getName());
            fertility.setText("Fertility: " + cells.getCell(tempLocation).resources().getFertility());
            forestry.setText("Trees: " + cells.getCell(tempLocation).resources().getLumber());
            mining.setText("Ores: " + cells.getCell(tempLocation).resources().getMining());
            enemyName.setText("Enemy type: " + cells.getCell(tempLocation).enemy().getName());
            enemyCount.setText("Enemy count: " + cells.getCell(tempLocation).enemy().getCount());
        } else
        {
            fertility.setText("Fertility: ??");
            forestry.setText("Trees: ??");
            mining.setText("Ores: ??");
            enemyName.setText("Enemy type: ??");
            enemyCount.setText("Enemy count: ??");
        }
        //update biome
        if (cells.getCell(tempLocation).visible().isBiomeVisible() || debug.getDebug())
        {
            biome.setText("Biome: " + cells.getCell(selected.getSelected()).biome().getName());
            updateBanner(cells.getCell(selected.getSelected()).biome().getName());

        } else
        {
            biome.setText("Biome: ??");
        }
        updateBanner(cells.getCell(selected.getSelected()).biome().getName());

    }

    private void updateBanner(String s)
    {
        try
        {
            Image image = ImageIO.read(new File(System.getProperty("user.dir") + "\\content\\banners\\forest.jpg"));
            Image resize = image.getScaledInstance(390, 120, 1);
            bannerLabel = new JLabel(new ImageIcon(resize));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    class ActionPress implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent event)
        {
            JButton btn = (JButton) event.getSource();
            handler.buttonClick(btn.getText());
        }
    }

}
