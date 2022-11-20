package user_interface.custom_game.custom_game_panels;

import adapters.custom_game.custom_game_UI_adapters.CustomGameSubmissionManager;
import user_interface.login_leaderboard.Panel;

import javax.swing.*;
import java.awt.*;

/**
 * UI to collect necessary information for a user start building a custom maze
 */
class CustomGameInitializerPanel extends Panel implements ICustomGamePanel {

    private static final JFrame FRAME = new JFrame("custom game initializer frame");
    public static String[] input;
    //you have to make a new class initInput for ex that works like TempMaze so you can send it to the submission manager

    /**
     * Displays the panel just before the editor to initialize the editing process
     */
    protected CustomGameInitializerPanel(){
        //        this.build();

        //every FRAME. will be replaced by this. once custom mazes are linked to the main game and the
        // following section will be removed
        FRAME.setSize(768, 576);
        FRAME.setResizable(false);
        FRAME.setVisible(true);
        FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FRAME.setLayout(new BorderLayout(10, 10));

        displayHeader();
        displayInitSelectors();
        displaySubmissionButton();
    }

    /**
     * Display the initializer section title
     */
    private void displayHeader(){
        JLabel header = new JLabel("Initialize your maze", SwingConstants.CENTER);
        labelSet.add(header);
        labelFormat(labelSet);

        FRAME.add(header, BorderLayout.PAGE_START);
    }

    /**
     * Display the choices users have to make before they can start building their maze.
     * For now, this is just the maze name
     */
    private void displayInitSelectors(){
        JPanel middlePanel = new JPanel(new GridLayout(3, 1));

        JLabel sizeField = new JLabel("size: 12 x 16");
        JLabel styleField = new JLabel("style: standard");
        JTextField nameField = new JTextField("pick a unique name for your maze");

        middlePanel.add(sizeField);
        middlePanel.add(styleField);
        middlePanel.add(nameField);

        FRAME.add(middlePanel, BorderLayout.CENTER);
    }

    /**
     * Add the submission and back buttons to the panel
     */
    private void displaySubmissionButton(){
        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));

        JButton submissionButton = new JButton("submit");
        submissionButton.addActionListener(new CustomGameSubmissionManager("CustomGameInitializerPanel", new CustomGamePresenter()));

        bottomPanel.add(submissionButton);
        returnToCustomMainButton(bottomPanel);

        FRAME.add(bottomPanel, BorderLayout.PAGE_END);
    }
}