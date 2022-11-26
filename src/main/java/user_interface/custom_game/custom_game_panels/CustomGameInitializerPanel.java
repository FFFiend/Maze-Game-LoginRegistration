package user_interface.custom_game.custom_game_panels;

import adapters.custom_game.custom_game_UI_adapters.CustomGameSubmissionManager;
import adapters.custom_game.custom_game_UI_adapters.ICustomInitializerInput;
import user_interface.login_leaderboard.Panel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * UI to collect necessary information for a user start building a custom maze
 */
class CustomGameInitializerPanel extends Panel implements ICustomInitializerInput, ICustomGamePanel {
    private final JTextField nameField = new JTextField("pick a unique name for your maze");
    private static final JFrame FRAME = new JFrame("custom game initializer frame");
    private static final JPanel CONTENT = new JPanel(new BorderLayout(10, 10));

    /**
     * Displays the panel just before the editor to initialize the editing process
     */
    protected CustomGameInitializerPanel(){
        // this.build();

        // this will change once custom mazes are linked to the main game and GlobalFrame is done
        FRAME.setSize(768, 576);
        FRAME.setResizable(false);
        FRAME.setVisible(true);
        FRAME.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        CONTENT.setBorder(new EmptyBorder(10, 10, 10, 10));
        FRAME.setContentPane(CONTENT);

        displayHeader();
        displayInitializerSelectors();
        displaySubmissionButton();
    }

    /**
     * Display the initializer section title
     */
    private void displayHeader(){
        JLabel header = new JLabel("Initialize your maze", SwingConstants.CENTER);
        labelSet.add(header);
        labelFormat(labelSet);

        CONTENT.add(header, BorderLayout.PAGE_START);
    }

    /**
     * Display the choices users have to make before they can start building their maze.
     * For now, this is just the maze name
     */
    private void displayInitializerSelectors (){
        JPanel middlePanel = new JPanel(new GridLayout(3, 1));

        JLabel sizeField = new JLabel("size: 12 x 16");
        JLabel styleField = new JLabel("style: standard");

        middlePanel.add(sizeField);
        middlePanel.add(styleField);
        middlePanel.add(nameField);

        CONTENT.add(middlePanel, BorderLayout.CENTER);
    }

    /**
     * Add the submission and back buttons to the panel
     */
    private void displaySubmissionButton(){
        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));

        JButton submissionButton = new JButton("submit");
        submissionButton.addActionListener(new CustomGameSubmissionManager("CustomGameInitializerPanel", new CustomGamePresenter(), this));

        bottomPanel.add(submissionButton);
        returnToCustomMainButton(bottomPanel);

        CONTENT.add(bottomPanel, BorderLayout.PAGE_END);
    }

    /**
     * Takes the text the user put into the name text field
     *
     * @return what the user wants to name their maze
     */
    public String getMazeName(){
        return nameField.getText();
    }
}