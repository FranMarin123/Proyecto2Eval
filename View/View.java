package View;

import Interfaces.iView;
import Model.Project;
import Model.Task;
import Model.User;

public abstract class View implements iView {
    @Override
    public int selectLoginRegister() {
        return 0;
    }

    @Override
    public User register() {
        return null;
    }

    @Override
    public User login() {
        return null;
    }

    @Override
    public int menuProject() {
        return 0;
    }

    @Override
    public Project selectProject() {
        return null;
    }

    @Override
    public void createProject() {

    }

    @Override
    public void removeProject() {

    }

    @Override
    public void showProject() {

    }

    @Override
    public void listProject() {

    }

    @Override
    public int menuTask() {
        return 0;
    }

    @Override
    public Task updateTask() {
        return null;
    }

    @Override
    public void createTask() {

    }


    @Override
    public void removeTask() {

    }

    @Override
    public void showTask() {

    }

    @Override
    public void listTask() {

    }
}
