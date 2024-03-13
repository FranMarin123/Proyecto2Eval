package Controller;


import Model.Repo.SelectedProject;
import Model.Repo.SelectedTask;
import Model.Repo.TaskRepo;
import Model.Repo.UserSesion;
import View.*;
import Enum.Estado;
import View.Utils.Utils;

public class MainController {
    ControllerLogin controllerLogin = new ControllerLogin();
    ControllerProject controllerProject = new ControllerProject();
    ControllerTask controllerTask = new ControllerTask();
    ControllerUser controllerUser = new ControllerUser();
    View view = new View();

    /**
     * Método para manejar la selección del menú de inicio de sesión.
     * - Muestra un mensaje de bienvenida.
     * - Crea un objeto MainMenu para mostrar el menú principal.
     * - Realiza un bucle para recibir y procesar la selección del usuario.
     * - Ejecuta la lógica correspondiente según la opción seleccionada por el usuario.
     * - Si se registra o inicia sesión un usuario con éxito, muestra el menú principal.
     */
    public void loginMainMenuSelection() {
        view.showMessageWelcome();
        MainMenu mainMenu = new MainMenu();
        int userInput;
        do {
            userInput = mainMenu.displayMainMenu();
            switch (userInput) {
                case 1:
                    // Lógica para registrar un usuario
                    controllerLogin.createUser();
                    if (UserSesion.getInstance()!=null) {
                        menu();
                    }
                    break;
                case 2:
                    // Lógica para iniciar sesión de un usuario
                    controllerLogin.selectUser();
                    if (UserSesion.getInstance()!=null) {
                        menu();
                    }
                    break;
                case 3:
                    view.showMessageGoodBye();
                    break;
                default:
                    throw new IllegalStateException("Opción inválida: " + userInput);
            }
        } while (userInput != 3);
    }

    /**
     * Método para manejar las opciones del menú principal.
     * - Crea un objeto ViewProject para mostrar el menú de proyectos.
     * - Realiza un bucle para recibir y procesar la selección del usuario.
     * - Ejecuta la lógica correspondiente según la opción seleccionada por el usuario.
     * - Si se selecciona un proyecto con éxito, muestra el menú del proyecto.
     */
    public void menu() {
        ViewProject viewProject = new ViewProject();
        int userInput;
        do {
            userInput = viewProject.menuProject();
            switch (userInput) {
                case 1:
                    // Lógica para buscar un proyecto
                    controllerProject.showProject();
                    Utils.pressEnter();
                    break;
                case 2:
                    // Lógica para mostrar proyectos
                    controllerProject.listAllProjects();
                    Utils.pressEnter();
                    break;
                case 3:
                    // Lógica para crear proyectos
                    controllerProject.createProject();
                    Utils.pressEnter();
                    break;
                case 4:
                    // Lógica para eliminar proyectos
                    controllerProject.removeProject();
                    Utils.pressEnter();
                    break;
                case 5:
                    // Lógica para entrar en un proyecto
                    controllerProject.selectProject();
                    if (SelectedProject.get_instance()!=null) {
                        menuProject();
                    }
                    break;
                case 6:
                    // Lógica para actualizar un proyecto
                    controllerProject.upgradeProject();
                    Utils.pressEnter();
                    break;
                case 7:
                    controllerUser.removeUser();
                    Utils.pressEnter();
                    break;
                case 8:
                    // Lógica para actualizar usuario
                    controllerUser.upgradeUser();
                    Utils.pressEnter();
                    break;
                case 9:
                    // Lógica para buscar usuario
                    controllerUser.showUser();
                    Utils.pressEnter();
                    break;
                case 10:
                    UserSesion.getInstance().closeSession();
                    break;
                default:
                    Utils.printMsg("Opción inválida: " + userInput);
            }
        } while (userInput != 10);

    }

    /**
     * Método para manejar las opciones del menú del proyecto.
     * - Crea un objeto ViewTask para mostrar el menú de tareas.
     * - Realiza un bucle para recibir y procesar la selección del usuario.
     * - Ejecuta la lógica correspondiente según la opción seleccionada por el usuario.
     * - Si se selecciona una tarea con éxito, muestra el menú de la tarea.
     */
    public void menuProject() {
        ViewTask viewTask = new ViewTask();
        int userInput;
        do {
            userInput = viewTask.menuTask();
            switch (userInput) {
                case 1:
                    // Lógica para mostrar miembro
                    controllerUser.listAllMember();
                    Utils.pressEnter();
                    break;
                case 2:
                    // Lógica para añadir miembro
                    controllerUser.addMember();
                    Utils.pressEnter();
                    break;
                case 3:
                    // Lógica para eliminar miembro
                    controllerUser.removeMember();
                    Utils.pressEnter();
                    break;
                case 4:
                    // Lógica para añadir tarea
                    controllerTask.createTask();
                    Utils.pressEnter();
                    break;
                case 5:
                    // Lógica para eleminar tarea
                    controllerTask.removeTask();
                    Utils.pressEnter();
                    break;
                case 6:
                    // Mostrar tarea de tu usuario
                    controllerTask.showTask();
                    Utils.pressEnter();
                    break;
                case 7:
                    //Mostrar todas las tareas
                    controllerTask.listAllTask();
                    Utils.pressEnter();
                    break;
                case 8:
                    // Lógica para selecionar una tarea
                    controllerTask.selectTask();
                    if (SelectedTask.get_instance()!=null) {
                        menuTask();
                    }
                    break;
                case 9:
                    SelectedProject.get_instance().closeProject();
                    break;
                default:
                    Utils.printMsg("Opción inválida: " + userInput);
            }
        } while (userInput != 9);
    }

    /**
     * Método para manejar las opciones del menú de la tarea.
     * - Crea un objeto ViewTaskScreen para mostrar el menú de la tarea.
     * - Realiza un bucle para recibir y procesar la selección del usuario.
     * - Ejecuta la lógica correspondiente según la opción seleccionada por el usuario.
     */
    public void menuTask() {
        ViewTaskScreen viewTaskScreen = new ViewTaskScreen();
        TaskRepo taskRepo = new TaskRepo();
        ViewTask viewTask = new ViewTask();
        int userInput;
        do {
            userInput = viewTaskScreen.menuTaskScreen();
            switch (userInput) {
                case 1:
                    // Información tarea
                    viewTask.showTask(taskRepo.browseOne(SelectedTask.get_instance().getActualTask().getName()));
                    Utils.pressEnter();
                    break;
                case 2:
                    // Cambiar estado

                    int tmp = viewTaskScreen.menuState();
                    SelectedProject.get_instance().removeTaskFromActualProject(SelectedTask.get_instance().getActualTask());
                    TaskRepo.removeTask(SelectedTask.get_instance().getActualTask());
                    switch (tmp) {
                        case 1:
                            SelectedTask.get_instance().getActualTask().setEstado(Estado.Iniciada);
                            break;
                        case 2:
                            SelectedTask.get_instance().getActualTask().setEstado(Estado.Sin_Iniciar);
                            break;
                        case 3:
                            SelectedTask.get_instance().getActualTask().setEstado(Estado.Finalizado);
                            break;
                        default:
                            break;
                    }
                    TaskRepo.saveTask(SelectedTask.get_instance().getActualTask());
                    SelectedProject.get_instance().addTaskToActualProject(SelectedTask.get_instance().getActualTask());
                    Utils.pressEnter();
                    break;
                case 3:
                    // Modificar nombre
                    String newName = Utils.readString("Introduce el nuevo nombre: ");
                    SelectedProject.get_instance().removeTaskFromActualProject(SelectedTask.get_instance().getActualTask());
                    TaskRepo.removeTask(SelectedTask.get_instance().getActualTask());

                    SelectedTask.get_instance().getActualTask().setName(newName);

                    TaskRepo.saveTask(SelectedTask.get_instance().getActualTask());
                    SelectedProject.get_instance().addTaskToActualProject(SelectedTask.get_instance().getActualTask());
                    Utils.pressEnter();
                    break;
                case 4:
                    // Modificar Descripción
                    String newDescription = Utils.readString("Introduce la nueva descripción: ");
                    SelectedProject.get_instance().removeTaskFromActualProject(SelectedTask.get_instance().getActualTask());
                    TaskRepo.removeTask(SelectedTask.get_instance().getActualTask());
                    SelectedTask.get_instance().getActualTask().setDecripcion(newDescription);
                    TaskRepo.saveTask(SelectedTask.get_instance().getActualTask());
                    SelectedProject.get_instance().addTaskToActualProject(SelectedTask.get_instance().getActualTask());
                    Utils.pressEnter();
                    break;
                case 5:
                    SelectedTask.get_instance().closeTask();
                    break;
                default:
                    Utils.printMsg("Opción inválida: " + userInput);
            }
        }while (userInput!=5);
    }


}




