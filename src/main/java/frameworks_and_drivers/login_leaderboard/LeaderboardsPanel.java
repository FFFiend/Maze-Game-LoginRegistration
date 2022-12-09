package frameworks_and_drivers.login_leaderboard;

import adapters.login_leaderboard.LeaderboardPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Allows user to view the easy, medium, and hard leaderboard.
 */
public class LeaderboardsPanel extends Panel implements ActionListener {
    JTable EasyTable;
    JTable MedTable;
    JTable HardTable;

    /**
     * Constructs the leaderboard panel.
     */
    public LeaderboardsPanel(IGlobalFrameOutputBoundary ob){
        this.build();
        this.outputBoundary = ob;

        setLayout(new FlowLayout());

        createEasyTable();
        createMedTable();
        createHardTable();

        JScrollPane sp1 = new JScrollPane(EasyTable);
        add(sp1);
        sp1.setVisible(true);
        this.add(sp1);

        JScrollPane sp2 = new JScrollPane(MedTable);
        add(sp2);
        sp2.setVisible(true);
        this.add(sp2);

        JScrollPane sp3 = new JScrollPane(HardTable);
        add(sp3);
        sp3.setVisible(true);
        this.add(sp3);

        JButton re = new JButton("Welcome Screen");
        re.setBounds(485,505,300,30);
        re.setSize(245,30);
        re.addActionListener(this);
        re.setActionCommand("wipe out");
        this.add(re);
    }

    /**
     * Create object[][] objects for each of the levels. The lists store
     * the username and scores.
     */
    private ArrayList<Object[][]> scores(){
        LeaderboardPresenter presenter = new LeaderboardPresenter();

        presenter.setScores(FileReader.create());

        ArrayList<Object[][]> data = new ArrayList<>();

        Object[][] medData = new Object[10][2];
        Object[][] easyData = new Object[10][2];
        Object[][] hardData = new Object[10][2];

        ArrayList<String> easyScores = presenter.getTop10Easy();
        ArrayList<String> medScores = presenter.getTop10Med();
        ArrayList<String> hardScores = presenter.getTop10Hard();

        for (int i = 0; i < 10; i ++){
            if (easyScores.size() > i) {
                Object[] userInfo = easyScores.get(i).split(" ");
                easyData[i] = userInfo;
            }
            if (medScores.size() > i) {
                Object[] userInfo = medScores.get(i).split(" ");
                medData[i] = userInfo;
            }
            if (hardScores.size() > i) {
                Object[] userInfo = hardScores.get(i).split(" ");
                hardData[i] = userInfo;
            }
        }

        data.add(easyData);
        data.add(medData);
        data.add(hardData);

        return data;
    }

    /**
     * Create the JTable for the easy-level scores.
     */
    private void createEasyTable(){
        String[] columnTitles = {"Player", "Easy-Level Stamina"};

        Object[][] data = scores().get(0);

        EasyTable = new JTable(data, columnTitles);
        EasyTable.setPreferredScrollableViewportSize(new Dimension(300, 150));
        EasyTable.setFillsViewportHeight(true);
        EasyTable.setBounds(240,100,50,50);

        EasyTable.setDefaultEditor(Object.class, null);
        EasyTable.setBackground(Color.BLACK);
        EasyTable.setForeground(Color.WHITE);
        EasyTable.setFont(new Font("Arial", Font.BOLD, 16));

        EasyTable.setShowGrid(false);
    }

    /**
     * Create the JTable for the medium-level scores.
     */
    private void createMedTable(){
        String[] columnTitles = {"Player", "Medium-Level Stamina"};

        MedTable = new JTable(scores().get(1), columnTitles);
        MedTable.setPreferredScrollableViewportSize(new Dimension(300, 150));
        MedTable.setFillsViewportHeight(true);
        MedTable.setBounds(240,250,50,50);


        MedTable.setDefaultEditor(Object.class, null);
        MedTable.setBackground(Color.BLACK);
        MedTable.setForeground(Color.WHITE);
        MedTable.setFont(new Font("Arial", Font.BOLD, 16));

        MedTable.setShowGrid(false);
    }

    /**
     * Create the JTable for the hard-level scores.
     */
    private void createHardTable(){
        String[] columnTitles = {"Player", "Hard-Level Stamina"};

        Object[][] data = scores().get(2);

        HardTable = new JTable(data, columnTitles);
        HardTable.setPreferredScrollableViewportSize(new Dimension(300, 150));
        HardTable.setFillsViewportHeight(true);

        HardTable.setDefaultEditor(Object.class, null);
        HardTable.setBackground(Color.BLACK);
        HardTable.setForeground(Color.WHITE);
        HardTable.setFont(new Font("Arial", Font.BOLD, 16));

        HardTable.setShowGrid(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        outputBoundary.getCurrPanel(this);
        outputBoundary.changePanelTo(e.getActionCommand());
    }
}