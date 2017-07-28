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
    private JSlider daySlider = new JSlider();
    private JButton dayStart = new JButton();
    private JLabel dayDisplay = new JLabel();
    private JButton plusDays = new JButton();
    private JButton minusDays = new JButton();
    //looks
    private Dimension sliderD = new Dimension(380, 35);
    private Dimension dayD = new Dimension(390, 100);
    private GUIPallet pallet = new GUIPallet();

    DayTracker dayTracker = new DayTracker();

    public DayPanel()
    {
        //day holder
        setPreferredSize(dayD);
        setBackground(pallet.getPanel());
        //Info lable
        dayDisplay.setFont(new Font("Arial", Font.PLAIN, 12));
        dayDisplay.setText("    Days: 5    ");
        dayDisplay.setBackground(pallet.getPanel());
        dayDisplay.setBorder(BorderFactory.createEmptyBorder());
        add(dayDisplay);
        //slider
        daySlider.setPreferredSize(sliderD);
        daySlider.setSnapToTicks(true);
        daySlider.setPaintTicks(true);
        daySlider.setBackground(pallet.getPanel());
        daySlider.setForeground(Color.BLACK);
        daySlider.addChangeListener(new SliderHandler());
        daySlider.setMajorTickSpacing(10);
        add(daySlider);
        //minus start plus
        minusDays.setText("-");
        minusDays.addActionListener(new ActionPress());
        minusDays.setActionCommand("minusDays");
        add(minusDays);
        dayStart.setText("Start");
        dayStart.addActionListener(new ActionPress());
        dayStart.setActionCommand("dayStart");
        add(dayStart);
        plusDays.setText("+");
        plusDays.addActionListener(new ActionPress());
        plusDays.setActionCommand("plusDays");
        add(plusDays);
    }

    public int getSliderDay()
    {
        return daySlider.getValue();
    }

    public void setSliderDay(int i)
    {
        daySlider.setValue(i);
    }

    //handles buttons
    class ActionPress implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == plusDays)
            {
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

    //handels slider changes
    class SliderHandler implements ChangeListener
    {

        public void stateChanged(ChangeEvent e)
        {
            dayDisplay.setText("Days: " + daySlider.getValue() / 10);

        }
    }// end sliderhandler

}
