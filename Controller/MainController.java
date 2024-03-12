package Controller;


import Model.Repo.SelectedTask;
import Model.Repo.TaskRepo;
import View.*;
import Enum.Estado;
import View.Utils.Utils;

public class MainController {
    ControllerLogin controllerLogin = new ControllerLogin();
    ControllerProject controllerProject = new ControllerProject();
    ControllerTask controllerTask = new ControllerTask();
    ControllerUser controllerUser = new ControllerUser();
    View view = new View();

    public void loginMainMenuSelection() {
        view.showMessageWelcome();
        MainMenu mainMenu = new MainMenu();
        int userInput;
        boolean comp = false;
        userInput = mainMenu.displayMainMenu();
        switch (userInput) {
            case 1:
                // Lógica para registrar un usuario
                comp = controllerLogin.createUser();
                break;
            case 2:
                // Lógica para iniciar sesión de un usuario
                comp = controllerLogin.selectUser();
                break;
            case 3:
                System.exit(0);
                view.showMessageGoodBye();
                break;
            default:
                throw new IllegalStateException("Opción inválida: " + userInput);
        }
        if (comp) {
            menu();
        }
    }

    public void menu() {
        ViewProject viewProject = new ViewProject();
        int userInput;
        userInput = viewProject.menuProject();
        switch (userInput) {
            case 1:
                // Lógica para buscar un proyecto
                controllerProject.showProject();
                break;
            case 2:
                // Lógica para mostrar proyectos
                controllerProject.listAllProjects();
                break;
            case 3:
                // Lógica para crear proyectos
                controllerProject.createProject();
            case 4:
                // Lógica para eliminar proyectos
                controllerProject.removeProject();
                break;
            case 5:
                // Lógica para entrar en un proyecto
                controllerProject.selectProject();
                break;
            case 6:
                // Lógica para actualizar un proyecto
                controllerProject.upgradeProject();
                break;
            case 7:
                // Lógica para eliminar usuario
                controllerUser.removeUser();
                break;
            case 8:
                // Lógica para actualizar usuario
                controllerUser.upgradeUser();
                break;
            case 9:
                // Lógica para buscar usuario
                controllerUser.showUser();
                break;
            case 10:
                // Lógica para salir / cerrar sesión
                loginMainMenuSelection();
                break;

            default:
                throw new IllegalStateException("Opción inválida: " + userInput);
        }
    }

    public void menuProyect() {
        ViewTask viewTask = new ViewTask();
        int userInput;
        userInput = viewTask.menuTask();
        switch (userInput) {
            case 1:
                // Lógica para mostrar miembro
                controllerUser.listAllMember();
                break;
            case 2:
                // Lógica para añadir miembro
                controllerUser.addMember();
                break;
            case 3:
                // Lógica para eliminar miembro
                controllerUser.removeMember();
                break;
            case 4:
                // Lógica para añadir tarea
                controllerTask.createTask();
                break;
            case 5:
                // Lógica para eleminar tarea
                controllerTask.removeTask();
                break;
            case 6:
                // Mostrar tarea de tu usuario
                controllerTask.showTask();
                break;
            case 7:
                //Mostrar todas las tareas
                controllerTask.listAllTask();
                break;
            case 8:
                // Lógica para selecionar una tarea
                controllerTask.selectTask();
                menuTask();
                break;
            case 9:
                menu();
                break;

            default:
                throw new IllegalStateException("Opción inválida: " + userInput);
        }
    }

    public void menuTask() {
        ViewTaskScreen viewTaskScreen = new ViewTaskScreen();
        TaskRepo taskRepo = new TaskRepo();
        ViewTask viewTask = new ViewTask();
        int userInput;
        userInput = viewTaskScreen.menuTaskScreen();
        switch (userInput) {
            case 1:
                // Información tarea
                viewTask.showTask(taskRepo.browseOne(SelectedTask.get_instance().getActualProject().getName()));
                break;
            case 2:
                // Cambiar estado

                int tmp = viewTaskScreen.menuState();
                switch (tmp) {
                    case 1:
                        SelectedTask.get_instance().getActualProject().setEstado(Estado.Iniciada);
                        break;
                    case 2:
                        SelectedTask.get_instance().getActualProject().setEstado(Estado.Sin_Iniciar);
                        break;
                    case 3:
                        SelectedTask.get_instance().getActualProject().setEstado(Estado.Finalizado);
                        break;
                    default:
                        break;
                }
                break;
            case 3:
                // Modificar nombre
                String newName = Utils.readString("Introduce el nuevo nombre: ");
                SelectedTask.get_instance().getActualProject().setName(newName);
                break;
            case 4:
                // Modificar Descripción
                String newDescription = Utils.readString("Introduce la nueva descripción: ");
                SelectedTask.get_instance().getActualProject().setName(newDescription);
                break;
            case 5:
                menuProyect();
                break;
            default:
                throw new IllegalStateException("Opción inválida: " + userInput);
        }
    }


}




