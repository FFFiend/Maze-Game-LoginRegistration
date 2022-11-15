package user_interface.custom_game.custom_game_screens;

import javax.swing.*;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;

public class CustomGameEditorGrid extends JFrame {

    public static void main(String[] args) {
        int rows = 2;
        int cols = 3;
        CustomGameEditorGrid grid = new CustomGameEditorGrid(rows, cols);
        grid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        grid.pack();
        grid.setVisible(true);
    }

    public CustomGameEditorGrid(int rows, int cols) {
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(rows, cols));
        for (int i = 0; i < 20; i++) {
            JButton button = new JButton(Integer.toString(i + 1));
            pane.add(button);
        }
    }
}
