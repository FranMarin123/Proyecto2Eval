package Model;

import java.security.MessageDigest;

public class User {
    private String nameUser;
    private String password;
    private String gmail;
    private String name;
    private int score;

    public User(String nameUser, String password, String gmail, String name, int score) {
        this.nameUser = nameUser;
        this.password = password;
        this.gmail = gmail;
        this.name = name;
        this.score = score;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
