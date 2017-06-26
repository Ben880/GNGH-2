package gui.main;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import player.citizens.CitizenHolder;
import player.resources.ResourceHolder;
import util.GUIPallet;

/*
    BenjaminWilcox
    Jun 10, 2017
    GNGH_2
 */
public class JobTab extends JPanel
{

    final int JOBCOUNT = 20;
    CitizenHolder citizens = new CitizenHolder();
    GUIPallet pallet = new GUIPallet();
    Border emptyBorder = BorderFactory.createEmptyBorder();
    JButton add = new JButton("train");
    JPanel headerHolder = new JPanel();
    JLabel header = new JLabel("Citizens: ??");
    JPanel left = new JPanel();
    JPanel right = new JPanel();
    JPanel content = new JPanel();
    ResourceHolder resources = new ResourceHolder();
    JobBox[] jobs = new JobBox[JOBCOUNT];

    public JobTab()
    {
        new UpdateGUI().passTab(this);
        //layout
        setLayout(new BorderLayout());
        this.setBackground(pallet.getPanel());
        this.setBorder(emptyBorder);
        header.setFont(new Font("Arial", Font.BOLD, 14));
        headerHolder.setBackground(pallet.getPanel());
        headerHolder.setBorder(emptyBorder);
        add.addActionListener(new PressEvent());
        content.setLayout(new GridLayout(1, 2));
        content.setBackground(pallet.getPanel());
        right.setBackground(pallet.getPanel());
        left.setBackground(pallet.getPanel());

        //job test
        addJobs();
        //adding
        headerHolder.add(header);
        add(headerHolder, BorderLayout.NORTH);
        add(content, BorderLayout.CENTER);
        content.add(left);
        content.add(right);
        left.add(jobs[1]);
        left.add(jobs[2]);
        right.add(jobs[3]);
        add(add, BorderLayout.SOUTH);

        update();
    }

    public void addJobs()
    {
        for (int i = 0; i < JOBCOUNT; i++)
        {
            jobs[i] = new JobBox();
        }
    }

    public void update()
    {
        header.setText("Citizens: " + citizens.getCitizen("citizen").getCount());
        for (int i = 0; i < JOBCOUNT; i++)
        {
            jobs[i].update(i);
        }
    }

    private static class PressEvent implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

}
