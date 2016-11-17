package gngh;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class LabelHandler
{

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
        if (info.visible.getStatsVisible(x, y) || frame.debug)
        {
            label.setText(0, 3, "Biome: " + info.visible.getBiomeString(x, y));
            label.setText(0, 4, "Fertility: " + info.visible.getFertility(x, y));
            label.setText(0, 5, "Mining: " + info.visible.getMining(x, y));
            label.setText(0, 6, "Lumber: " + info.visible.getLumber(x, y));
            label.setText(0, 7, "Owned: " + info.owned.getOwned(x, y));
            label.setText(0, 8, "Enemy Type: " + info.enemy.getTypeString(x, y));
            label.setText(0, 9, "Enemy Count: " + info.enemy.getAmount(x, y));
            label.setText(0, 10, "Enemy Skill: " + info.enemy.getSkill(x, y));
            if (frame.debug)
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

            if (frame.debug)
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
