package gngh;

import cell.CellHolder;
import debug.DebugInfo;
import resources.Resources;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class LabelHandler
{

    CellHolder cell = new CellHolder();
    ActionHandler handler;
    DayTracker day = new DayTracker();
    Resources resources = new Resources();
    DebugInfo debug = new DebugInfo();
    CoLabelHandler text;
    InfoLabels label;
    MainFrame frame;

    public LabelHandler()
    {
        text = new CoLabelHandler();
    }

    public void initialize(MainFrame f)
    {
        frame = f;
    }

    public void init2(InfoLabels l)
    {
        label = l;
    }

    public void resourceUpdate()
    {
        label.setText(0, 1, "Day: " + day.getDay());
        label.setText(1, 1, "Day: " + day.getDay());
        label.setText(2, 1, "Day: " + day.getDay());
        label.setText(3, 1, "Day: " + day.getDay());
        label.setText(2, 3, "food: " + resources.getFood());
        label.setText(2, 4, "lumber: " + resources.getLumber());
        label.setText(2, 5, "stone: " + resources.getStone());
        label.setText(2, 6, "ore: " + resources.getOre());
        label.setText(2, 7, "people: " + resources.getPeople());
        label.setText(2, 8, "troops: " + resources.getTroops());
        label.setText(2, 9, "tools: " + resources.getTools());
        label.setText(2, 10, "horses: " + resources.getHorses());
        label.setText(2, 11, "livestock: " + resources.getAnimals());
        label.setText(2, 12, "medicine: " + resources.getMedicine());

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
                frame.infoLabel.buttonInfo.setText("  Button: " + i + " (" + x + "," + y + ")");
                frame.infoLabel.isOwned.setText("  Owned: " + cell.getCell(x, y).owned().isOwned());
            }
            frame.setActionVisible(0, !cell.getCell(x, y).visible().isStatsVisible());
            frame.setActionVisible(1, !cell.getCell(x, y).owned().isOwned());
            frame.setActionVisible(2, cell.getCell(x, y).visible().isStatsVisible());
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
                frame.infoLabel.buttonInfo.setText("  Button: " + i + " (" + x + "," + y + ")");
                frame.infoLabel.isOwned.setText("  Owned: " + cell.getCell(x, y).owned().isOwned());
            }
            frame.setActionVisible(0, !cell.getCell(x, y).visible().isStatsVisible());
            frame.setActionVisible(1, !cell.getCell(x, y).owned().isOwned());
            frame.setActionVisible(2, cell.getCell(x, y).visible().isStatsVisible());
        }

    }

    public String getDefaultText(int l, int i)
    {
        return text.getText(l, i);
    }

}
