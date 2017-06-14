package gui.main;

import debug.DebugInfo;
import resources.ResourceHolder;
import world.CellHolder;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class LabelHandler
{

    private static CellHolder cell = new CellHolder();
    private static DayTracker day = new DayTracker();
    private static ResourceHolder resources = new ResourceHolder();
    private static DebugInfo debug = new DebugInfo();
    private static ButtonDisplayHandler dispButton = new ButtonDisplayHandler();
//    private static LabelCoHandler text = new LabelCoHandler();
    private static Actions label;
//    private static MainFrame frame;

    public LabelHandler()
    {

    }

//    public void initialize(MainFrame f)
//    {
//        frame = f;
//    }
    public void init2(Actions l)
    {
        label = l;

    }

    public void resourceUpdate()
    {
        dayUpdate();
        label.setText(2, 3, "food: " + resources.food().get());
        label.setText(2, 4, "lumber: " + resources.lumber().get());
        label.setText(2, 5, "stone: " + resources.stone().get());
        label.setText(2, 6, "ore: " + resources.ore().get());
        label.setText(2, 7, "people: " + resources.people().get());
        label.setText(2, 8, "troops: " + resources.troops().get());
        label.setText(2, 9, "tools: " + resources.tools().get());
        label.setText(2, 10, "horses: " + resources.horses().get());
        label.setText(2, 11, "livestock: " + resources.animals().get());
        label.setText(2, 12, "medicine: " + resources.medicine().get());

    }

    public void dayUpdate()
    {
        for (int i = 0; i < 4; i++)
        {
            label.setText(i, 1, "Day: " + day.getDay());
        }
    }

    public void clickUpdate(int x, int y)
    {
        int i = y * 20 + x;
        if (cell.getCell(x, y).visible().isStatsVisible() || debug.getDebug())
        {
            label.setText(0, 3, "Biome: " + cell.getCell(x, y).biome().getName());
            label.setText(0, 4, "Fertility: " + cell.getCell(x, y).resources().getFertility());
            label.setText(0, 5, "Mining: " + cell.getCell(x, y).resources().getMining());
            label.setText(0, 6, "Lumber: " + cell.getCell(x, y).resources().getLumber());
            label.setText(0, 7, "Owned: " + cell.getCell(x, y).owned().isOwned());
            label.setText(0, 8, "Enemy Type: " + cell.getCell(x, y).enemy().getName());
            label.setText(0, 9, "Enemy Count: " + cell.getCell(x, y).enemy().getAmount());
            label.setText(0, 10, "Enemy Skill: " + cell.getCell(x, y).enemy().getAttack());
            label.setText(0, 11, "Enemy Skill: " + cell.getCell(x, y).enemy().getDefense());
            if (debug.getDebug())
            {
//                frame.infoLabel.buttonInfo.setText("  Button: " + i + " (" + x + "," + y + ")");
//                frame.infoLabel.isOwned.setText("  Owned: " + cell.getCell(x, y).owned().isOwned());
            }

        } else
        {
            label.setText(0, 3, "Biome: ??");
            label.setText(0, 4, "Fertility: ??");
            label.setText(0, 5, "Mining: ??");
            label.setText(0, 6, "Lumber: ??");
            label.setText(0, 7, "Owned: ?? ");
            label.setText(0, 8, "Enemy Type: ??");
            label.setText(0, 9, "Enemy Count: ??");
            label.setText(0, 10, "Enemy Skill: ??");

            if (debug.getDebug())
            {
//                frame.infoLabel.buttonInfo.setText("  Button: " + i + " (" + x + "," + y + ")");
//                frame.infoLabel.isOwned.setText("  Owned: " + cell.getCell(x, y).owned().isOwned());
            }

        }

    }
//
//    public String getDefaultText(int l, int i)
//    {
//        return text.getText(l, i);
//    }

}
