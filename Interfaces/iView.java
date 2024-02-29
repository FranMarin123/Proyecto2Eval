package Interfaces;

import Model.Project;
import Model.Task;
import Model.User;

public interface iView {
    int selectLoginRegister();
    User register();
    User login();

    int menuProject();
    Project selectProject();
    void createProject();
    void removeProject();
    void showProject();
    void listProject();

    int menuTask();
    Task updateTask();
    void createTask();
    void removeTask();
    void showTask();
    void listTask();

}
