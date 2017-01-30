package gngh;

import resources.ResourceHolder;

/*
    BenjaminWilcox
    Jan 11, 2017
    GNGH_2
 */
public class LabelCoHandler
{

    private String[][] text = new String[4][40];
    private DayTracker day = new DayTracker();
    private ResourceHolder resources = new ResourceHolder();

    public LabelCoHandler()
    {
        setText();
    }

    public String getText(int i, int j)
    {
        return text[i][j];
    }

    public void setText()
    {
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 40; j++)
            {
                text[i][j] = " ";
            }
        }
        text[0][1] = "Day: ";
        text[0][3] = "Biome: ";
        text[0][4] = "Fertility: ";
        text[0][5] = "Mining: ";
        text[0][6] = "Lumber: ";
        text[0][7] = "Owned: ";
        text[0][8] = "Enemy Type: ";
        text[0][9] = "Enemy Count: ";
        text[0][10] = "Enemy Skill: ";
        text[1][1] = "Day: ";
        text[2][1] = "Day: ";
        text[2][3] = "Food: ";
        text[2][4] = "Lumber: ";
        text[2][5] = "Stone: ";
        text[2][6] = "Ore: ";
        text[2][7] = "People: ";
        text[2][8] = "Troops: ";
        text[2][9] = "Tools: ";
        text[2][10] = "Horses: ";
        text[2][11] = "Livestock: ";
        text[2][12] = "Medicine: ";
        text[3][1] = "Day: ";
    }

}
