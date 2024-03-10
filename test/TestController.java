package test;

import Controller.ControllerLogin;

public class TestController {
    public static void main(String[] args) {
        ControllerLogin loginController = new ControllerLogin();

        // Llamar al método para crear un usuario
        loginController.selectUser();

    }
}
