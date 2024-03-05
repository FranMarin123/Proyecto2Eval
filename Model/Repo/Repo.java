package Model.Repo;

import Interfaces.iRepo;
import Model.Project;
import Model.Task;
import Model.User;
import Serializator.Serializator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Repo implements iRepo {
    private User currentUser;
    private List<Project> projects;


    /**
     * Esta función crea un archivo que guarda un usuario en un archivo.
     * @param userToCreate Recibe el usuario que queremos guardar
     * @return Devuelve el usuario que hemos creado
     */
    @Override
    public User createUser(User userToCreate) {
        User userCreated=userToCreate;
        currentUser=userCreated;
        Serializator.serializeObject(currentUser,"./src/UserFileSaves/"+currentUser.getNameUser());
        return userCreated;
    }

    @Override
    public User selectUser(User selectedUser) {
        File userSelected=new File("./src/UserFileSaves/"+currentUser.getNameUser().toLowerCase().replaceAll(" ",""));
        User userSaved=(User) Serializator.deserializeObject(userSelected.toString());
        /*if (userSaved.comparePass(selectedUser)) {

        }*/
        return null;
    }

    @Override
    public User removeUser(User userToRemove) {
        File userFileToRemove=new File("./src/UserFileSaves/"+userToRemove.getNameUser());
        userFileToRemove.delete();
        return userToRemove;
    }

    @Override
    public User showUser(String username) {
        return (User) Serializator.deserializeObject("./src/UserFileSaves/"+username);
    }

    @Override
    public User upgradeUser(User userToUpgrade) {
        return null;
    }

    @Override
    public Project createProject(Project projectToCreate) {
        return null;
    }

    @Override
    public Project removeProject(String projectName) {
        return null;
    }

    @Override
    public Project showProject(String projectName) {
        return null;
    }

    @Override
    public Project selectProject(String projectName) {
        return null;
    }

    @Override
    public Project[] listAllProjects() {
        return new Project[0];
    }

    @Override
    public Project upgradeProject(Project projectToUpgrade, String originalProjectName) {
        return null;
    }

    @Override
    public Task createTask(Task taskToCreate) {
        return null;
    }

    @Override
    public Task removeTask(String taskName) {
        return null;
    }

    @Override
    public Task[] listAllTask() {
        return new Task[0];
    }

    @Override
    public Task showTask(String taskName) {
        return null;
    }

    @Override
    public Task upgradeTask(Task taskToUpgrade, String originalTask) {
        return null;
    }
}
