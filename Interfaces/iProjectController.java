package Interfaces;

import Model.Project;

public interface iProjectController {
    Project createProject();
    Project removeProject();
    Project showProject();
    Project selectProject();
    Project[] listAllProjects();
    Project upgradeProject();
}
