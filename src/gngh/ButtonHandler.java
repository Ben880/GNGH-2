package gngh;

import generation.ResourceGeneration;
import javax.swing.JOptionPane;
import render.RenderTiles;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class ButtonHandler
{

    int x;
    int y;
    Info info;
    Tracker tracker;
    MainFrame frame;
    GUIHandler gui;
    RenderTiles render = new RenderTiles();

    public ButtonHandler()
    {
        gui = GUIHandler.getInstance();
        //handler = h;
    }

    public void initialize(Info i, Tracker t, MainFrame f)
    {
        info = i;
        tracker = t;
        frame = f;
    }

    public void gameClick(int x, int y)
    {

        gui.label().clickUpdate(x, y);
        this.x = x;
        this.y = y;
    }

    public void actionClick(String source)
    {
        if (info.debug().getDebug() && source != "debugToggle")
            gui.console().append("actionClick source: " + source);
        if (source == "plusDays")
            frame.setSliderDay(frame.getSliderDay() + 10);
        if (source == "minusDays")
            frame.setSliderDay(frame.getSliderDay() - 10);
        if (source == "debugToggle")
            frame.debug();
        if (source == "toggleFog")
        {
            if (info.visible().fog)
            {
                info.visible().fog = false;
                render.renderAll();
            } else
            {
                info.visible().fog = true;
                render.render();
            }
        }
        if (source == "setBiome")
        {
            Object[] possibilities =
            {
                0, 1, 2, 3, 4
            };
            int newBiome = (int) JOptionPane.showInputDialog(
                    frame,
                    "Change tile: (" + x + ", " + y + ")"
                    + " to what biome?",
                    "Biome Change",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    possibilities,
                    0);
            info.visible.setBiome(x, y, newBiome);
            render.render();
        }
        if (source == "setBiome" || source == "calcValues")
        {
            ResourceGeneration generate = new ResourceGeneration();
            generate.fertility();
            generate.mining();
            generate.lumber();
        }
        if (source == "dayStart")
        {
            tracker.day().incriment(frame.getSliderDay() / 10);
            //frame.infoLabels[1].setText("    Day: " + day.getDay());
        }
    }

    public void actionClick(int i)
    {
//        //causes nullpointer
//        if (frame.debug)
//            frame.console("ButtonHandler actionClick btnNumber: " + i);
        switch (i)
        {
            case -1:
                break;
            case 0:
                tracker.event().scout(x, y);
                break;
            case 1:
                tracker.event().attack(x, y);
                break;
            case 2:
                tracker.event().forage(x, y);
                break;
            case 6:
                break;
        }
    }
}
