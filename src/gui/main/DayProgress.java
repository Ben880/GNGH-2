package gui.main;

import gui.BackEnd.UpdateDayProgress;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import util.GUIPallet;

/*
    BenjaminWilcox
    Aug 16, 2017
    GNGH2
 */
public class DayProgress extends JPanel
{

    private Dimension dayD = new Dimension(390, 100);
    private GUIPallet pallet = new GUIPallet();
    private JProgressBar progress = new JProgressBar();
    private JLabel label = new JLabel();

    public DayProgress()
    {
        new UpdateDayProgress().pasDayProgress(this);
        setPreferredSize(dayD);
        setBackground(pallet.getPanel());
        setLayout(new GridLayout(2, 1));
        label.setText("Next Day Progress: ");
        add(label);
        add(progress);
    }

    public void update(int i)
    {
        progress.setValue(i);
        label.setText("Next Day Progress: " + i * 100.00 / progress.getMaximum() + "%");
        validate();
    }

    public void setTotal(int i)
    {
        progress.setMaximum(i);
    }

}
