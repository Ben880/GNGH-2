package gngh;

import java.lang.*;
import java.util.Random;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class LandGeneration
{

    Random rand = new Random();
    Info info;

    public LandGeneration()
    {
        info = Info.getInstance();
    }

    public void generate()
    {
        int i = 0;
        int x = 0;
        int y = 0;
        while (i < 400)
        {
            if (x == 20)
            {
                x = 0;
                y++;
            }

            info.visible.setBiome(x, y, 0);
            info.visible.setBiomeVisible(x, y, false);
            info.visible.setStatsVisible(x, y, false);
            info.owned.setOwned(x, y, false);
            info.owned.setStructure(x, y, -1);
            i++;
            x++;
        }
        forest();
        forest();
        forest();
        forest();
        forest();
        forest();
        forest();
        forest();
        forest();
        forest();
        desert();
        desert();
        water();
        water();
        mountian();
        mountian();
        mountian();
        mountian();
        startP();
        fertility();
        mining();
        lumber();
        //start enemy creation
        populate();
        //generation of non land values
        ResourceInfo resources;
        resources = ResourceInfo.getInstance();
        resources = null;
    }

    public void desert() //4
    {
        int desert = rand.nextInt(399);
        int shape = rand.nextInt(5);
        int y = desert / 20;
        int x = desert % 20;
        if (shape >= 0)
        {
            setBiome(x + 0, y + 0, 4);
            setBiome(x + 1, y + 0, 4);
            setBiome(x + 0, y + 1, 4);
            setBiome(x - 1, y + 0, 4);
            setBiome(x + 0, y - 1, 4);
            setBiome(x + 1, y + 1, 4);
            setBiome(x + 2, y + 0, 4);
        }
        if (shape > 0)
        {
            setBiome(x + 2, y + 1, 4);
            setBiome(x + 3, y + 0, 4);
            setBiome(x + 2, y - 1, 4);
            setBiome(x + 1, y - 1, 4);
        }
        if (shape > 1)
        {
            setBiome(x + 3, y + 1, 4);
            setBiome(x + 1, y + 2, 4);
            setBiome(x + 4, y + 0, 4);
        }
        if (shape > 2)
        {
            setBiome(x - 1, y - 1, 4);
            setBiome(x - 1, y + 1, 4);
            setBiome(x - 2, y + 0, 4);
            setBiome(x + 2, y + 2, 4);
            setBiome(x + 0, y - 2, 4);
            setBiome(x + 1, y - 2, 4);
        }
    } //end method

    public void forest() //3
    {
        int forest = rand.nextInt(399);
        int shape = rand.nextInt(5);
        int y = forest / 20;
        int x = forest % 20;
        if (shape >= 0)
        {
            setBiome(x + 0, y + 0, 3);
            setBiome(x + 1, y + 0, 3);
            setBiome(x + 0, y + 1, 3);
            setBiome(x - 1, y + 0, 3);
            setBiome(x + 0, y - 1, 3);
            setBiome(x + 1, y + 1, 3);
            setBiome(x + 2, y + 0, 3);

            setBiome(x + 2, y + 1, 3);
            setBiome(x + 3, y + 0, 3);
            setBiome(x + 2, y - 1, 3);
            setBiome(x + 1, y - 1, 3);
        }
        if (shape > 0)
        {
            setBiome(x + 3, y + 1, 3);
            setBiome(x + 1, y + 2, 3);
            setBiome(x + 4, y + 0, 3);
        }
        if (shape > 1)
        {
            setBiome(x - 1, y - 1, 3);
            setBiome(x - 1, y + 1, 3);
            setBiome(x - 2, y + 0, 3);
            setBiome(x + 2, y + 2, 3);
            setBiome(x + 0, y - 2, 3);
            setBiome(x + 1, y - 2, 3);
        }
    } //end method

    public void water() //2
    {
        int water = rand.nextInt(399);
        int shape = rand.nextInt(5);
        int y = water / 20;
        int x = water % 20;
        if (shape >= 0)
        {
            setBiome(x + 0, y + 0, 2);
            setBiome(x + 1, y + 0, 2);
        }
        if (shape > 0)
        {
            setBiome(x + 0, y + 1, 2);
        }
        if (shape > 1)
        {
            setBiome(x - 1, y + 0, 2);
        }
        if (shape > 2)
        {
            setBiome(x + 0, y - 1, 2);
        }
        if (shape > 3)
        {
            setBiome(x + 1, y + 1, 2);
        }
    } //end method

    public void mountian() //1
    {
        boolean fail = true;
        while (fail)
        {
            int mountian = rand.nextInt(399);
            int shape = rand.nextInt(5);
            int y = mountian / 20;
            int x = mountian % 20;
            if (info.visible.getBiome(x, y, true) == 0)
            {
                fail = false;
                if (shape >= 0)
                {
                    setBiome(x + 0, y + 0, 1);
                    setBiome(x + 1, y + 0, 1);
                    setBiome(x + 0, y + 1, 1);
                    setBiome(x - 1, y + 0, 1);
                    setBiome(x + 0, y - 1, 1);
                    setBiome(x + 1, y + 1, 1);
                    setBiome(x + 2, y + 0, 1);
                }
                if (shape > 0)
                {
                    setBiome(x + 2, y + 1, 1);
                    setBiome(x + 3, y + 0, 1);
                }
                if (shape > 1)
                {
                    setBiome(x + 2, y - 1, 1);
                    setBiome(x + 1, y - 1, 1);
                }
                if (shape > 2)
                {
                    setBiome(x + 3, y + 1, 1);
                    setBiome(x + 1, y + 2, 1);
                    setBiome(x + 4, y + 0, 1);
                }
                if (shape > 2)
                {
                    setBiome(x - 1, y - 1, 1);
                    setBiome(x - 1, y + 1, 1);
                    setBiome(x - 2, y + 0, 1);
                    setBiome(x + 2, y + 2, 1);
                    setBiome(x + 0, y - 2, 1);
                    setBiome(x + 1, y - 2, 1);
                }
            }
        }

    } //end method

    public void setBiome(int x, int y, int i)
    {
        try // new class
        {
            info.visible.setBiome(x, y, i);
        } catch (Exception e)
        {

        }
    }

    public void startP() //-1
    {
        int x = 19;
        int y = 19;
        info.visible.setBiome(x, y, -1);
        info.visible.setBiome(x - 1, y - 0, 0);
        info.visible.setBiome(x - 1, y - 1, 0);
        info.visible.setBiome(x - 0, y - 1, 0);
        info.visible.setBiomeVisible(x, y, true);
        info.visible.setBiomeVisible(x - 1, y - 0, true);
        info.visible.setBiomeVisible(x - 1, y - 1, true);
        info.visible.setBiomeVisible(x - 0, y - 1, true);
        info.visible.setStatsVisible(x, y, true);
        info.visible.setStatsVisible(x - 1, y - 0, true);
        info.visible.setStatsVisible(x - 1, y - 1, true);
        info.visible.setStatsVisible(x - 0, y - 1, true);
        info.owned.setOwned(19, 19, true);

    } //end method

    public void fertility()
    {
        int i = 0;
        int x = 0;
        int y = 0;
        double temp;
        while (i < 400)
        {
            temp = 1;
            if (x == 20)
            {
                x = 0;
                y++;
            }
            //water check
            if (getBiome(x - 1, y - 1) == 2)
            {
                temp += .25;
            }
            if (getBiome(x + 1, y - 1) == 2)
            {
                temp += .25;
            }
            if (getBiome(x - 1, y + 1) == 2)
            {
                temp += .25;
            }
            if (getBiome(x + 1, y + 1) == 2)
            {
                temp += .25;
            }
            if (getBiome(x - 1, y) == 2)
            {
                temp += .5;
            }
            if (getBiome(x + 1, y) == 2)
            {
                temp += .5;
            }
            if (getBiome(x, y - 1) == 2)
            {
                temp += .5;
            }
            if (getBiome(x, y + 1) == 2)
            {
                temp += .5;
            }
            //desert check
            if (getBiome(x - 1, y - 1) == 4)
            {
                temp -= .25;
            }
            if (getBiome(x + 1, y - 1) == 4)
            {
                temp -= .25;
            }
            if (getBiome(x - 1, y + 1) == 4)
            {
                temp -= .25;
            }
            if (getBiome(x + 1, y + 1) == 4)
            {
                temp -= .25;
            }
            if (getBiome(x - 1, y) == 4)
            {
                temp -= .5;
            }
            if (getBiome(x + 1, y) == 4)
            {
                temp -= .5;
            }
            if (getBiome(x, y - 1) == 4)
            {
                temp -= .5;
            }
            if (getBiome(x, y + 1) == 4)
            {
                temp -= .5;
            }
            // desert tile check
            if (getBiome(x, y) == 4)
            {
                temp = .2;
            }
            if (temp < 0)

            {
                temp = .25;
            }
            info.visible.setFertility(x, y, temp);
            i++;
            x++;
        } //end while
    } //end method

    public void mining()
    {
        int i = 0;
        int x = 0;
        int y = 0;
        double temp;
        while (i < 400)
        {
            temp = 1;
            if (x == 20)
            {
                x = 0;
                y++;
            }
            //desert check
            if (getBiome(x - 1, y - 1) == 4)
            {
                temp += .15;
            }
            if (getBiome(x + 1, y - 1) == 4)
            {
                temp += .15;
            }
            if (getBiome(x - 1, y + 1) == 4)
            {
                temp += .15;
            }
            if (getBiome(x + 1, y + 1) == 4)
            {
                temp += .15;
            }
            if (getBiome(x - 1, y) == 4)
            {
                temp += .25;
            }
            if (getBiome(x + 1, y) == 4)
            {
                temp += .25;
            }
            if (getBiome(x, y - 1) == 4)
            {
                temp += .25;
            }
            if (getBiome(x, y + 1) == 4)
            {
                temp += .25;
            }
            // desert tile check
            if (getBiome(x, y) == 4)
            {
                temp = 2;
            }
            //moutian check
            if (getBiome(x - 1, y - 1) == 1)
            {
                temp += .25;
            }
            if (getBiome(x + 1, y - 1) == 1)
            {
                temp += .25;
            }
            if (getBiome(x - 1, y + 1) == 1)
            {
                temp += .25;
            }
            if (getBiome(x + 1, y + 1) == 1)
            {
                temp += .25;
            }
            if (getBiome(x - 1, y) == 1)
            {
                temp += .5;
            }
            if (getBiome(x + 1, y) == 1)
            {
                temp += .5;
            }
            if (getBiome(x, y - 1) == 1)
            {
                temp += .5;
            }
            if (getBiome(x, y + 1) == 1)
            {
                temp += .5;
            }
            if (temp < 0)

            {
                temp = .25;
            }
            info.visible.setMining(x, y, temp);
            i++;
            x++;
        }
    } //end method

    public void lumber()
    {
        int i = 0;
        int x = 0;
        int y = 0;
        double temp;
        while (i < 400)
        {
            temp = 1;
            if (x == 20)
            {
                x = 0;
                y++;
            }
            //water check
            if (getBiome(x - 1, y - 1) == 3)
            {
                temp += .25;
            }
            if (getBiome(x + 1, y - 1) == 3)
            {
                temp += .25;
            }
            if (getBiome(x - 1, y + 1) == 3)
            {
                temp += .25;
            }
            if (getBiome(x + 1, y + 1) == 3)
            {
                temp += .25;
            }
            if (getBiome(x - 1, y) == 3)
            {
                temp += .5;
            }
            if (getBiome(x + 1, y) == 3)
            {
                temp += .5;
            }
            if (getBiome(x, y - 1) == 3)
            {
                temp += .5;
            }
            if (getBiome(x, y + 1) == 3)
            {
                temp += .5;
            }
            //desert check
            if (getBiome(x - 1, y - 1) == 4)
            {
                temp -= .25;
            }
            if (getBiome(x + 1, y - 1) == 4)
            {
                temp -= .25;
            }
            if (getBiome(x - 1, y + 1) == 4)
            {
                temp -= .25;
            }
            if (getBiome(x + 1, y + 1) == 4)
            {
                temp -= .25;
            }
            if (getBiome(x - 1, y) == 4)
            {
                temp -= .5;
            }
            if (getBiome(x + 1, y) == 4)
            {
                temp -= .5;
            }
            if (getBiome(x, y - 1) == 4)
            {
                temp -= .5;
            }
            if (getBiome(x, y + 1) == 4)
            {
                temp -= .5;
            }
            // desert tile check
            if (getBiome(x, y) == 4)
            {
                temp = .2;
            }
            if (temp < 0)

            {
                temp = .25;
            }
            if (getBiome(x, y) == 3)
            {
                temp = 4;
            }
            info.visible.setLumber(x, y, temp);
            i++;
            x++;
        } //end while
    } //end method

    public int getBiome(int x, int y)
    {
        int bCheck = -2;
        try
        {
            bCheck = info.visible.getBiome(x, y, true);
        } catch (Exception e)
        {
        }
        return (bCheck);
    } //end method

    public void setFog()
    {
        int i = 0;
        int x = 0;
        int y = 0;
        while (i < 400)
        {
            if (x == 20)
            {
                x = 0;
                y++;
            }
            info.visible.setBiomeVisible(x, y, false);
            i++;
            x++;
        }
    } //end method

    public void populate()
    {
        //enemy types
        //
        int i = 0;
        int x = 0;
        int y = 0;
        while (i < 400)
        {
            if (x == 20)
            {
                x = 0;
                y++;
            }
            if (!(getBiome(x, y) == 2))
            {
                if (rand.nextInt(100) < 35)
                {
                    info.enemy.setType(x, y, rand.nextInt(25));
                    info.enemy.setSkill(x, y, 19 - (int) Math.round(Math.sqrt(rand.nextInt(400))));
                    info.enemy.setAmount(x, y, 19 - (int) Math.round(Math.sqrt(rand.nextInt(400))));

                }//end create enemy if
                else
                {
                    info.enemy.setType(x, y, -1);
                }
            }//end land check if
            else
            {
                info.enemy.setType(x, y, -1);
            }
            i++;
            x++;
        }
    }
}
