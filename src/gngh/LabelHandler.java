package gngh;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class LabelHandler
{
//singleton

    private static LabelHandler instance = null;
    DayTracker day;
    MainFrame frame;
    Info info;

    private LabelHandler()
    {

    }

    public static LabelHandler getInstance()
    {
        if (instance == null)
        {
            instance = new LabelHandler();
        }
        return instance;
    }

    public void resourceUpdate()
    {
        ResourceInfo resources;
        resources = ResourceInfo.getInstance();
        MainFrame frame;
        frame = MainFrame.getInstance("GNGH");
        day = DayTracker.getInstance();
        frame.setInfoLable(0, 1, "Day: " + day.getDay());
        frame.setInfoLable(1, 1, "Day: " + day.getDay());
        frame.setInfoLable(2, 1, "Day: " + day.getDay());
        frame.setInfoLable(3, 1, "Day: " + day.getDay());
        frame.setInfoLable(2, 3, "food: " + resources.getFood());
        frame.setInfoLable(2, 4, "lumber: " + resources.getLumber());
        frame.setInfoLable(2, 5, "stone: " + resources.getStone());
        frame.setInfoLable(2, 6, "ore: " + resources.getOre());
        frame.setInfoLable(2, 7, "people: " + resources.getPeople());
        frame.setInfoLable(2, 8, "troops: " + resources.getTroops());
        frame.setInfoLable(2, 9, "tools: " + resources.getTools());
        frame.setInfoLable(2, 10, "horses: " + resources.getHorses());
        frame.setInfoLable(2, 11, "livestock: " + resources.getAnimals());
        frame.setInfoLable(2, 12, "medicine: " + resources.getMedicine());

    }

    public void clickUpdate(int x, int y)
    {
        frame = MainFrame.getInstance("GNGH");
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
        ResourceInfo resources;
        resources = ResourceInfo.getInstance();
        if (l == 0)
        {
            switch (i)
            {
                case 1:
                    return "Day: 0";
                case 2:
                    return "";
                case 3:
                    return "Biome: ";
                case 4:
                    return "Fertility: ";
                case 5:
                    return "Mining: ";
                case 6:
                    return "Lumber: ";
                case 7:
                    return "Ownership: ";
                case 8:
                    return "Enemy Type: ";
                case 9:
                    return "Enemy Count: ";
                case 10:
                    return "Enemy Skill";
                case 11:
                    return "Atribute: ";
                case 12:
                    return "Atribute: ";
                case 13:
                    return "Atribute: ";
            }
        }//end if
        if (l == 1)
        {
            switch (i)
            {
                case 1:
                    return "Day: 0";
                case 2:
                    return "";
                case 3:
                    return "defense";
                case 4:
                    return "free space";
                case 5:
                    return "walls";
                case 6:
                    return "buildings";
                case 7:
                    return "more";
            }
        }//end if
        if (l == 2)
        {
            switch (i)
            {
                case 1:
                    return "Day: 0";
                case 2:
                    return "";
                case 3:
                    return "food: " + resources.getFood();
                case 4:
                    return "lumber: " + resources.getLumber();
                case 5:
                    return "stone: " + resources.getStone();
                case 6:
                    return "ore: " + resources.getOre();
                case 7:
                    return "people: " + resources.getPeople();
                case 8:
                    return "troops: " + resources.getTroops();
                case 9:
                    return "tools: " + resources.getTools();
                case 10:
                    return "horses: " + resources.getHorses();
                case 11:
                    return "livestock: " + resources.getAnimals();
                case 12:
                    return "medicine: " + resources.getMedicine();
            }
        }//end if
        if (l == 3)
        {
            switch (i)
            {
                case 1:
                    return "Day: 0";
                case 2:
                    return "";
                case 3:
                    return "";
                case 4:
                    return " army farming smithing scouting ect";
                case 5:
            }
        }
        return "";
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
