package Controller;

import Interfaces.iProjectController;
import Model.Project;
import Model.Repo.Repo;
import View.Utils.Utils;
import View.ViewProject;
import View.ViewUser;

public class ControllerProject implements iProjectController {
    ViewProject viewProject = new ViewProject();
    ViewUser viewUser = new ViewUser();
    userRepo repo = new UserRepo();


    @Override
    public Project createProject() {
        Project projectToCreate = viewProject.createProject();
        Project projectTemp = Repo.getInstance().createProject(projectToCreate);

        if (projectTemp != null) {
            Utils.printMsg("Proyecto creado corretamente");
        } else {
            Utils.printMsg("Error al crear el Proyecto");
        }
        return null;
    }


    @Override
    public Project removeProject() {
        String userNameToDelete = viewUser.removeUser();

        Project removedProject = repo.removeProject(userNameToDelete);

        if (removedProject != null) {
            Utils.printMsg("Usuario eliminado correctamente");
        } else {
            Utils.printMsg("Fallo al eliminar el usuario, comprueba el nombre");
        }

        return removedProject;
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
}
