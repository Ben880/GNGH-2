package gui.winow;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import util.GUIPallet;

/*
    BenjaminWilcox
    Dec 22, 2016
    GNGH_2
 */
public class Slider
{

    JLabel message = new JLabel();
    JSlider slider = new JSlider();
    GUIPallet pallet = new GUIPallet();
    boolean decided = false;
    Dimension sliderD = new Dimension(270, 35);
    String action;
    String noun;

    public int getNumber(String action, String noun)
    {
        this.action = action;
        this.noun = noun;
        slider.setPreferredSize(sliderD);
        slider.setSnapToTicks(true);
        slider.setPaintTicks(true);
        slider.setBackground(pallet.getPanel());
        slider.setForeground(Color.BLACK);
        slider.addChangeListener((ChangeListener) new Slider.SlideHandler());
        slider.setMajorTickSpacing(10);
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", pallet.getPanel());
        UI.put("Panel.background", pallet.getPanel());
        message.setText(action + " " + (slider.getValue() / 10) + " " + noun + "?");
        final JComponent[] inputs = new JComponent[]
        {
            slider, message
        };
        int result = JOptionPane.showConfirmDialog(null, inputs, "", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION)
        {
            System.out.println("slider amount entered: " + slider.getValue());
            return slider.getValue();
        } else
        {
            System.out.println("User canceled or closed the dialog result = " + result);
            return 0;
        }
    }

    class SlideHandler implements ChangeListener
    {

        @Override
        public void stateChanged(ChangeEvent e)
        {
            message.setText(action + " " + (slider.getValue() / 10) + " " + noun + "?");
        }

    }

}
