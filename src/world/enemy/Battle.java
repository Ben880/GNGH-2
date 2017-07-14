package world.enemy;

import java.util.Random;
import util.Location;
import world.CellHolder;
import world.event.CitizenReleaseEvent;

/*
    BenjaminWilcox
    Jan 13, 2017
    GNGH_2
 */
public class Battle
{

    private CellHolder cell = new CellHolder();
    private Random rand = new Random();
    private int troopsLeft;
    private boolean winResult = true;
    private boolean badHealth = false;
    private boolean criticalHealth = false;
    private int enemiesLeft;
    private double enemyHealthLeft;
    CitizenReleaseEvent citizens;

    public void simulate(Location l, CitizenReleaseEvent c)
    {
        citizens = c;
        double damageRatio = 50 / cell.getCell(l).enemy().getDefense();
        double defenseRatio = cell.getCell(l).enemy().getAttack() / 50;
        enemiesLeft = cell.getCell(l).enemy().getCount();
        double troopHealth = 100;
        enemyHealthLeft = 100;
        System.out.println("Battle start: " + l.toString() + ", " + c.getType() + " vs. " + cell.getCell(l).enemy().getName() + ": " + enemiesLeft);
        while (troopsLeft > 0 && enemiesLeft > 0)
        {
            while (troopHealth > 0 || enemyHealthLeft > 0)
            {
                enemyHealthLeft = enemyHealthLeft - (rand.nextInt(20) * damageRatio);
                troopHealth = troopHealth - (rand.nextInt(20) * defenseRatio);
            }
            if (troopHealth < 0)
            {
                System.out.println("Battle sim: troop death");
                troopsLeft--;
                troopHealth = 100;
            }
            if (enemyHealthLeft < 0)
            {
                System.out.println("Battle sim: enemy death");
                enemiesLeft--;
                enemyHealthLeft = 100;

            }
        }
        System.out.println("Battle end: " + l.toString() + ", " + troopsLeft + " vs. " + cell.getCell(l).enemy().getName() + ": " + enemiesLeft);
        if (troopsLeft <= 0)
            winResult = false;
        if (troopHealth < 25)
            criticalHealth = true;
        if (troopHealth < 50)
            badHealth = true;
        if (enemyHealthLeft < 35)
        {
            enemiesLeft--;
            enemyHealthLeft = 100;
        }
        System.out.println(troopsLeft + " troops");
    }

    public boolean winResults()
    {
        return winResult;
    }

    public int troopResults()
    {
        System.out.println("Returning " + troopsLeft + " troops");
        return troopsLeft;
    }

    public void pushEnemyResults(Location l)
    {
        if (winResult)
        {
            cell.getCell(l).enemy().reset();
        } else
        {
            cell.getCell(l).enemy().setCount(enemiesLeft);
        }
    }

    public boolean criticalHealth()
    {
        return criticalHealth;
    }

    public boolean badHealth()
    {
        return badHealth;
    }

}
