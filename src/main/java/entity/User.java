package entity;
/* The user entity class */
public class User {
    private final String userName;
    private final String passWord;
    private int eScore;
    private int mScore;
    private int hScore;

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
        this.eScore = 0;
        this.mScore = 0;
        this.hScore = 0;
    }

    public String getPassWord() {
        return this.passWord;
    }
    public String getUserName(){
        return userName;
    }

    public void setEscore(int newScore){
        this.eScore = newScore;
    }
    public int getEscore(){
        return this.eScore;
    }

    public void setMscore(int newScore){
        this.mScore = newScore;
    }
    public int getMscore(){
        return this.mScore;
    }

    public void setHscore(int newScore){
        this.hScore = newScore;
    }
    public int getHscore(){
        return this.hScore;
    }
}
