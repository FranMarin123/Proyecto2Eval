package Controller;

import Interfaces.iController;
import Model.Project;
import Model.Task;
import Model.User;

public class Controller implements iController {

    @Override
    public User createUser() {
        return null;
    }

    @Override
    public User removeUser() {
        return null;
    }

    @Override
    public User showUser() {
        return null;
    }

    @Override
    public User upgradeUser() {
        return null;
    }

    @Override
    public Project createProject() {
        return null;
    }

    @Override
    public Project removeProject() {
        return null;
    }

    @Override
    public Project showProject() {
        return null;
    }

    @Override
    public Project selectProject() {
        return null;
    }

    @Override
    public Project[] listAllProjects() {
        return new Project[0];
    }

    @Override
    public Project upgradeProject() {
        return null;
    }

    @Override
    public Task createTask() {
        return null;
    }

    @Override
    public Task removeTask() {
        return null;
    }

    @Override
    public Task[] listAllTask() {
        return new Task[0];
    }

    @Override
    public Task showTask() {
        return null;
    }

    @Override
    public Task upgradeTask() {
        return null;
    }
}
