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


    @Override
    public Project createProject() {
        Project projectToCreate = viewProject.createProject();
        Project projectTemp = projectRepo.selectAndSaveInAFile(projectToCreate);

        if (projectTemp != null) {
            Utils.printMsg("Proyecto creado corretamente");
        } else {
            Utils.printMsg("Error al crear el Proyecto");
        }
        return null;
    }


    @Override
    public Project removeProject() {
        String userNameToDelete = viewProject.removeProject();

        Project removedProject = projectRepo.removeFromFiles(userNameToDelete);

        if (removedProject != null) {
            Utils.printMsg("Usuario eliminado correctamente");
        } else {
            Utils.printMsg("Fallo al eliminar el usuario, comprueba el nombre");
        }

        return removedProject;
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
        ArrayList<Project> projects = projectRepo.browseList();
        Project[] projectArray = projects.toArray(new Project[0]);

        return projectArray;    }

    @Override
    public Project upgradeProject() {
// Solicitar al usuario el nombre de proyecto y la nueva contraseña
        Project projectToUpgrade = viewProject.displayProjectUpgrade();
        String oldPassword = viewProject.displayOldPassword();

        // Actualizar el proyecto existente en el repositorio
        return projectRepo.upgrade(projectToUpgrade, oldPassword);
    }
}

