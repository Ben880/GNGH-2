package player.citizens;

import java.util.ArrayList;

/*
    BenjaminWilcox
    Jun 26, 2017
    GNGH2
 */
public class CitizenHolder
{

    private static ArrayList<CitizenType> citizens = new ArrayList();
    private static CitizenLoader loader = new CitizenLoader();

    public CitizenHolder()
    {

    }

    public CitizenType getNumber(int i)
    {
        if (i < citizens.size())
            return citizens.get(i);
        return null;
    }

    public void createCitizen(String type, int count)
    {
        citizens.add(new CitizenType(type, count));
    }

    public void addCitizen(String type, int count)
    {
        getCitizen(type).addCitizen(count);
    }

    public CitizenType getCitizen(String name)
    {
        for (int i = 0; i < citizens.size(); i++)
        {
            if (citizens.get(i).getType().equalsIgnoreCase(name))
            {
                return citizens.get(i);
            }
        }
        return null;
    }

    public void printCitizens()
    {
        System.out.println("----Current Jobs----");
        for (int i = 0; i < citizens.size(); i++)
        {
            System.out.println(citizens.get(i).getType() + ": " + citizens.get(i).getCount());
        }
    }
}
