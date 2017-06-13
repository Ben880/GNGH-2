package CustomFileLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
    BenjaminWilcox
    May 30, 2017
    FileLoader
 */
public class Load
{

    private ArrayList<String> list = new ArrayList();
    private Scanner scanner;

    public Load(File f) throws FileNotFoundException
    {
        String temp;
        scanner = new Scanner(f);
        while (scanner.hasNext())
        {
            temp = scanner.nextLine();
            if (temp.charAt(0) != '#')
                list.add(temp);
        }
        scanner.close();

    }

    public void print()
    {
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
    }

    public String getLine(int i)
    {
        return list.get(i);
    }

    public int length()
    {
        return list.size();
    }

}
