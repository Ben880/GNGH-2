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
    private boolean badHealth = false;
    private boolean criticalHealth = false;
    private double enemyHealthLeft;
    CitizenReleaseEvent citizens;

    public void simulate(Location l, CitizenReleaseEvent c)
    {
        citizens = c;
        double damageRatio = 50 / cell.getCell(l).enemy().getDefense();
        double defenseRatio = cell.getCell(l).enemy().getAttack() / 50;
        double troopHealth = 100;
        enemyHealthLeft = 100;
        System.out.println("Battle start: " + l.toString() + ", " + c.getType() + " vs. " + cell.getCell(l).enemy().getName() + ": " + cell.getCell(l).enemy().getCount());
        while (citizens.getCount() > 0 && cell.getCell(l).enemy().getCount() > 0)
        {
            while (troopHealth > 0 || enemyHealthLeft > 0)
            {
                enemyHealthLeft = enemyHealthLeft - (rand.nextInt(20) * damageRatio);
                troopHealth = troopHealth - (rand.nextInt(20) * defenseRatio);
            }
            if (troopHealth < 0)
            {
                System.out.println("Battle sim: troop death");
                citizens.addDead();
                troopHealth = 100;
            }
            if (enemyHealthLeft < 0)
            {
                System.out.println("Battle sim: enemy death");
                cell.getCell(l).enemy().subtract(1);
                enemyHealthLeft = 100;

            }
        }
        System.out.println("Battle end: " + l.toString() + ", " + citizens.getCount() + " vs. " + cell.getCell(l).enemy().getName() + ": " + cell.getCell(l).enemy().getCount());
        if (troopHealth < 25)
            criticalHealth = true;
        if (troopHealth < 50)
            badHealth = true;
        if (enemyHealthLeft < 35)
        {
            cell.getCell(l).enemy().subtract(1);
            enemyHealthLeft = 100;
        }
        System.out.println(citizens.getCount() + " troops");
    }

    public boolean winResults()
    {
        if (citizens.getCount() == 0)
            return false;
        return true;
    }

    public void pushEnemyResults(Location l)
    {
        if (cell.getCell(l).enemy().getCount() == 0)
            cell.getCell(l).enemy().reset();
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
