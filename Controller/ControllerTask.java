package Controller;

import Interfaces.iTaskController;
import Model.Project;
import Model.Repo.Repo;
import Model.Repo.TaskRepo;
import Model.Task;
import Model.User;
import View.Utils.Utils;
import View.ViewProject;
import View.ViewTask;

import java.util.ArrayList;

public class ControllerTask implements iTaskController {
    ViewTask viewTask = new ViewTask();
    TaskRepo taskRepo = new TaskRepo();

    @Override
    public void createTask() {
        Task taskcreate = viewTask.createTask();
        Task newTask = new Task(taskcreate);
        taskRepo.saveTask(newTask);
        Utils.printMsg("Tarea creada correctamente");
    }


    @Override
    public Task removeTask() {
        return null;
    }

    @Override
    public Task[] listAllTask() {
        ArrayList<Task> tasks = taskRepo.browseList();
        Task[] taskArray = tasks.toArray(new Task[0]);
        return taskArray;
    }

    @Override
    public Task showTask() {
        String usernameToShow = viewTask.showTask();
        Task existingTask = TaskRepo.showTask(usernameToShow);

        if (existingTask != null) {
            ViewTask.displayTask(existingTask);
        } else {
            Utils.printMsg("Usuario no encontrado");
        }

        return removeTask();
    }


    @Override
    public void upgradeTask() {
        Task updatedTask = viewTask.updateTask();

        if (updatedTask != null) {
            taskRepo.upgrade(updatedTask);
            Utils.printMsg("Datos de la tarea actualizados exitosamente");
        } else {
            Utils.printMsg("No se han realizado cambios en los datos del usuario");
        }
    }
}
