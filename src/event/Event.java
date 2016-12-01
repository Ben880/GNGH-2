package event;

/*
    BenjaminWilcox
    Nov 30, 2016
    GNGH_2
 */
public class Event
{

    String message;
    int compleet;

    public void setCompleet(int c)
    {
        compleet = c;
    }

    public void setMessage(String s)
    {
        message = s;
    }

    public int getCompleet()
    {
        return compleet;
    }

    public String getMessage()
    {
        return message;
    }

}
