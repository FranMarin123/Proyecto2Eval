package Interfaces;

import Model.Task;

public interface iTaskController {
    Task createTask();
    Task removeTask();
    Task[] listAllTask();
    Task showTask();
    Task upgradeTask();
}
