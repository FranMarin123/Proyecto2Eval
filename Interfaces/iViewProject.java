package Interfaces;

import Model.Project;

public interface iViewProject {
    int menuProject();
    Project listProject();
    Project createProject();
    void removeProject();
    String enterProject();
    void modifyProject();
}
