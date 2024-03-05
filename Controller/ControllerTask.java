package Controller;

import Interfaces.iTaskController;
import Model.Task;

public class ControllerTask implements iTaskController {
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
