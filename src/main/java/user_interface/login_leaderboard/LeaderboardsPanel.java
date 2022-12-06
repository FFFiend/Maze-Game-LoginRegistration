package user_interface.login_leaderboard;

import adapters.login_leaderboard.LeaderboardPresenter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Allows user to pick between the easy, medium, or hard leaderboard.
 */
public class LeaderboardsPanel extends Panel {

    /**
     * pulls data directly from filereader and displays it in a JTable inside of a Panel.
     */
    public LeaderboardsPanel(IGlobalFrameOutputBoundary ob) {
        this.build();
        this.outputBoundary = ob;

        String[] column = {"Name","Easy Score","Medium Score","Hard Score"};

        LeaderboardPresenter l = new LeaderboardPresenter();

        ArrayList<String> easies = l.getTop10Easy();
        ArrayList<String> mediums = l.getTop10Med();
        ArrayList<String> hards = l.getTop10Hard();

        ArrayList<String> users = new ArrayList<>();

        ArrayList<ArrayList<String>> data = new ArrayList<>();
        for (int i=0;i<10;i++){
            data.set(i,easies);
        }

        JTable jt = new JTable();
        jt.setBounds(0,0,480,480);
        JScrollPane sp = new JScrollPane(jt);
        this.add(sp);
    }
}

