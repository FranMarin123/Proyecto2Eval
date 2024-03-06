package Interfaces;

import Model.Task;

public interface IViewTask {
    int menuTask();
    Task updateTask();
    void createTask();
    void removeTask();
    void showTask();
    void listTask();
}
