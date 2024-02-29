package Interfaces;

import Model.Project;
import Model.Task;
import Model.User;

public interface iController {
    User createUser();
    User removeUser();
    User showUser();
    User upgradeUser();

    Project createProject();
    Project removeProject();
    Project showProject();
    Project selectProject();
    Project[] listAllProjects();
    Project upgradeProject();

    Task createTask();
    Task removeTask();
    Task[] listAllTask();
    Task showTask();
    Task upgradeTask();
}
