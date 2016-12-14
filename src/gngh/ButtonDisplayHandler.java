package gngh;

/*
    BenjaminWilcox
    Nov 9, 2016
    GNGH_2
 */
public class ButtonDisplayHandler
{
//still needs to be initialized

    private static ActionButtons buttons;

    public ButtonDisplayHandler()
    {

    }

    public void initialize(ActionButtons b)
    {
        buttons = b;
    }

    public void setVisible(int i, boolean b)
    {
        buttons.setVisible(i, b);
    }

    public void setSlider(int i)
    {
        buttons.setSliderDay(i * 10);
    }

    public String getButtonText(int i)
    {
        switch (i)
        {
            case 0:
                return "Scout";
            case 1:
                return "Attack";
            case 2:
                return "Forage";
            case 3:
                return " ";
            case 4:
                return "";
            case 5:
                return " ";
            case 6:
                return "Generic Event";
            case 7:
                return " ";
            case 8:
                return " ";
            case 9:
                return " ";
            case 10:
                return " ";
            case 11:
                return " ";
            case 12:
                return " ";
            case 13:
                return " ";
            case 14:
                return " ";
            case 15:
                return " ";
            case 16:
                return " ";
            case 17:
                return " ";
            case 18:
                return " ";
            case 19:
                return " ";
            case 20:
                return " ";

        }

        return "";
    }
}
