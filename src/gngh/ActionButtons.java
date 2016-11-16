package gngh;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
       //  Author: Benjamin Wilcox
       //  Project GNGH
 */
public class ActionButtons extends JPanel
{

    //singleton declarations
    ActionHandler action;
    GUIHandler gui;
    //Left panel
    JPanel leftCol = new JPanel();
    JPanel leftInner = new JPanel();
    JButton[] actionButton = new JButton[40];
    JLabel actionsLabel = new JLabel("Actions");
    //Days Actions
    JPanel daysActions = new JPanel();
    JSlider dayIncriment = new JSlider();
    JButton dayStart = new JButton();
    JLabel dayDisplay = new JLabel();
    JButton plusDays = new JButton();
    JButton minusDays = new JButton();
    //Debug
    boolean debug = false;
    boolean dispFog = true;
    JPanel debugActions = new JPanel();
    JPanel debugHolder = new JPanel();
    JButton debugToggle = new JButton();
    JButton calculateLand = new JButton();
    JButton setBiome = new JButton();
    JButton toggleFog = new JButton();
    //distasteful palet here
    Color myGrey = new Color(225, 225, 225);
    Color background = new Color(100, 100, 100);
    Color panel = new Color(170, 170, 170);
    Color forest = new Color(0, 100, 0);
    Color desert = new Color(255, 209, 114);
    Dimension sideD = new Dimension(300, 15);
    Dimension rightSideD = new Dimension(290, 610);
    Dimension leftSideD = new Dimension(290, 460);
    Dimension debugInfoD = new Dimension(290, 150);
    Dimension sliderD = new Dimension(270, 35);
    Dimension debugD = new Dimension(290, 180);
    Dimension dayD = new Dimension(290, 100);

    public ActionButtons()
    {
        gui = GUIHandler.getInstance();
        action = ActionHandler.getInstance();
        setLayout(new BorderLayout());
        //main holder
        leftCol.setPreferredSize(sideD);
        leftCol.setBackground(background);
        add(leftCol, BorderLayout.LINE_START);
        //main heading
        actionsLabel.setFont(new Font("Arial", Font.BOLD, 20));
        leftCol.add(actionsLabel);
        //sub holder
        leftInner.setPreferredSize(leftSideD);
        leftInner.setBackground(panel);
        leftInner.setLayout(new GridLayout(20, 2));
        leftCol.add(leftInner);
        //buttons
        int i = 0;
        while (i < 40)
        {
            actionButton[i] = new JButton();
            actionButton[i].setBackground(panel);
            actionButton[i].setBorder(BorderFactory.createLineBorder(background, 1));
            actionButton[i].setFont(new Font("Arial", Font.PLAIN, 12));
            actionButton[i].setText("" + i);
            actionButton[i].addActionListener(new ActionButtons.ActionPress());
            actionButton[i].setActionCommand(String.valueOf(i));
            leftInner.add(actionButton[i]);
            actionButton[i].setText(gui.label().getButtonText(i));
            i++;
        }

        //Day stuff
        //day holder
        daysActions.setPreferredSize(dayD);
        daysActions.setBackground(panel);
        leftCol.add(daysActions);
        //Info lable
        dayDisplay.setFont(new Font("Arial", Font.PLAIN, 12));
        dayDisplay.setText("    Days: 5    ");
        dayDisplay.setBackground(panel);
        dayDisplay.setBorder(BorderFactory.createEmptyBorder());
        daysActions.add(dayDisplay);
        //slider
        dayIncriment.setPreferredSize(sliderD);
        dayIncriment.setSnapToTicks(true);
        dayIncriment.setPaintTicks(true);
        dayIncriment.setBackground(panel);
        dayIncriment.setForeground(Color.BLACK);
        dayIncriment.addChangeListener((ChangeListener) new ActionButtons.SliderHandler());
        dayIncriment.setMajorTickSpacing(10);
        daysActions.add(dayIncriment);
        //minus start plus
        minusDays.setText("-");
        minusDays.addActionListener(new ActionButtons.ActionPress());
        minusDays.setActionCommand("minusDays");
        daysActions.add(minusDays);
        dayStart.setText("Start");
        dayStart.addActionListener(new ActionButtons.ActionPress());
        dayStart.setActionCommand("dayStart");
        daysActions.add(dayStart);
        plusDays.setText("+");
        plusDays.addActionListener(new ActionButtons.ActionPress());
        plusDays.setActionCommand("plusDays");
        daysActions.add(plusDays);
        //Debug Actions
        debugActions.setPreferredSize(debugD);
        debugActions.setLayout(new BorderLayout());
        debugActions.setBackground(panel);
        debugToggle.setText("Debug");
        calculateLand.setText("Calac Land Values");
        setBiome.setText("Set Biome");
        toggleFog.setText("Toggle Fog");
        debugHolder.setSize(280, 140);
        debugHolder.setLayout(new GridLayout(5, 2));
        debugHolder.setBackground(panel);
        debugHolder.add(calculateLand);
        debugHolder.add(setBiome);
        debugHolder.add(toggleFog);
        debugActions.add(debugToggle, BorderLayout.PAGE_START);
        debugActions.add(debugHolder, BorderLayout.CENTER);
        leftCol.add(debugActions);
        debugHolder.setVisible(false);
        debugToggle.addActionListener(new ActionButtons.ActionPress());
        debugToggle.setActionCommand("debugToggle");
        toggleFog.addActionListener(new ActionButtons.ActionPress());
        toggleFog.setActionCommand("toggleFog");
        setBiome.addActionListener(new ActionButtons.ActionPress());
        setBiome.setActionCommand("setBiome");
        calculateLand.addActionListener(new ActionButtons.ActionPress());
        calculateLand.setActionCommand("calcValues");
        add(leftCol, BorderLayout.CENTER);
    }

    public void setVisible(int i, boolean b)
    {
        actionButton[i].setVisible(b);
    }

    public void toggleDebug(boolean b)
    {
        debugHolder.setVisible(b);
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
                action.button.actionClick(btnNumber);
            } catch (NumberFormatException e)
            {
                String source = event.getActionCommand();
                action.button.actionClick(source);
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
        }
    }// end sliderhandler
}
