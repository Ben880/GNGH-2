package gngh;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class LabelHandler
{

    ActionHandler handler;
    Tracker tracker;
    MainFrame frame;
    Info info;
    CoLabelHandler text;

    public LabelHandler()
    {
        text = new CoLabelHandler();
    }

    public void initialize(Info i, MainFrame f, Tracker t)
    {
        info = i;
        frame = f;
        tracker = t;
    }

    public void resourceUpdate()
    {
        frame.setInfoLable(0, 1, "Day: " + tracker.day().getDay());
        frame.setInfoLable(1, 1, "Day: " + tracker.day().getDay());
        frame.setInfoLable(2, 1, "Day: " + tracker.day().getDay());
        frame.setInfoLable(3, 1, "Day: " + tracker.day().getDay());
        frame.setInfoLable(2, 3, "food: " + info.resources().getFood());
        frame.setInfoLable(2, 4, "lumber: " + info.resources().getLumber());
        frame.setInfoLable(2, 5, "stone: " + info.resources().getStone());
        frame.setInfoLable(2, 6, "ore: " + info.resources().getOre());
        frame.setInfoLable(2, 7, "people: " + info.resources().getPeople());
        frame.setInfoLable(2, 8, "troops: " + info.resources().getTroops());
        frame.setInfoLable(2, 9, "tools: " + info.resources().getTools());
        frame.setInfoLable(2, 10, "horses: " + info.resources().getHorses());
        frame.setInfoLable(2, 11, "livestock: " + info.resources().getAnimals());
        frame.setInfoLable(2, 12, "medicine: " + info.resources().getMedicine());

    }

    public void clickUpdate(int x, int y)
    {
        info = Info.getInstance();
        int i = y * 20 + x;
        if (info.visible.getStatsVisible(x, y) || frame.debug)
        {
            frame.setInfoLable(0, 3, "Biome: " + info.visible.getBiomeString(x, y));
            frame.setInfoLable(0, 4, "Fertility: " + info.visible.getFertility(x, y));
            frame.setInfoLable(0, 5, "Mining: " + info.visible.getMining(x, y));
            frame.setInfoLable(0, 6, "Lumber: " + info.visible.getLumber(x, y));
            frame.setInfoLable(0, 7, "Owned: " + info.owned.getOwned(x, y));
            frame.setInfoLable(0, 8, "Enemy Type: " + info.enemy.getTypeString(x, y));
            frame.setInfoLable(0, 9, "Enemy Count: " + info.enemy.getAmount(x, y));
            frame.setInfoLable(0, 10, "Enemy Skill: " + info.enemy.getSkill(x, y));
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
            frame.setInfoLable(0, 3, "Biome: ??");
            frame.setInfoLable(0, 4, "Fertility: ??");
            frame.setInfoLable(0, 5, "Mining: ??");
            frame.setInfoLable(0, 6, "Lumber: ??");
            frame.setInfoLable(0, 7, "Owned: ?? ");
            frame.setInfoLable(0, 8, "Enemy Type: ??");
            frame.setInfoLable(0, 9, "Enemy Count: ??");
            frame.setInfoLable(0, 10, "Enemy Skill: ??");

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

    public String getButtonText(int i)
    {
        switch (i)
        {
            case 0:
                return "Scout";
            case 1:
                return "Attack";
            case 2:
                return "Forage";
            case 3:
                return " ";
            case 4:
                return "";
            case 5:
                return " ";
            case 6:
                return "Generic Event";
            case 7:
                return " ";
            case 8:
                return " ";
            case 9:
                return " ";
            case 10:
                return " ";
            case 11:
                return " ";
            case 12:
                return " ";
            case 13:
                return " ";
            case 14:
                return " ";
            case 15:
                return " ";
            case 16:
                return " ";
            case 17:
                return " ";
            case 18:
                return " ";
            case 19:
                return " ";
            case 20:
                return " ";

        }

        return "";
    }

}
