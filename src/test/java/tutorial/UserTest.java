package tutorial;

import entities.login_leaderboard.User;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

public class UserTest {

    @Test
    public void GetPassword(){
        User testUser = new User("Owais","1234");
        Assertions.assertEquals("1234",testUser.getPassword());
    }


    @Test
    public void GetUsername(){
        User testUser = new User("Zahid","TorontoRaptors");
        Assertions.assertEquals("Zahid",testUser.getUsername());

    }


    @Test
    public void GetUnchangedScore(){
        User testUser = new User("Owais","1234");
        Assertions.assertEquals(0,testUser.getEasyScore());
        Assertions.assertEquals(0,testUser.getMediumScore());
        Assertions.assertEquals(0,testUser.getHardScore());
    }


    @Test
    public void GetChangedScore(){
        User primeMinister = new User("Justin Trudeau", "Canada");
        primeMinister.setEasyScore(50);
        Assertions.assertEquals(50, primeMinister.getEasyScore());
    }
}
