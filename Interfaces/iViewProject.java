package Interfaces;

import Model.Project;

import java.util.List;

public interface iViewProject {
    int menuProject();
    Project showProject(Project projecttoshow);
    Project listProject(List<Project> projects);
    Project createProject();
    Project removeProject();
    Project upgradeProject();
}
