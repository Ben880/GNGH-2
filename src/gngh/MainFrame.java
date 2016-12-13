package gngh;

import cell.CellHolder;
import generation.Generator;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import render.RenderTiles;
import util.SoundPlayer;

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
    //Classs import
    SoundPlayer sound = new SoundPlayer();
    Info info;
    Tracker tracker;
    //distasteful palet here
    Color forest = new Color(0, 100, 0);
    Color desert = new Color(255, 209, 114);

    MainFrame(String s)
    {
        super(s);
        buildGUI();
        initialize();

        create();
        action.setSliderDay(10);
        sound.playStart();
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
        CellHolder cells = new CellHolder();
        cells.initialize();
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
        setJMenuBar(menuBar);
    }

    public void create() //0
    {
        Generator generate = new Generator();
        generate.generateDefault();
        generate = null;
        RenderTiles render = new RenderTiles();
        render.render();
    }

    public void debug()
    {
        if (info.debug().getDebug())
        {
            info.debug().setDebug(false);
            GUIHandler.getInstance().console().append("Debug: false");
            action.toggleDebug(false);
            infoLabel.toggleDebug(false);

        } else
        {
            info.debug().setDebug(true);
            GUIHandler.getInstance().console().append("Debug: true");
            action.toggleDebug(true);
            infoLabel.toggleDebug(true);
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
