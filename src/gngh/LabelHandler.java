package gngh;

import cell.CellHolder;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class LabelHandler
{

    CellHolder cell = new CellHolder();
    ActionHandler handler;
    Tracker tracker;
    Info info;
    CoLabelHandler text;
    InfoLabels label;
    MainFrame frame;

    public LabelHandler()
    {
        text = new CoLabelHandler();
    }

    public void initialize(Info i, MainFrame f, Tracker t)
    {
        info = i;
        tracker = t;
        frame = f;
    }

    public void init2(InfoLabels l)
    {
        label = l;
    }

    public void resourceUpdate()
    {
        label.setText(0, 1, "Day: " + tracker.day().getDay());
        label.setText(1, 1, "Day: " + tracker.day().getDay());
        label.setText(2, 1, "Day: " + tracker.day().getDay());
        label.setText(3, 1, "Day: " + tracker.day().getDay());
        label.setText(2, 3, "food: " + info.resources().getFood());
        label.setText(2, 4, "lumber: " + info.resources().getLumber());
        label.setText(2, 5, "stone: " + info.resources().getStone());
        label.setText(2, 6, "ore: " + info.resources().getOre());
        label.setText(2, 7, "people: " + info.resources().getPeople());
        label.setText(2, 8, "troops: " + info.resources().getTroops());
        label.setText(2, 9, "tools: " + info.resources().getTools());
        label.setText(2, 10, "horses: " + info.resources().getHorses());
        label.setText(2, 11, "livestock: " + info.resources().getAnimals());
        label.setText(2, 12, "medicine: " + info.resources().getMedicine());

    }

    public void clickUpdate(int x, int y)
    {
        info = Info.getInstance();
        int i = y * 20 + x;
        if (cell.getCell(x, y).visible().isStatsVisible() || info.debug().getDebug())
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
            if (info.debug().getDebug())
            {
                frame.infoLabel.buttonInfo.setText("  Button: " + i + " (" + x + "," + y + ")");
                frame.infoLabel.isOwned.setText("  Owned: " + info.owned.getOwned(x, y));
            }
            frame.setActionVisible(0, !info.visible.getStatsVisible(x, y));
            frame.setActionVisible(1, !info.owned.getOwned(x, y));
            frame.setActionVisible(2, info.visible.getStatsVisible(x, y));
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

            if (info.debug().getDebug())
            {
                frame.infoLabel.buttonInfo.setText("  Button: " + i + " (" + x + "," + y + ")");
                frame.infoLabel.isOwned.setText("  Owned: " + info.owned.getOwned(x, y));
            }
            frame.setActionVisible(0, !info.visible.getStatsVisible(x, y));
            frame.setActionVisible(1, !info.owned.getOwned(x, y));
            frame.setActionVisible(2, info.visible.getStatsVisible(x, y));
        }

    }

    public String getDefaultText(int l, int i)
    {
        return text.getText(l, i);
    }

}
