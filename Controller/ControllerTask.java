package Controller;

import Interfaces.iTaskController;
import Model.Project;
import Model.Repo.Repo;
import Model.Task;
import View.Utils.Utils;
import View.ViewProject;
import View.ViewTask;

public class ControllerTask implements iTaskController {
    ViewTask viewTask = new ViewTask();

    @Override
    public Task createTask() {
        /*Task taskToCreate = viewTask.createTask();
        Task taskTemp = Repo.getInstance().createTask(taskToCreate);

        if (taskTemp != null) {
            // Mostrar mensaje de usuario registrado
           viewTask.showMessageStartTask();

        } else {
            // Mostrar mensaje de fallo en la creación de usuario
            viewTask.showMessageStartTaskFailed();
        }*/
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
