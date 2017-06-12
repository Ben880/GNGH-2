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
    JSlider dayIncriment = new JSlider();
    JButton dayStart = new JButton();
    JLabel dayDisplay = new JLabel();
    JButton plusDays = new JButton();
    JButton minusDays = new JButton();
    Dimension sliderD = new Dimension(270, 35);
    Dimension dayD = new Dimension(290, 100);
    GUIPallet pallet = new GUIPallet();

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
        dayIncriment.setPreferredSize(sliderD);
        dayIncriment.setSnapToTicks(true);
        dayIncriment.setPaintTicks(true);
        dayIncriment.setBackground(pallet.getPanel());
        dayIncriment.setForeground(Color.BLACK);
        dayIncriment.addChangeListener(new SliderHandler());
        dayIncriment.setMajorTickSpacing(10);
        daysActions.add(dayIncriment);
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
        return dayIncriment.getValue();
    }

    public void setSliderDay(int i)
    {
        dayIncriment.setValue(i);
    }

    class ActionPress implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent event)
        {
            int btnNumber = -1;
            try
            {
                btnNumber = Integer.parseInt(event.getActionCommand());

            } catch (NumberFormatException e)
            {
                String source = event.getActionCommand();

            } catch (Exception e)
            {
                System.out.println("Unhandled Exception caught " + e);
                //if (debug)
                //console("Unhandled Exception caught at ActionPress " + e);
            }
        }
    }// end action press

    class SliderHandler implements ChangeListener
    {

        public void stateChanged(ChangeEvent e)
        {
            dayDisplay.setText("Days: " + dayIncriment.getValue() / 10);

        }// end sliderhandler
    }

}
