package Model.Repo;

import Model.Project;
import Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserSesion {
    private static UserSesion _instance;

    private User currentUser;
    private List<Project> projects;

    private UserSesion(User user) {
        currentUser=user;
        //projects = ;
    }

    public static UserSesion getInstance() {
        return _instance;
    }

    public static UserSesion getInstance(User userToUse) {
        if (_instance == null) {
            _instance = new UserSesion(userToUse);
        }
        return _instance;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public List<Project> getProjects() {
        return projects;
    }
}
