package gngh;

/*
    BenjaminWilcox
    Nov 9, 2016
    GNGH_2
 */
public class ButtonDisplayHandler
{
//still needs to be initialized

    ActionButtons buttons;

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
}
