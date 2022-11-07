package userentity;

public class User {
    private final String name;
    private final String password;
    private int escore;
    private int mscore;
    private int hscore;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.escore = 0;
        this.mscore = 0;
        this.hscore = 0;
    }
    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }

    public int setEasyScore(int score){
        return this.escore = score;
    }

    public int getEasyScore(){
        return this.escore;
    }


    public int setMediumScore(int score){
        return this.mscore = score;
    }
    public int getMediumScore(){
        return this.mscore;
    }

    public int setHardScore(int score){
        return this.hscore = score;
    }
    public int getHardScore(){
        return this.hscore;
    }
}
