package Model.Repo;

import Model.Project;

import java.util.ArrayList;

public class ProjectRepo extends Repo<Project>{


    @Override
    public Project selectAndSaveInAFile(Project selected) {
        return null;
    }

    @Override
    public Project removeFromFiles(Project selected) {
        return null;
    }

    @Override
    public Project browseOne(String username) {
        return null;
    }

    @Override
    public Project upgrade(Project userToUpgrade, String oldPassword) {
        return null;
    }

    @Override
    public ArrayList<Project> browseList() {
        return null;
    }
}
