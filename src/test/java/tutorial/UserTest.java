package tutorial;

import entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

public class UserTest {

    @Test
    public void GetPassword(){
        User testUser = new User("Owais","1234");
        Assertions.assertEquals("1234",testUser.getPassWord());
    }


    @Test
    public void GetUsername(){
        User testUser = new User("Zahid","TorontoRaptors");
        Assertions.assertEquals("Zahid",testUser.getUserName());

    }


    @Test
    public void GetUnchangedScore(){
        User testUser = new User("Owais","1234");
        Assertions.assertEquals(0,testUser.getEscore());
        Assertions.assertEquals(0,testUser.getMscore());
        Assertions.assertEquals(0,testUser.getHscore());
    }


    @Test
    public void GetChangedScore(){
        User primeMinister = new User("Justin Trudeau", "Canada");
        primeMinister.setEscore(50);
        Assertions.assertEquals(50, primeMinister.getEscore());
    }
}
