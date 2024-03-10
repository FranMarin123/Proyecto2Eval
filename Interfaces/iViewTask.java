package Interfaces;

import Model.Task;

import java.util.ArrayList;

public interface iViewTask {
    int menuTask();
    Task createTask();
    Task removeTask();
    void showTask(Task taskToShow);
    void listTask(ArrayList<Task> tasks);
}
