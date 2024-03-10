package Controller;

import Model.Repo.Repo;
import View.MainMenu;

public  class MainController {
    ControllerLogin controllerLogin = new ControllerLogin();

    public void loginMainMenuSelection(int userInput) {
        boolean comp = false;
        switch (userInput) {
            case 1:
                // Lógica para registrar un usuario
                comp=controllerLogin.createUser();
                break;
            case 2:
                // Lógica para iniciar sesión de un usuario
                comp=controllerLogin.selectUser();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                throw new IllegalStateException("Opción inválida: " + userInput);
        }
        if (comp){
            projectMenu();
        }
    }
    public void projectMenu (){
       // switch ()

    }
}