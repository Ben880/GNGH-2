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
    Jan 7, 2017
    GNGH_2
 */
public class GenerationMenue
{

    final int PAIRS = 10;
    JLabel[] message = new JLabel[PAIRS];
    JSlider[] slider = new JSlider[PAIRS];
    String[] preMessage = new String[PAIRS];
    GUIPallet pallet = new GUIPallet();
    boolean decided = false;
    Dimension sliderD = new Dimension(270, 35);

    public void getNumber(String action, String noun)
    {
        for (int i = 0; i < PAIRS; i++)
        {
            slider[i] = new JSlider();
            slider[i].setPreferredSize(sliderD);
            slider[i].setSnapToTicks(true);
            slider[i].setPaintTicks(true);
            slider[i].setBackground(pallet.getPanel());
            slider[i].setForeground(Color.BLACK);
            slider[i].addChangeListener((ChangeListener) new GenerationMenue.SlideHandler());
            slider[i].setMajorTickSpacing(10);
        }

        UIManager UI = new UIManager();
        UI.put("OptionPane.background", pallet.getPanel());
        UI.put("Panel.background", pallet.getPanel());

        final JComponent[] inputs = new JComponent[]
        {
            slider[0], message[0]
        };
        JOptionPane.showConfirmDialog(null, inputs, "", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

    }

    public void updateText()
    {
        for (int i = 0; i < PAIRS; i++)
        {
            message[i].setText(" " + (slider[i].getValue() / 10));
        }
    }

    class SlideHandler implements ChangeListener
    {

        @Override
        public void stateChanged(ChangeEvent e)
        {
            updateText();
        }

    }

}
