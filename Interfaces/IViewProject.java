package Interfaces;

import Model.Project;

public interface IViewProject {
    int menuProject();
    Project selectProject();
    void createProject();
    void removeProject();
    void showProject();
    void listProject();
}
