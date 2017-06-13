package CustomFileLoader;

import java.util.ArrayList;

/*
    BenjaminWilcox
    May 31, 2017
    FileLoader
 */
public class DataGroup
{

    private ArrayList<String> list = new ArrayList();
    private String name;

    public void setName(String s)
    {
        name = s;
    }

    public String getName()
    {
        return name;
    }

    public void addItem(String s)
    {
        list.add(s);
    }

    public String getItem(int i)
    {
        return list.get(i);
    }

    public int size()
    {
        return list.size();
    }

}
