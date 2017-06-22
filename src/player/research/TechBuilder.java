package player.research;

import player.research.xml.XMLReader;
import java.util.ArrayList;

/*
    BenjaminWilcox
    Jan 28, 2017
    GNGH_2
 */
public class TechBuilder
{

    private static ArrayList<Tech> techList = new ArrayList< Tech>();
    private static XMLReader read = new XMLReader();

    public TechBuilder()
    {

    }

    public void build()
    {
        buildTech();
        fillDependants();
        TechList list = new TechList();
        list.build(techList);
    }

    public Tech getTech(int i)
    {
        return techList.get(i);
    }

    public int length()
    {
        return techList.size();
    }

    private void buildTech()
    {
        for (int i = 0; i < read.getParentLength(); i++)
        {
            techList.add(new Tech());
            techList.get(i).buildTech(read.getParentName(i), read.getAquiered(i), read.getDepend1(i), read.getDepend2(i), read.getTime(i), read.getMultiplier(i), read.getStat(i));
        }
    }

    private void fillDependants()
    {
        int temp1 = 0;
        int temp2 = 0;
        for (int i = 0; i < techList.size(); i++)
        {
            for (int j = 1; j < techList.size(); j++)
            {
                if (techList.get(j).getName().equals(techList.get(i).getDep1()))
                    temp1 = j;
            }
            for (int j = 1; j < techList.size(); j++)
            {
                if (techList.get(j).getName().equals(techList.get(i).getDep2()))
                    temp2 = j;
            }
            techList.get(i).setDependant(techList.get(temp1), techList.get(temp2));
        }

    }
}
