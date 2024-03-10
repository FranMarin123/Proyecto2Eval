package Model.Repo;

import Model.Project;
import Model.Task;
import Model.User;
import Serializator.Serializator;

import java.io.File;
import java.util.ArrayList;

public class TaskRepo extends Repo<Task>{


    @Override
    public Task selectAndSaveInAFile(Task selected) {
        File taskFile=new File("./src/TaskFileSaves/"+selected.getName());
        Task taskToReturn=(Task) Serializator.deserializeObject(taskFile.toString());
        if (!taskFile.exists()){
            Serializator.serializeObject(selected,taskFile.toString());
            SelectedProject.get_instance().addTaskToActualProject(selected);
        } else if (!SelectedProject.get_instance().addTaskToActualProject(taskToReturn)) {
            taskToReturn=null;
        }
        return taskToReturn;
    }

    @Override
    public Task removeFromFiles(Task selected) {
        File taskFile=new File("./src/TaskFileSaves/"+selected.getName());
        Task taskToCheck=(Task) Serializator.deserializeObject(taskFile.toString());
        if (taskFile.exists() && SelectedProject.get_instance().getActualProject().getTasks().contains(taskToCheck)){
            taskFile.delete();
        }else {
            taskToCheck=null;
        }
        return taskToCheck;
    }

    @Override
    public Task browseOne(String id) {
        return (Task) Serializator.deserializeObject("./src/TaskFileSaves/"+id);
    }

    @Override
    public Task upgrade(Task userToUpgrade, String oldPassword) {
        return null;
    }

    @Override
    public ArrayList<Task> browseList() {
        return (ArrayList<Task>) SelectedProject.get_instance().getActualProject().getTasks();
    }

    public static boolean saveTask(Task taskToSave){
        return Serializator.serializeObject(taskToSave,"./src/TaskFileSaves/"+taskToSave.getName());
    }
}
