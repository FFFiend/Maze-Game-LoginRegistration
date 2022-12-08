package Login_Register_leaderboard;

import adapters.login_leaderboard.UsersCreation;
import frameworks_and_drivers.login_leaderboard.FileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.login_leaderboard.FileUser;
import use_cases.login_leaderboard.IFileInputtBoundary;

public class LeaderboardTest {

    @Test
    public void FileUserTest() {
        IFileInputtBoundary prevUsers = new FileReader();
        FileUser users = new FileUser(prevUsers);

        Assertions.assertTrue(users.prevUsers().containsKey("Arifa"));
        Assertions.assertTrue(users.prevUsers().containsKey("Leo"));
        Assertions.assertTrue(users.prevUsers().containsKey("Rene"));
    }

    @Test
    public void LeaderboardGeneratorTest(){
        UsersCreation create = new UsersCreation();
        FileReader prevUsers = new FileReader();
        create.saveUsers(prevUsers.readFile());

    }

}
