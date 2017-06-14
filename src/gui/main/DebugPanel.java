package gui.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import util.GUIPallet;

/*
    BenjaminWilcox
    Jun 13, 2017
    GNGH_2
 */
public class DebugPanel extends JPanel
{

    boolean debug = false;
    //sub holder
    JPanel debugHolder = new JPanel();
    //buttons
    JButton debugToggle = new JButton();
    JButton calculateLand = new JButton();
    JButton setBiome = new JButton();
    JButton toggleFog = new JButton();
    //layout
    Dimension debugD = new Dimension(180, 180);
    GUIPallet pallet = new GUIPallet();

    public DebugPanel()
    {
        setPreferredSize(debugD);
        setLayout(new BorderLayout());
        setBackground(pallet.getPanel());
        debugToggle.setText("Debug");
        calculateLand.setText("Calac Land Values");
        setBiome.setText("Set Biome");
        toggleFog.setText("Toggle Fog");
        debugHolder.setSize(175, 140);
        debugHolder.setLayout(new GridLayout(5, 2));
        debugHolder.setBackground(pallet.getPanel());
        debugHolder.setVisible(false);
        debugToggle.addActionListener(new ActionPress());
        debugToggle.setActionCommand("debugToggle");
        toggleFog.addActionListener(new ActionPress());
        toggleFog.setActionCommand("toggleFog");
        setBiome.addActionListener(new ActionPress());
        setBiome.setActionCommand("setBiome");
        calculateLand.addActionListener(new ActionPress());
        calculateLand.setActionCommand("calcValues");
        //adding in order
        add(debugToggle, BorderLayout.PAGE_START);
        add(debugHolder, BorderLayout.CENTER);
        debugHolder.add(calculateLand);
        debugHolder.add(setBiome);
        debugHolder.add(toggleFog);
    }

    public void toggleDebug()
    {
        if (debug)
            debug = false;
        else
            debug = true;
        update();
    }

    public void update()
    {
        debugHolder.setVisible(debug);
        validate();
    }

    class ActionPress implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent event)
        {
            if (event.getSource() == debugToggle)
            {
                toggleDebug();
            }
            //need the rest of the buttons here
        }
    }

}
