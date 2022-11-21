package user_interface.custom_game.custom_game_panels;

import adapters.custom_game.custom_game_UI_adapters.CustomGameSubmissionManager;

import javax.swing.*;
import java.awt.*;

public class CustomGamePopup implements ICustomGamePanel{
    private final JWindow POPUP = new JWindow();
    private final JPanel PANEL = new JPanel(new BorderLayout(10, 10));
    private String panel;
    private final String MESSAGE;

        //finish building the window and panel!
    public CustomGamePopup(String message, String panel){
        this.MESSAGE = message + " Would you like to change it or go back?";
        this.panel = panel;

        drawWindow();
        popupMessage();
        popupOptions();
    }

    public CustomGamePopup(String message){
        this.MESSAGE = message;
        popupMessage();
        POPUP.add(PANEL);

        drawWindow();
        popupMessage();
    }

    private void drawWindow(){
        POPUP.setSize(300, 200);
        PANEL.setSize(300, 200);
        //POPUP.setResizable(false);
        POPUP.setVisible(true);
        PANEL.setVisible(true);
        POPUP.add(PANEL);

    }

    private void popupMessage(){
        JTextArea message = new JTextArea(this.MESSAGE);
        message.setWrapStyleWord(true);
        message.setLineWrap(true);
        message.setOpaque(false);
        message.setEditable(false);
        message.setFocusable(false);
        PANEL.add(message, BorderLayout.CENTER);
    }

    private void popupOptions(){
        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));

        JButton returnButton = new JButton("change it");
        returnButton.addActionListener(new CustomGameSubmissionManager("CustomGamePopup", new CustomGamePresenter(), panel));

        bottomPanel.add(returnButton);
        returnToCustomMainButton(bottomPanel);
        PANEL.add(bottomPanel, BorderLayout.PAGE_END);
    }
}
