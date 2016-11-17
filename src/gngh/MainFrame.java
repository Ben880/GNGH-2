package gngh;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;

/*
    BenjaminWilcox
    Nov 9, 2016
    GNGH_2
 */
class MainFrame extends JFrame
{

    //importing sub panels
    Tiles tile;
    Console console;
    ActionButtons action;
    InfoLabels infoLabel;
    //Game variables
    public static int currX = 19;
    public static int currY = 19;
    //following sould not be controlled by this class
    //Classs import
    AudioPlayer sound;
    Info info;
    Tracker tracker;
    //distasteful palet here
    Color forest = new Color(0, 100, 0);
    Color desert = new Color(255, 209, 114);

    MainFrame(String s)
    {
        super(s);
        initialize();
        buildGUI();
        create();
        draw();
        action.setSliderDay(10);
        sound.playStartSound();
    }

    public void initialize()
    {
        info = Info.getInstance();
        tracker = Tracker.getInstance();
        GUIHandler gui = GUIHandler.getInstance();
        ActionHandler action = ActionHandler.getInstance();
        tracker.day().Initialize(tracker);
        gui.passFrame(this);
        gui.label().initialize(info, this, tracker);
        action.button().initialize(info, tracker, this);
    }

    public void buildGUI()
    {
        tile = new Tiles();
        console = new Console();
        action = new ActionButtons();
        infoLabel = new InfoLabels();
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
        if (info.visible().fog)
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
        if (info.debug().getDebug())
        {
            info.debug().setDebug(false);
            console("Debug: false");
            action.toggleDebug(false);
            infoLabel.toggleDebug(false);

        } else
        {
            info.debug().setDebug(true);
            console("Debug: true");
            action.toggleDebug(true);
            infoLabel.toggleDebug(true);
        }
    }

    public void toggleFog()
    {
        if (info.visible().fog)
        {
            console("Fog: false");
            info.visible().toggleFog();
            draw();

        } else
        {
            console("Fog: true");
            info.visible().toggleFog();
            draw();
        }
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
