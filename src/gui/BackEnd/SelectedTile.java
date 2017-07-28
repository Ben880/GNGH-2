package gui.BackEnd;

import util.Location;

/*
    BenjaminWilcox
    Jun 16, 2017
    GNGH_2
 */
public class SelectedTile
{

    private static Location location = new Location(19, 19);

    //holds last selected tile to render outline
    public SelectedTile()
    {

    }

    public void setSelected(Location l)
    {
        location = l;
    }

    public Location getSelected()
    {
        return location;
    }

}
