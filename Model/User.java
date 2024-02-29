package Model;

public class User {
    private String NameUser;
    private String Password;
    private String Gmail;
    private String Name;
    private int Score;

    public User(String nameUser, String password, String gmail, String name, int score) {
        NameUser = nameUser;
        Password = password;
        Gmail = gmail;
        Name = name;
        Score = score;
    }

    public String getNameUser() {
        return NameUser;
    }

    public void setNameUser(String nameUser) {
        NameUser = nameUser;
    }

    /*public String getPassword() {
        return Password;
    }*/


    public void setPassword(String password) {
        Password = password;
    }

    public String getGmail() {
        return Gmail;
    }

    public void setGmail(String gmail) {
        Gmail = gmail;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }
}
