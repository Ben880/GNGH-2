package gngh;

import java.awt.*;
import javax.swing.*;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class GNGH
{

    public static void main(String[] args)
    {
        MyFrame frame;
        frame = MyFrame.getInstance("GNGH");
        frame.setSize(1410, 1005);
        frame.setLocation(250, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}

class MyFrame extends JFrame
{

    //importing sub panels
    Tiles tile = new Tiles();
    Console console = new Console();
    ActionButtons action = new ActionButtons();
    InfoLabels infoLabel = new InfoLabels();
    //Game variables
    public static int currX = 19;
    public static int currY = 19;
    boolean debug = false;
    boolean dispFog = true;
    //Classs import
    DayTracker day;
    AudioPlayer sound;
    ButtonHandler button;
    Info info;
    LabelHandler lableHandle;
    //distasteful palet here
    Color forest = new Color(0, 100, 0);
    Color desert = new Color(255, 209, 114);

    //trst
    //singleton
    private static MyFrame instance = null;

    public static MyFrame getInstance(String s)
    {
        if (instance == null)
        {
            instance = new MyFrame(s);
        }
        return instance;
    }

    private MyFrame(String s)
    {
        super(s);
        //iitialize classes
        info = Info.getInstance();
        day = DayTracker.getInstance();
        lableHandle = LabelHandler.getInstance();
        button = ButtonHandler.getInstance();
        //gui
        buildGUI();
        //Start Game Code
        create();
        draw();
        //for stats to be displayed on first click singletons need to be initialized
        sound = AudioPlayer.getInstance();
        action.setSliderDay(10);
        //sound.playStartSound();
        console("Start day 1 to preform actions");

    }

    public void buildGUI()
    {
        setLayout(new BorderLayout());
        add(infoLabel, BorderLayout.LINE_END);
        add(action, BorderLayout.LINE_START);
        add(console, BorderLayout.PAGE_END);
        add(tile, BorderLayout.CENTER);
        MenuBar menuBar = new MenuBar();
        this.setJMenuBar(menuBar);
    }

    public void console(String string)
    {
        console.append(string);
        sound.playBing();
    }

    public void create() //0
    {
        LandGeneration generate = new LandGeneration();
        generate.generate();
        generate = null;
    } //end method

    public int getBiome(int x, int y)
    {
        int bCheck = -2;
        try
        {
            bCheck = info.visible.getBiome(x, y, true);
        } catch (Exception e)
        {
        }
        return (bCheck);
    } //end method

    public void drawFog()
    {
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
            if (info.visible.getFog(x, y, info.visible.fog))
            {
                tile.setColor(x, y, Color.black);
                tile.setText(x, y, "");
            }
            i++;
            x++;
        }
    }

    public void dispBiome(int x, int y)
    {
        info.visible.setBiomeVisible(x, y, true);
        if (info.visible.getBiome(x, y, false) == 0)
        {
            tile.setText(x, y, ",.");
            tile.setColor(x, y, Color.green);
        }
        if (info.visible.getBiome(x, y, false) == 1)
        {
            tile.setText(x, y, "^");
            tile.setColor(x, y, Color.gray);
        }
        if (info.visible.getBiome(x, y, false) == 2)
        {
            tile.setText(x, y, "~");
            tile.setColor(x, y, Color.blue);
        }
        if (info.visible.getBiome(x, y, false) == 3)
        {
            tile.setText(x, y, "||");
            tile.setColor(x, y, forest);
        }
        if (info.visible.getBiome(x, y, false) == 4)
        {
            tile.setText(x, y, "_");
            tile.setColor(x, y, desert);
        }
        if (info.visible.getBiome(x, y, false) == -1)
        {
            tile.setText(x, y, "b");
            tile.setColor(x, y, Color.red);
        }
    } //end method

    public void dispBiomeSquare(int x, int y)
    {
        dispBiome(x, y);
        if (getBiome(x - 1, y - 1) != -2)
            dispBiome(x - 1, y - 1);
        if (getBiome(x, y - 1) != -2)
            dispBiome(x, y - 1);
        if (getBiome(x + 1, y - 1) != -2)
            dispBiome(x + 1, y - 1);
        if (getBiome(x + 1, y) != -2)
            dispBiome(x + 1, y);
        if (getBiome(x + 1, y + 1) != -2)
            dispBiome(x + 1, y + 1);
        if (getBiome(x, y + 1) != -2)
            dispBiome(x, y + 1);
        if (getBiome(x - 1, y + 1) != -2)
            dispBiome(x - 1, y + 1);
        if (getBiome(x - 1, y) != -2)
            dispBiome(x - 1, y);
    } //end method

    public void dispBiomeSquare()
    {
        dispBiomeSquare(currX, currY);
    }

    public void dispAllBiome()
    {
        info = Info.getInstance();
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
            //dispBiome(x, y);
            if (info.visible.getBiome(x, y, true) == 0)
            {
                tile.setText(x, y, ",.");
                tile.setColor(x, y, Color.green);
            }
            if (info.visible.getBiome(x, y, true) == 1)
            {
                tile.setText(x, y, "^");
                tile.setColor(x, y, Color.gray);
            }
            if (info.visible.getBiome(x, y, true) == 2)
            {
                tile.setText(x, y, "~");
                tile.setColor(x, y, Color.blue);
            }
            if (info.visible.getBiome(x, y, true) == 3)
            {
                tile.setText(x, y, "||");
                tile.setColor(x, y, forest);
            }
            if (info.visible.getBiome(x, y, true) == 4)
            {
                tile.setText(x, y, "_");
                tile.setColor(x, y, desert);
            }
            if (info.visible.getBiome(x, y, true) == -1)
            {
                tile.setText(x, y, "b");
                tile.setColor(x, y, Color.red);
            }
            i++;
            x++;
        }
    } //end method

    public void draw()
    {
        if (dispFog)
        {
            dispAllBiome();
            drawFog();
        } else
        {
            dispAllBiome();
        }
    } //end method

    public void debug()
    {
        if (debug)
        {
            debug = false;
            console("Debug: false");
            action.toggleDebug(false);
            infoLabel.toggleDebug(false);

        } else
        {
            debug = true;
            console("Debug: true");
            action.toggleDebug(true);
            infoLabel.toggleDebug(true);
        }
    }

    public void toggleFog()
    {
        if (dispFog)
        {
            console("Fog: false");
            dispFog = false;
            draw();

        } else
        {
            console("Fog: true");
            dispFog = true;
            draw();
        }
    }

    public void setInfoLable(int i, String s)
    {
        infoLabel.setText(i, s);
    }

    public void setInfoLable(int l, int i, String s)
    {
        infoLabel.setText(l, i, s);
    }

    public void setActionVisible(int i, boolean b)
    {
        //nul pointer when tile is clicked
        //button handler line 52 gngh 516
        action.setVisible(i, b);
    }

    public int getSliderDay()
    {
        return action.getSliderDay();
    }

    public void setSliderDay(int days)
    {
        action.setSliderDay(days);
    }
} //end
