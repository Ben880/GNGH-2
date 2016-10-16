package gngh;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class EventHolder
{

    MyFrame frame;
    Info info;
    DayTracker day;
    ResourceTracker resources;
    //reserved types
    //scout 0
    //attack 1
    //forage 2
    //generic 6

    private boolean console = false;
    private boolean dispBiomeSquare = false;
    private boolean setStatsVisible = false;
    private boolean setEnemies = false;

    private String message = "Message not set";
    private int type = 0;
    public int compleet = 0;
    private int x;
    private int y;
    private int people = 0;
    private int troops = 0;
    private int food = 0;
    private int enemies = 0;

    public void EventHolder()
    {

    }

    public void finish()
    {
        frame = MyFrame.getInstance("GNGH");
        info = Info.getInstance();
        day = DayTracker.getInstance();
        resources = ResourceTracker.getInstance();
        if (console)
            frame.console(message);
        if (dispBiomeSquare)
            frame.dispBiomeSquare(x, y);
        if (setStatsVisible)
            info.visible.setStatsVisible(x, y, true);
        resources.setFood(food + resources.getFood());
        resources.setPeople(people + resources.getPeople());
        LabelHandler.getInstance().resourceUpdate();
        if (setEnemies)
        {
            info.enemy.setAmount(x, y, enemies);
            if (enemies == 0)
            {
                info.enemy.setSkill(x, y, 0);
                info.enemy.setType(x, y, -1);
            }
            frame.dispBiomeSquare(x, y);
            info.visible.setStatsVisible(x, y, true);
            resources.setTroops(resources.getTroops() + troops);

        }
    }

    public void createGenericEvent(int compleet)
    {
        this.compleet = compleet;
        type = 6;
    }

    public void createEvent(int type, int compleet)
    {
        this.compleet = compleet;
    }

    public int getPeople()
    {
        return people;

    }

    public int getFood()
    {
        return food;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    //get methods
    public String getMessage()
    {
        return message;
    }

    public int getCompleet()
    {
        return compleet;
    }

    public int getType()
    {
        return type;
    }

    //set methods
    public void setType(int i)
    {
        type = i;
        if (i == 0)
        {
            dispBiomeSquare = true;
            setStatsVisible = true;
        }
    }

    public void setCompleet(int days)
    {
        compleet = days;
    }

    public void setPos(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void setMessage(String s)
    {
        message = s;
        console = true;
    }

    public void setPeople(int i)
    {
        people = i;
    }

    public void setFood(int i)
    {
        food = i;
    }

    public void setTroops(int i)
    {
        troops = i;
    }

    public void setEnemies(int i)
    {
        enemies = i;
        setEnemies = true;
    }

}
