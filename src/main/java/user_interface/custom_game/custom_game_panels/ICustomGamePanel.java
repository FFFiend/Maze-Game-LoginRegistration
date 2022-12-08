package user_interface.custom_game.custom_game_panels;

import adapters.custom_game.CustomGameGeneralInputHandler;

import javax.swing.*;
import java.awt.*;

/**
 * Common UI methods for the custom game section
 */
interface ICustomGamePanel {

    /**
     * Draws a button on the panel that returns the user to the custom game main menu
     */
    default void returnToCustomMainButton(JComponent component) {
        JButton backButton = new JButton("go back to main");
        backButton.addActionListener(new CustomGameGeneralInputHandler("toCustomMain", new CustomGamePresenter()));
        backButton.setPreferredSize(new Dimension(50, 30));
        component.add(backButton);
    }

    /**
     * @return the background colour for the custom maze section
     */
    default Color getBackgroundColor() {
        return new Color(0, 0, 0);
    }
}
