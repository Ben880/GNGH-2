package resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
    BenjaminWilcox
    Dec 16, 2016
    GNGH_2
 */
public class LoadCFG
{

    LoadCFG(ResourceHolder resource)
    {
        Scanner file = null;
        try
        {
            file = new Scanner(new File("config\\resource.txt"));
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(ResourceHolder.class.getName()).log(Level.SEVERE, null, ex);
        }
        resource.food().set(file.nextInt());
        resource.lumber().set(file.nextInt());
        resource.ore().set(file.nextInt());
        resource.tools().set(file.nextInt());
        resource.animals().set(file.nextInt());
        resource.people().set(file.nextInt());
        resource.troops().set(file.nextInt());
        resource.medicine().set(file.nextInt());

    }
}
