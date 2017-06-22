package player.research;

import player.research.xml.XMLReader;
import java.util.ArrayList;

/*
    BenjaminWilcox
    Jan 28, 2017
    GNGH_2
 */
public class TechList
{

    private static ArrayList<Tech> techList = new ArrayList< Tech>();
    private static XMLReader read = new XMLReader();

    public TechList()
    {

    }

    public void build(ArrayList tech)
    {
        techList = tech;
    }

    public Tech getTech(int i)
    {
        return techList.get(i);
    }

    public int length()
    {
        return techList.size();
    }
}
