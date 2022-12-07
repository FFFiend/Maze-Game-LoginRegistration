package user_interface.custom_game.custom_game_panels;
import adapters.custom_game.CustomGameGeneralInputHandler;
import adapters.custom_game.PlayCustom;
import entities.default_game.MazeInfo;
import user_interface.login_leaderboard.Panel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;

/**
 * Displays the game customization main menu. Allows the user to select a custom maze to play or build a new one
 */
class CustomGameMainPanel extends Panel implements ICustomGamePanel {

    private final JPanel CONTENT = new JPanel(new BorderLayout(10, 10));

    /**
     * The first panel to be displayed on entering the custom maze section. Shows a list of custom mazes and a button
     * to take the user to the maze editor
     */
    protected CustomGameMainPanel() {
        JFrame FRAME = new JFrame("custom game main frame");
        FRAME.setSize(MazeInfo.getPanelWidth(), MazeInfo.getPanelHeight());
        FRAME.setResizable(false);
        FRAME.setVisible(true);
        FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.CONTENT.setBorder(new EmptyBorder(10, 10, 10, 10));
        FRAME.setContentPane(this.CONTENT);

        displayTitle();
        listCustomMazes();
        displayCustomOptions();
    }

    /**
     * Display the custom maze section title
     */
    private void displayTitle() {
        JLabel header = new JLabel("Custom Mazes", SwingConstants.CENTER);
        labelSet.add(header);
        labelFormat(labelSet);
        setPreferredSize(new Dimension(MazeInfo.getPanelWidth(), 30));

        this.CONTENT.add(header, BorderLayout.PAGE_START);
    }

    /**
     * Display a selection of custom mazes
     */
    private void listCustomMazes() {
        JPanel mazeList = new JPanel();
        File mazeFolder = new File("custom_mazes/");
        File[] mazeFileList = mazeFolder.listFiles();
        if (mazeFileList == null) {
            throw new RuntimeException("custom_mazes folder does not exist.");
        } else {
            for (File file : mazeFileList) {
                String name = file.getName();
                JButton mazeButton = new JButton(name);
                mazeButton.addActionListener(new PlayCustom(name));
                mazeList.add(mazeButton);
            }
        }
        JScrollPane mazeListContainer = new JScrollPane(mazeList);
        setPreferredSize(new Dimension(MazeInfo.getPanelWidth(), MazeInfo.getPanelHeight() - 60));
        this.CONTENT.add(mazeListContainer, BorderLayout.CENTER);
    }

    /**
     * Display all the actions a user can take involving custom mazes. Currently, this is only creating them
     */
    private void displayCustomOptions() {
        JButton editMazeButton = new JButton("create a new maze");
        editMazeButton.addActionListener(new CustomGameGeneralInputHandler("CustomGameMainPanel", new CustomGamePresenter()));
        setPreferredSize(new Dimension(MazeInfo.getPanelWidth(), 30));
        this.CONTENT.add(editMazeButton, BorderLayout.PAGE_END);
    }
}