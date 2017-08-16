package gui.BackEnd;

import gui.main.DayProgress;

/*
    BenjaminWilcox
    Aug 16, 2017
    GNGH2
 */
public class UpdateDayProgress
{

    private static DayProgress progress;

    public UpdateDayProgress()
    {

    }

    public void pasDayProgress(DayProgress d)
    {
        progress = d;
    }

    public void updateProgress(int i)
    {
        progress.update(i + 1);
    }

    public void setToltal(int i)
    {
        progress.setTotal(i);
    }

}
