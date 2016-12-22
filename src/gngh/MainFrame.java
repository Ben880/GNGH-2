package gngh;

import cell.CellHolder;
import debug.DebugInfo;
import generation.Generator;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import render.RenderTiles;
import resources.ResourceHolder;
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
    MenuBar menuBar;
    //Classs import
    SoundPlayer sound = new SoundPlayer();
    DayTracker day = new DayTracker();
    DebugInfo debug = new DebugInfo();
    LabelHandler label = new LabelHandler();

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
        label.initialize(this);
        CellHolder cells = new CellHolder();
        cells.initialize();
        ResourceHolder resources = new ResourceHolder();

    }

    public void buildGUI()
    {
        tile = new Tiles();
        console = new Console();
        action = new ActionButtons();
        infoLabel = new InfoLabels();
        setLayout(new BorderLayout());
        menuBar = new MenuBar();
        add(infoLabel, BorderLayout.LINE_END);
        add(action, BorderLayout.LINE_START);
        add(console, BorderLayout.PAGE_END);
        add(tile, BorderLayout.CENTER);
        setJMenuBar(menuBar);
    }

    public void create() //0
    {
        Generator generate = new Generator();
        generate.generateDefault();
        generate = null;
        RenderTiles render = new RenderTiles();
        render.render();
        label.clickUpdate(19, 19);
        label.resourceUpdate();
    }

//    public void debug()
//    {
//        //ConsoleHandler console = new ConsoleHandler();
//        if (debug.getDebug())
//        {
//            debug.setDebug(false);
//            console.append("Debug: false");
//            action.toggleDebug(false);
//            infoLabel.toggleDebug(false);
//
//        } else
//        {
//            debug.setDebug(true);
//            console.append("Debug: true");
//            action.toggleDebug(true);
//            infoLabel.toggleDebug(true);
//        }
//    }
} //end
