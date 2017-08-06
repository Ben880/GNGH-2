package player.resources;

import java.util.ArrayList;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class ResourceProduction
{

    private static ArrayList<Producer> list = new ArrayList();
    private static ResourceHolder resources = new ResourceHolder();
    private static BaseProduction b = new BaseProduction();

    public ResourceProduction()
    {

    }

    public int pollProduction(Resource resource)
    {
        int temp = 0;
        for (int i = 0; i < list.size(); i++)
        {
            if (resource.getName() == list.get(i).getResourceName())
                temp += list.get(i).getProduction();
        }
        return temp;
    }

    public void addProducer(Resource resource, int count) throws NoSuchResourceException
    {
        list.add(new Producer(resource, count));
    }

    public void dayChange()
    {
        for (int i = 0; i < list.size(); i++)
        {
            list.get(i).produce();

        }
    }

    public void printProducers()
    {
        System.out.println("----Producers------");
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i).getResourceName() + ": " + list.get(i).getProduction());
        }
    }

}
