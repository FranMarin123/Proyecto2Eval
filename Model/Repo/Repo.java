package Model.Repo;

import Interfaces.iRepo;
import Model.Project;
import Model.Task;
import Model.User;

import java.util.ArrayList;
import java.util.List;

public class Repo implements iRepo {
    private User currentUser;
    private List<Project> projects;


    @Override
    public User createUser(User userToCreate) {
        //currentUser=new
    }

    @Override
    public User removeUser(User userToRemove) {
        return null;
    }

    @Override
    public User showUser(String username) {
        return null;
    }

    @Override
    public User upgradeUser(User userToUpgrade) {
        return null;
    }

    @Override
    public Project createProject(Project projectToCreate) {
        return null;
    }

    @Override
    public Project removeProject(String projectName) {
        return null;
    }

    @Override
    public Project showProject(String projectName) {
        return null;
    }

    @Override
    public Project selectProject(String projectName) {
        return null;
    }

    @Override
    public Project[] listAllProjects() {
        return new Project[0];
    }

    @Override
    public Project upgradeProject(Project projectToUpgrade, String originalProjectName) {
        return null;
    }

    @Override
    public Task createTask(Task taskToCreate) {
        return null;
    }

    @Override
    public Task removeTask(String taskName) {
        return null;
    }

    @Override
    public Task[] listAllTask() {
        return new Task[0];
    }

    @Override
    public Task showTask(String taskName) {
        return null;
    }

    @Override
    public Task upgradeTask(Task taskToUpgrade, String originalTask) {
        return null;
    }
}
