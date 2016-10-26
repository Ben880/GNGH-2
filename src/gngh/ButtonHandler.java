package gngh;

import javax.swing.JOptionPane;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class ButtonHandler
{

    private static ButtonHandler instance = null;
    MyFrame frame;
    int x;
    int y;
    Info info;
    DayTracker day;
    EventHandler event;

    private ButtonHandler()
    {
        info = Info.getInstance();
    }

    public static ButtonHandler getInstance()
    {
        if (instance == null)
        {
            instance = new ButtonHandler();
        }
        return instance;
    }

    public void gameClick(int x, int y)
    {
        LabelHandler labels;
        labels = LabelHandler.getInstance();
        labels.clickUpdate(x, y);
        this.x = x;
        this.y = y;
    }

    public void actionClick(String source)
    {
        frame = MyFrame.getInstance("GNGH");
        if (frame.debug && source != "debugToggle")
            frame.console("actionClick source: " + source);
        if (source == "plusDays")
            frame.setSliderDay(frame.getSliderDay() + 10);
        if (source == "minusDays")
            frame.setSliderDay(frame.getSliderDay() - 10);
        if (source == "debugToggle")
            frame.debug();
        if (source == "toggleFog")
            frame.toggleFog();
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
            frame.draw();

        }
        if (source == "setBiome" || source == "calcValues")
        {
            LandGeneration generate = new LandGeneration();
            generate.fertility();
            generate.mining();
            generate.lumber();
        }
        if (source == "dayStart")
        {
            day = DayTracker.getInstance();
            day.incriment(frame.getSliderDay() / 10);
            //frame.infoLabels[1].setText("    Day: " + day.getDay());
        }
    }

    public void actionClick(int i)
    {
        event = EventHandler.getInstance();
//        //causes nullpointer
//        if (frame.debug)
//            frame.console("ButtonHandler actionClick btnNumber: " + i);
        switch (i)
        {
            case -1:
                break;
            case 0:
                event.scout(x, y);
                break;
            case 1:
                event.attack(x, y);
                break;
            case 2:
                event.forage(x, y);
                break;
            case 6:
                break;
        }
    }
}
