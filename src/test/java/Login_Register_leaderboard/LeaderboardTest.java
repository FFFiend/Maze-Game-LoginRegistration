package Login_Register_leaderboard;

import adapters.login_leaderboard.LeaderboardPresenter;
import entities.login_leaderboard.User;
import frameworks_and_drivers.login_leaderboard.FileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.login_leaderboard.FileUser;
import use_cases.login_leaderboard.IFileInputBoundary;
import use_cases.login_leaderboard.LeaderboardGenerator;

import java.util.ArrayList;
import java.util.HashMap;

public class LeaderboardTest {
    private final LeaderboardGenerator generateTop10 = new LeaderboardGenerator();
    private final User user1 = new User("Tod", "Tod.93", "a@gmail.com");
    private final User user2 = new User("Bob", "Bob.93", "b@gmail.com");
    HashMap<String, User> MAP = new HashMap<>();


    /**
     * Test that file user creates a hashmap of users from the CSV file.
     */
    @Test
    public void FileUserTest() {
        IFileInputBoundary prevUsers = new FileReader();
        FileUser users = new FileUser(prevUsers);

        Assertions.assertTrue(users.prevUsers().containsKey("Arifa"));
        Assertions.assertTrue(users.prevUsers().containsKey("Leo"));
        Assertions.assertTrue(users.prevUsers().containsKey("Rene"));
    }

    /**
     * Test Leaderboard generator generates a sorted list of user in descending order.
     * Easy Scores
     */
    @Test
    public void LeaderboardGeneratorTestEasy(){
        user1.setEasyScore(10);
        user2.setEasyScore(50);

        MAP.put(user1.getUsername(), user1);
        MAP.put(user2.getUsername(), user2);

        generateTop10.setUsers(MAP);

        ArrayList<String> sortEasy = new ArrayList<>();
        sortEasy.add("Bob 50");
        sortEasy.add("Tod 10");

        Assertions.assertEquals(sortEasy, generateTop10.sortEasy());
    }

    /**
     * Test Leaderboard generator generates a sorted list of user in descending order.
     * Medium Scores
     */
    @Test
    public void LeaderboardGeneratorTestMed(){
        user1.setMediumScore(22);
        user2.setMediumScore(33);

        MAP.put(user1.getUsername(), user1);
        MAP.put(user2.getUsername(), user2);

        generateTop10.setUsers(MAP);

        ArrayList<String> sortEasy = new ArrayList<>();
        sortEasy.add("Bob 33");
        sortEasy.add("Tod 22");

        Assertions.assertEquals(sortEasy, generateTop10.sortMedium());
    }

    /**
     * Test Leaderboard generator generates a sorted list of user in descending order.
     * Hard Scores
     */
    @Test
    public void LeaderboardGeneratorTestHard(){
        user1.setHardScore(22);
        user2.setHardScore(33);

        MAP.put(user1.getUsername(), user1);
        MAP.put(user2.getUsername(), user2);

        generateTop10.setUsers(MAP);

        ArrayList<String> sortEasy = new ArrayList<>();
        sortEasy.add("Bob 33");
        sortEasy.add("Tod 22");

        Assertions.assertEquals(sortEasy, generateTop10.sortHard());
    }

    /**
     * Test that each sorted string contains username and score.
     */
    @Test
    public void LeaderboardPresenterTest(){
        LeaderboardPresenter presenter = new LeaderboardPresenter();
        presenter.setScores(FileReader.create());

        Object[] userInfo = presenter.getTop10Easy().get(0).split(" ");
        Assertions.assertEquals(2, userInfo.length);
    }
}
