package gui.main;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import util.SoundPlayer;
import util.debug.DebugInfo;
import world.generation.Generator;
import world.render.RenderTiles;

/*
    BenjaminWilcox
    Nov 9, 2016
    GNGH_2
 */
public class MainFrame extends JFrame
{

    //importing sub panels
    private Tiles tile;
    private Console console;
    private Actions actions;
    private MenuBar menuBar;
    //class initialization
    private SoundPlayer sound = new SoundPlayer();
    private DayTracker day = new DayTracker();
    private DebugInfo debug = new DebugInfo();

    public MainFrame(String s)
    {
        super(s);
        buildGUI();
        create();
        sound.playStart();
    }

    public void buildGUI()
    {
        setLayout(new BorderLayout());
        //initializing classes
        tile = new Tiles();
        console = new Console();
        actions = new Actions();
        menuBar = new MenuBar();
        //adding in order
        setJMenuBar(menuBar);
        add(tile, BorderLayout.CENTER);
        add(actions, BorderLayout.LINE_END);
        add(console, BorderLayout.PAGE_END);

    }

    //creates world
    public void create()
    {
        Generator generate = new Generator();
        generate.generateDefault();
        generate = null;
        new RenderTiles().render();
    }

} //end
