package Interfaces;

import Model.Project;
import Model.Task;
import Model.User;

public interface iRepo {
    User createUser(User userToCreate);
    User selectUser(User selectedUser);
    User removeUser(User userToRemove);
    User showUser(String username);
    User upgradeUser(User userToUpgrade);

    Project createProject(Project projectToCreate);
    Project removeProject(String projectName);
    Project showProject(String projectName);
    Project selectProject(String projectName);
    Project[] listAllProjects();
    Project upgradeProject(Project projectToUpgrade, String originalProjectName);

    Task createTask(Task taskToCreate);
    Task removeTask(String taskName);
    Task[] listAllTask();
    Task showTask(String taskName);
    Task upgradeTask(Task taskToUpgrade,String originalTask);
}
