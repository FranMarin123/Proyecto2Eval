package Controller;

import Interfaces.iProjectController;
import Model.Project;
import Model.Repo.Repo;
import Model.User;
import View.ViewLogin;
import View.ViewProject;

public class ControllerProject implements iProjectController {
    ViewProject viewProject = new ViewProject();

    @Override
    public Project createProject() {
        Project projectToCreate = viewProject.createProject();
        Project projectTemp = Repo.getInstance().createProject(projectToCreate);

        if (projectTemp != null) {
            // Mostrar mensaje de usuario registrado
            viewProject.showMessageStartProyect();
        } else {
            // Mostrar mensaje de fallo en la creación de usuario
            viewProject.showMessageStartProyectFailed();
        }
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
}
