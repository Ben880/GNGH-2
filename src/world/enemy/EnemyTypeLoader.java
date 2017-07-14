package world.enemy;

import config.ConfigLoader;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.cfl.FileFormatException;
import util.cfl.NoMatchException;
import util.cfl.Parse;


/*
    BenjaminWilcox
    Jul 13, 2017
    GNGH2
 */
public class EnemyTypeLoader
{

    private Parse parse;
    private EnemyTypeHolder type = new EnemyTypeHolder();

    public EnemyTypeLoader()
    {
        try
        {
            parse = new Parse(new ConfigLoader().getConfigFile("enemy"));
        } catch (FileFormatException ex)
        {
            Logger.getLogger(EnemyTypeLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(EnemyTypeLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < parse.size(); i++)
        {
            try
            {
                type.addEnemy(parse.getNameAt(i));
                type.getEnemy(i).setAttack(Double.parseDouble(parse.getString(i, "attack")));
                type.getEnemy(i).setDefense(Double.parseDouble(parse.getString(i, "defense")));
                type.getEnemy(i).setMultiplyer(Double.parseDouble(parse.getString(i, "multiplier")));
                type.getEnemy(i).setChance(Double.parseDouble(parse.getString(i, "chance")));
            } catch (NoMatchException ex)
            {
                Logger.getLogger(EnemyTypeLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        type.print();
    }

}
