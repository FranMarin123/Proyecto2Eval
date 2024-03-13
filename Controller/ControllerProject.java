package Controller;

import Interfaces.iProjectController;
import Model.Project;
import Model.Repo.ProjectRepo;
import View.Utils.Utils;
import View.ViewProject;

import java.util.ArrayList;

public class ControllerProject implements iProjectController {
    ViewProject viewProject = new ViewProject();
    ProjectRepo projectRepo = new ProjectRepo();

    /**
     * Método para crear un nuevo proyecto.
     * - Obtiene la información del proyecto a través de la vista.
     * - Utiliza el repositorio para seleccionar y guardar el proyecto en un archivo.
     * - Muestra un mensaje indicando si el proyecto se ha creado correctamente o si ha ocurrido un error.
     */
    @Override
    public Project createProject() {
        Project projectToCreate = viewProject.createProject();
        Project projectTemp = projectRepo.selectAndSaveInAFile(projectToCreate);
        if (projectTemp != null) {
            Utils.printMsg("✅ Proyecto creado corretamente");
        } else {
            Utils.printMsg("❌ Error al crear el Proyecto");
        }
        return null;
    }

    /**
     * Método para eliminar un proyecto.
     * - Obtiene el proyecto a eliminar a través de la vista.
     * - Utiliza el repositorio para eliminar el proyecto del archivo.
     * - Muestra un mensaje indicando si el proyecto se ha eliminado correctamente o si ha ocurrido un error.
     */
    @Override
    public Project removeProject() {
        Project projectToDelete = viewProject.removeProject();

        Project removedProject = projectRepo.removeFromFiles(projectToDelete);

        if (removedProject != null) {
            Utils.printMsg("✅ Proyecto eliminado correctamente");
        } else {
            Utils.printMsg("❌ Fallo al eliminar el proyecto, comprueba el nombre");
        }

        return removedProject;
    }

    /**
     * Método para mostrar un proyecto.
     * - Obtiene el nombre del proyecto a mostrar a través de la vista.
     * - Utiliza el repositorio para buscar y obtener el proyecto.
     * - Muestra el proyecto si se encuentra, de lo contrario, muestra un mensaje de error.
     */
    @Override
    public void showProject() {
        String nameProject = viewProject.searchProject();
        Project projecttoshow = projectRepo.browseOne(nameProject);
        //Metodo de la vista para mostrar
        if (projecttoshow != null) {
            viewProject.showProject(projecttoshow);
        } else {
            Utils.printMsg("❌ Proyecto no encontrado");
        }
    }

    /**
     * Método para seleccionar un proyecto.
     * - Solicita al usuario que introduzca el nombre del proyecto a través de la entrada estándar.
     * - Utiliza el repositorio para seleccionar el proyecto.
     * - Muestra un mensaje indicando si el proyecto se ha seleccionado correctamente o si ha ocurrido un error.
     */
    @Override
    public void selectProject() {
        String nameProject = Utils.readString("Introduce el nombre del proyecto: ");
        if (projectRepo.selectAProject(nameProject)) {
            Utils.printMsg("✅ Se ha selecionado correctamente");
        } else {
            Utils.printMsg("❌ Ha habido un problema al seleccionar");
        }
    }

    /**
     * Método para listar todos los proyectos.
     * - Utiliza el repositorio para obtener una lista de todos los proyectos.
     * - Utiliza la vista para mostrar la lista de proyectos.
     */
    @Override
    public void listAllProjects() {
        ArrayList<Project> projects = projectRepo.browseList();
        viewProject.listProject(projects);

    }

    /**
     * Método para actualizar un proyecto.
     * - Solicita al usuario el nombre del proyecto a modificar.
     * - Utiliza la vista para obtener la información actualizada del proyecto.
     * - Utiliza el repositorio para realizar la actualización del proyecto.
     * - Muestra el proyecto actualizado.
     */
    @Override
    public void upgradeProject() {
        String oldname = Utils.readString("Nombre del proyecto a modificar: ");

        Project projectToUpgrade = viewProject.upgradeProject();

        viewProject.showProject(projectRepo.upgrade(projectToUpgrade, oldname));
    }
}

