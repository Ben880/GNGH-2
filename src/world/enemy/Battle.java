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
    private int enemiesLeft;
    private double enemyHealthLeft;

    public void simulate(Location l, CitizenReleaseEvent citizens)
    {

        double damageRatio = 50 / cell.getCell(l).enemy().getDefense();
        double defenseRatio = cell.getCell(l).enemy().getAttack() / 50;
        enemiesLeft = cell.getCell(l).enemy().getAmount();
        double troopHealth = 100;
        enemyHealthLeft = cell.getCell(l).enemy().getHealth();
        System.out.println("Battle start: " + l.toString() + ", " + citizens.getType() + " vs. " + cell.getCell(l).enemy().getName() + ": " + enemiesLeft);
        while (citizens.getCount() > 0 && enemiesLeft > 0)
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
            if (troopHealth < 15)
            {
                System.out.println("Battle sim: troop disabled");
                citizens.addWounded();
                troopHealth = 100;
            }
            if (enemyHealthLeft < 0)
            {
                System.out.println("Battle sim: enemy death");
                enemiesLeft--;
                enemyHealthLeft = cell.getCell(l).enemy().getHealth();

            }
        }
        System.out.println("Battle end: " + l.toString() + ", " + citizens.getCount() + " vs. " + cell.getCell(l).enemy().getName() + ": " + enemiesLeft);
        if (enemyHealthLeft < 35)
        {
            enemiesLeft--;
            enemyHealthLeft = 100;
        }
        System.out.println(citizens.getCount() + " troops");
    }

    public void pushEnemyResults(Location l)
    {

        cell.getCell(l).enemy().setNumber(enemiesLeft);
        cell.getCell(l).enemy().setHealth(enemyHealthLeft);

    }

}
