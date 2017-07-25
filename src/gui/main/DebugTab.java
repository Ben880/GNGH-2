package gui.main;

import gui.BackEnd.DebugHandler;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import util.GUIPallet;
import util.debug.DebugInfo;

/*
    BenjaminWilcox
    Jul 24, 2017
    GNGH2
 */
public class DebugTab extends JPanel
{

    private ArrayList<JButton> buttons = new ArrayList();
    private DebugHandler debugHandler = new DebugHandler();
    private final int BUTTONCOUNT = 60;
    private GUIPallet pallet = new GUIPallet();
    private Border emptyBorder = BorderFactory.createEmptyBorder();
    private JPanel headerHolder = new JPanel();
    private JLabel header = new JLabel("Debug");
    private JPanel content = new JPanel();
    private DebugInfo debugInfo = new DebugInfo();

    public DebugTab()
    {
        this.setBackground(pallet.getPanel());
        this.setBorder(emptyBorder);
        this.setLayout(new BorderLayout());
        header.setFont(new Font("Arial", Font.BOLD, 14));
        headerHolder.setBackground(pallet.getPanel());
        headerHolder.setBorder(emptyBorder);
        content.setLayout(new GridLayout(20, 3));
        content.setBackground(pallet.getPanel());
        new UpdateGUI().passTab(this);
        //button loop
        for (int i = 0; i < BUTTONCOUNT; i++)
        {
            buttons.add(new JButton("default"));
            content.add(buttons.get(i));
            buttons.get(i).addActionListener(new PressEvent());
        }
        //naming buttons
        buttons.get(0).setText("Toggle Fog");
        //adding
        headerHolder.add(header);
        add(headerHolder, BorderLayout.NORTH);
        add(content, BorderLayout.CENTER);
    }

    public void update()
    {
        setButtonsVisible(debugInfo.getDebug());
    }

    private void setButtonsVisible(boolean bool)
    {
        for (int i = 0; i < BUTTONCOUNT; i++)
        {
            buttons.get(i).setVisible(bool);
            validate();
        }
    }

    private class PressEvent implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {

            JButton temp = (JButton) e.getSource();

            debugHandler.buttonPress(temp.getText());
        }
    }

}
