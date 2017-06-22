package player.research;

import java.util.ArrayList;

/*
    BenjaminWilcox
    Jan 28, 2017
    GNGH_2
 */
public class ListReader
{

    TechList list = new TechList();

    public Tech getTech(String tech)
    {
        for (int i = 0; i < list.length(); i++)
        {
            if (list.getTech(i).getName().equals(tech))
                return list.getTech(i);
        }
        return list.getTech(0);
    }

    public String[] getAvalible()
    {
        ArrayList<String> avalible = new ArrayList<String>();
        for (int i = 0; i < list.length(); i++)
        {
            if (list.getTech(i).getDependant1().isAquired() && list.getTech(i).getDependant2().isAquired() && !list.getTech(i).isAquired())
                avalible.add(list.getTech(i).getName());
        }
        String[] array = new String[avalible.size()];
        for (int i = 0; i < avalible.size(); i++)
        {
            array[i] = avalible.get(i);
        }
        return array;
    }

}
