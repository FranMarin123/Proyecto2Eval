package Model.Repo;

import Model.Project;
import Model.Task;

public class SelectedProject {
    private static SelectedProject _instance;
    private Project actualProject;

    private SelectedProject(Project actualProject) {
        this.actualProject = actualProject;
    }

    public static SelectedProject get_instance() {
        return _instance;
    }

    /**
     * Este método añade un proyecto a la instancia
     * @param projectToUse Recibe el proyecto a añadir
     * @return Devuelve el proyecto añadido
     */
    public static Project addProject(Project projectToUse) {
        _instance = new SelectedProject(projectToUse);
        return _instance.actualProject;
    }

    /**
     * Devuelve el proyecto de la instancia
     * @return Devuelve el proyecto de la instancia
     */
    public Project getActualProject() {
        return actualProject;
    }

    public boolean addTaskToActualProject(Task taskToAdd) {
        boolean comp = false;
        if (!actualProject.getTasks().contains(taskToAdd)) {
            actualProject.getTasks().add(taskToAdd);
            comp = true;
            ProjectRepo.saveProject(actualProject);
        }
        return comp;
    }

    /**
     * Elimina una tarea del proyecto actual
     * @param taskToRemove Recibe la tarea a eliminar
     * @return Devuelve true si se ha borrado correctamente y false si no
     */
    public boolean removeTaskFromActualProject(Task taskToRemove) {
        boolean comp = false;
        if (actualProject.getTasks().remove(taskToRemove)) {
            comp = true;
        }
        return comp;
    }

    /**
     * Establece la instacia actual a null
     */
    public void closeProject() {
        _instance = null;
    }
}
