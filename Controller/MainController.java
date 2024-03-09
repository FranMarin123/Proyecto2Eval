package Controller;

import Model.Repo.Repo;
import View.MainMenu;

public  class MainController {
    ControllerLogin controllerLogin = new ControllerLogin();

    public void processMainMenuSelection(String userInput) {
        switch (userInput) {
            case "1":
                // Lógica para registrar un usuario
                controllerLogin.createUser();
                break;
            case "2":
                // Lógica para iniciar sesión de un usuario
                controllerLogin.selectUser();
                break;
            case "3":
                System.exit(0);
                break;
            default:
                throw new IllegalStateException("Opción inválida: " + userInput);
        }
    }
}