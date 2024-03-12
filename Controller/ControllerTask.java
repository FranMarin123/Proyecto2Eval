package Controller;

import Interfaces.iTaskController;
import Model.Repo.TaskRepo;
import Model.Task;
import View.Utils.Utils;
import View.ViewTask;

import java.util.ArrayList;

public class ControllerTask implements iTaskController {
    ViewTask viewTask = new ViewTask();
    TaskRepo taskRepo = new TaskRepo();

    /**
     * Método para crear una nueva tarea.
     * - Obtiene la información de la tarea a través de la vista.
     * - Utiliza el repositorio para seleccionar y guardar la tarea en un archivo.
     * - Muestra un mensaje indicando si la tarea se ha creado correctamente o si ha ocurrido un error.
     */
    @Override
    public void createTask() {
        Task taskcreate = viewTask.createTask();
        Task taskToCheck = taskRepo.selectAndSaveInAFile(taskcreate);
        if (taskToCheck != null) {
            Utils.printMsg("✅ Tarea creada correctamente");
        } else {
            Utils.printMsg("❌ Error al crear la tarea");
        }
    }

    /**
     * Método para eliminar una tarea.
     * - Obtiene la tarea a eliminar a través de la vista.
     * - Utiliza el repositorio para eliminar la tarea del archivo.
     * - Muestra un mensaje indicando si la tarea se ha eliminado correctamente o si ha ocurrido un error.
     * - Devuelve la tarea eliminada.
     */
    @Override
    public Task removeTask() {
        Task taskToDelete = viewTask.removeTask();

        Task removedTask = taskRepo.removeFromFiles(taskToDelete);

        if (removedTask != null) {
            Utils.printMsg("✅ Tarea eliminada correctamente");
        } else {
            Utils.printMsg("❌ Fallo al eliminar la tarea, comprueba el nombre");
        }

        return removedTask;
    }

    /**
     * Método para listar todas las tareas.
     * - Utiliza el repositorio para obtener una lista de todas las tareas.
     * - Utiliza la vista para mostrar la lista de tareas.
     */
    @Override
    public void listAllTask() {
        ArrayList<Task> tasks = taskRepo.browseList();
        viewTask.listTask(tasks);
    }

    /**
     * Método para mostrar una tarea.
     * - Solicita al usuario el nombre de la tarea a mostrar.
     * - Utiliza el repositorio para buscar y obtener la tarea.
     * - Muestra la tarea si se encuentra, de lo contrario, muestra un mensaje de error.
     */
    @Override
    public void showTask() {
        String nameTask = Utils.readString("Introduce el nombre de la tarea: ");
        Task taskToShow = taskRepo.browseOne(nameTask);
        //Metodo de la vista para mostrar
        if (taskToShow != null) {
            viewTask.showTask(taskToShow);
        } else {
            Utils.printMsg("❌ Tarea no encontrada");
        }
    }

    /**
     * Método para seleccionar una tarea.
     * - Solicita al usuario el nombre de la tarea a seleccionar.
     * - Utiliza el repositorio para seleccionar la tarea.
     * - Muestra un mensaje indicando si la tarea se ha seleccionado correctamente o si ha ocurrido un error.
     */
    @Override
    public void selectTask() {
        String nameTask = Utils.readString("Introduce el nombre de la tarea: ");
        if (taskRepo.selectTask(nameTask)) {
            Utils.printMsg("✅ Se ha selecionado correctamente");
        } else {
            Utils.printMsg("❌ Ha habido un problema al seleccionar");
        }
    }
}



