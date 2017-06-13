package gui.main;

import debug.DebugInfo;
import event.UserCreatedEvent;
import util.Location;
import world.CellHolder;
import world.generation.ResourceGeneration;
import world.render.RenderTiles;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class ButtonHandler
{

    private static int x;
    private static int y;
//    private static MainFrame frame;
    ButtonDisplayHandler buttons = new ButtonDisplayHandler();
    private static RenderTiles render = new RenderTiles();
    private static DayTracker day = new DayTracker();
    private static UserCreatedEvent event = new UserCreatedEvent();
    private static CellHolder cell = new CellHolder();
    private static DebugInfo debug = new DebugInfo();
    private static LabelHandler label = new LabelHandler();
    private static ConsoleHandler console = new ConsoleHandler();

    public ButtonHandler()
    {

    }

    public void initialize(MainFrame f)
    {
        //frame = f;
    }

    public void gameClick(int x, int y)
    {

        label.clickUpdate(x, y);
        this.x = x;
        this.y = y;
    }

    public void actionClick(String source)
    {
        if (debug.getDebug() && source != "debugToggle")
            console.append("actionClick source: " + source);
//        if (source == "plusDays")
//            buttons.setSliderDay(buttons.getSliderDay() + 10);
//        if (source == "minusDays")
//            buttons.setSliderDay(buttons.getSliderDay() - 10);
        if (source == "debugToggle")
            debug.toggleDebug();
        if (source == "toggleFog")
        {
            if (cell.fog)
            {
                cell.fog = false;
                render.renderAll();
            } else
            {
                cell.fog = true;
                render.render();
            }
        }
        if (source == "setBiome")
        {
//            Object[] possibilities =
//            {
//                0, 1, 2, 3, 4
//            };
//            int newBiome = (int) JOptionPane.showInputDialog(
//                    frame,
//                    "Change tile: (" + x + ", " + y + ")"
//                    + " to what biome?",
//                    "Biome Change",
//                    JOptionPane.PLAIN_MESSAGE,
//                    null,
//                    possibilities,
//                    0);
//            cell.getCell(x, y).setBiome(newBiome);
//            render.render();
        }
        if (source == "setBiome" || source == "calcValues")
        {
            ResourceGeneration generate = new ResourceGeneration();
            generate.fertility();
            generate.mining();
            generate.lumber();
        }
//        if (source == "dayStart")
//        {
//            day.incriment(buttons.getSliderDay() / 10);
//        }
    }

    public void actionClick(int i)
    {
        switch (i)
        {
            case -1:
                break;
            case 0:
                event.create(new Location(x, y), 0);
                break;
            case 1:
                event.create(new Location(x, y), 1);
                break;
            case 2:
                event.create(new Location(x, y), 2);
                break;
            case 3:
                event.create(3);
                break;
            case 4:
                event.create(4);
                break;
            case 5:
                event.create(5);
                break;
        }
    }
}
