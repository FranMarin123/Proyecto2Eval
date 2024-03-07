package Model.Repo;

import Model.Task;
import Model.User;

import java.util.ArrayList;

public class TaskRepo extends Repo<Task>{


    @Override
    public Task selectAndSaveInAFile(Task selected) {
        return null;
    }

    @Override
    public Task removeFromFiles(Task selected) {
        return null;
    }

    @Override
    public Task browseOne(String id) {
        return null;
    }

    @Override
    public Task upgrade(Task userToUpgrade, String oldPassword) {
        return null;
    }

    @Override
    public ArrayList<Task> browseList() {
        return null;
    }
}
