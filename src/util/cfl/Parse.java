package util.cfl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/*
    BenjaminWilcox
    May 31, 2017
    FileLoader
 */
//#bens custom file loader bcfl
//#### format ########
//# the character '#' denotes a comment and will not load to parser
//# blank lines shold not be used (note 1)
//# groups are denoted by a name followed by '{' on the next line (note 2)
//# the first group sould be named key and dictates the name of the data (note 3)
//# each group should contain the same amount of data
//# each group should be ended with '}' on its own line
//# embeded brackets will not work and each group should be opened/closed
//#### parser info ########
//# any line with a '#' at char(0) will not be recived by the parser
//# parser loads everthing as a string
//# (note 1) leaving a blank line will count as an empty string
//# (note 2) the parse looks for the string on line before '{' for a group name
//# (note 1+2) blank lines will count at group names and data names/values...
//# ... blank lines between groups will not load since the '{' starts the group
//# data will not be parsed if formatt is wrong
//# parser runs until end of file but will not parse lines at end if there is no group
//### search info ########
//# (note 3) search looks at key for data name then finds its number in the group
//# search will return the first matching value so duplicate names will be ignored
//### other notes #######
//# parser is not case sensative
//# key should be on first non comment line (trows FileFormatException)
//# improper placement of brackets will trow FileFormatException
//# improper amounts of data will throw FileFormatException (based on key)
//# fileFormatException will stop parsing file searches will not be possible
//# non existant searches will throw NoMatchException
//# dealt with proporly searches after a NoMatchEception will be possible
public class Parse
{

    private ArrayList<DataGroup> list = new ArrayList();
    Load l;

    public Parse(File f) throws FileFormatException, FileNotFoundException
    {
        l = new Load(f);
        test();
        sort();
    }

    private void test() throws FileFormatException
    {
        int numGroups = 0;
        int numData = 0;
        int dataCounter = 0;
        boolean groupStarted = false;
        if (!l.getLine(0).equalsIgnoreCase("key"))
            throw new FileFormatException();
        boolean countData = false;
        for (int i = 1; l.getLine(i).charAt(0) != '}'; i++)
        {
            if (countData)
                numData++;
            if (l.getLine(i).charAt(0) == '{')
                countData = true;

        }
        //System.out.println("Number of data:" + numData);
        for (int i = 1; i < l.length(); i++)
        {

            if (l.getLine(i).charAt(0) == '}')
            {
                if (!groupStarted)
                    throw new FileFormatException();
                if (dataCounter != numData)
                    throw new FileFormatException();
                groupStarted = false;
                dataCounter = 0;
            }
            if (groupStarted)
                dataCounter++;
            if (l.getLine(i).charAt(0) == '{')
            {
                if (groupStarted)
                    throw new FileFormatException();
                groupStarted = true;
                numGroups++;
            }

        }
    }

    private void sort()
    {
        String previous = "";
        int numGroup = 0;
        boolean groupStarted = false;
        for (int i = 0; i < l.length(); i++)
        {
            if (l.getLine(i).charAt(0) == '}')
            {
                groupStarted = false;
                numGroup++;
            }
            if (groupStarted)
                list.get(numGroup).addItem(l.getLine(i));
            if (l.getLine(i).charAt(0) == '{')
            {
                list.add(new DataGroup());
                list.get(numGroup).setName(previous);
                groupStarted = true;
            }

            previous = l.getLine(i);
        }

    }

    public void print()
    {
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i).getName());
            System.out.println("{");
            for (int j = 0; j < list.get(i).size(); j++)
            {
                System.out.println(list.get(i).getItem(j));
            }
            System.out.println("}");
        }
    }

    private int getGroup(String s) throws NoMatchException
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getName().equalsIgnoreCase(s))
                return i;
        }
        throw new NoMatchException();
    }

    private int getData(String s) throws NoMatchException
    {
        for (int i = 0; i < list.get(0).size(); i++)
        {
            if (list.get(0).getItem(i).equalsIgnoreCase(s))
                return i;
        }
        throw new NoMatchException();
    }

    public String getString(String group, String data) throws NoMatchException
    {
        return list.get(getGroup(group)).getItem(getData(data));
    }

}
