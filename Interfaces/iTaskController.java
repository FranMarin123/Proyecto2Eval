package Interfaces;

import Model.Task;

public interface iTaskController {
    void createTask();
    Task removeTask();
    Task[] listAllTask();
    Task showTask();
    void upgradeTask();
}
