package Model.Repo;

import Interfaces.iRepo;
import Model.Project;
import Serializator.Serializator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class Repo<T> implements iRepo<T> {


    public abstract T selectAndSaveInAFile(T selected);
    public abstract T removeFromFiles(T selected);
    public abstract T browseOne(String id);
    public abstract T upgrade(T userToUpgrade, String name);
    public abstract ArrayList<T> browseList();
}
