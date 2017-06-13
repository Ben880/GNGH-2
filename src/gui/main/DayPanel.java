package gui.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import util.GUIPallet;

/*
    BenjaminWilcox
    Jun 12, 2017
    GNGH_2
 */
public class DayPanel extends JPanel
{

    //Days Actions
    JPanel daysActions = new JPanel();
    JSlider daySlider = new JSlider();
    JButton dayStart = new JButton();
    JLabel dayDisplay = new JLabel();
    JButton plusDays = new JButton();
    JButton minusDays = new JButton();
    Dimension sliderD = new Dimension(270, 35);
    Dimension dayD = new Dimension(290, 100);
    GUIPallet pallet = new GUIPallet();

    DayTracker dayTracker = new DayTracker();

    public DayPanel()
    {
        //Day stuff
        //day holder
        daysActions.setPreferredSize(dayD);
        daysActions.setBackground(pallet.getPanel());
        add(daysActions);
        //Info lable
        dayDisplay.setFont(new Font("Arial", Font.PLAIN, 12));
        dayDisplay.setText("    Days: 5    ");
        dayDisplay.setBackground(pallet.getPanel());
        dayDisplay.setBorder(BorderFactory.createEmptyBorder());
        daysActions.add(dayDisplay);
        //slider
        daySlider.setPreferredSize(sliderD);
        daySlider.setSnapToTicks(true);
        daySlider.setPaintTicks(true);
        daySlider.setBackground(pallet.getPanel());
        daySlider.setForeground(Color.BLACK);
        daySlider.addChangeListener(new SliderHandler());
        daySlider.setMajorTickSpacing(10);
        daysActions.add(daySlider);
        //minus start plus
        minusDays.setText("-");
        minusDays.addActionListener(new ActionPress());
        minusDays.setActionCommand("minusDays");
        daysActions.add(minusDays);
        dayStart.setText("Start");
        dayStart.addActionListener(new ActionPress());
        dayStart.setActionCommand("dayStart");
        daysActions.add(dayStart);
        plusDays.setText("+");
        plusDays.addActionListener(new ActionPress());
        plusDays.setActionCommand("plusDays");
        daysActions.add(plusDays);
    }

    public int getSliderDay()
    {
        return daySlider.getValue();
    }

    public void setSliderDay(int i)
    {
        daySlider.setValue(i);
    }

    class ActionPress implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == plusDays)
            {
                System.out.println("day slider +1");
                setSliderDay(getSliderDay() + 10);
            } else if (event.getSource() == minusDays)
            {
                setSliderDay(getSliderDay() - 10);
            } else if (event.getSource() == dayStart)
            {
                dayTracker.incriment(getSliderDay() / 10);
            }

        }
    }// end action press

    class SliderHandler implements ChangeListener
    {

        public void stateChanged(ChangeEvent e)
        {
            dayDisplay.setText("Days: " + daySlider.getValue() / 10);

        }// end sliderhandler
    }

}
