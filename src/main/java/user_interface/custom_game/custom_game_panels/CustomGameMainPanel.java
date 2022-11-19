package user_interface.custom_game.custom_game_panels;
import adapters.custom_game.custom_game_UI_adapters.CustomGameSubmissionManager;
import user_interface.login_leaderboard.Panel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

class CustomGameMainPanel extends Panel implements ICustomGamePanel {
    private final JFrame FRAME = new JFrame("custom main frame");

    /**
     * The first panel to be displayed on entering the custom maze section. Shows a list of custom mazes and a button
     * to take the user to the maze editor
     */
    protected CustomGameMainPanel (){
        //        this.build();

        //every this.tempMainFrame will be replaced by this once custom mazes are linked to the main game and the
        // following section will be removed
        this.FRAME.setSize(768, 576);
        this.FRAME.setResizable(false);
        this.FRAME.setVisible(true);
        this.FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.FRAME.setLayout(new BorderLayout(10, 10));

        this.FRAME.add(new JLabel("Custom Mazes"), BorderLayout.PAGE_START);

        listCustomMazes();
        displayCustomOptions();

    }

    /**
     * Display a selection of custom mazes and a search bar
     */
    public void listCustomMazes(){
        ArrayList<String> mazeList = getMazes();
        JList<String> mazeListElement = new JList(mazeList.toArray());
        mazeListElement.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        mazeListElement.setLayoutOrientation(JList.VERTICAL_WRAP);
        mazeListElement.setVisibleRowCount(-1);

        JScrollPane mazeListScroller = new JScrollPane(mazeListElement);
        mazeListScroller.setPreferredSize(new Dimension(250, 80));
        this.FRAME.add(mazeListElement, BorderLayout.CENTER);
    }

    /**
     * Retrieve all stored custom mazes and sort them alphabetically
     * @return an ArrayList of all the stored custom mazes
     */
    private ArrayList<String> getMazes(){
        File mazeFolder = new File("customMazes/");
        File[] mazeFileList = mazeFolder.listFiles();
        ArrayList<String> mazeList = new ArrayList<>();

        assert mazeFileList != null;
        for (File file : mazeFileList) {
            mazeList.add(file.getName());
        }
        mazeList.sort(String.CASE_INSENSITIVE_ORDER);
        return mazeList;
    }

    /**
     * Display all the actions a user can take involving custom mazes
     * Currently, this is only creating them
     */
    public void displayCustomOptions(){
        JButton editMazeButton = new JButton("create a new maze");
        editMazeButton.addActionListener(new CustomGameSubmissionManager("CustomGameMainPanel", new CustomGamePresenter()));
        this.FRAME.add(editMazeButton, BorderLayout.PAGE_END);

    }
}