package Interfaces;

import Model.Task;

public interface iViewTask {
    int menuTask();
    Task updateTask();
    Task createTask();
    void removeTask();
    void showTask();
    void listTask();
}
