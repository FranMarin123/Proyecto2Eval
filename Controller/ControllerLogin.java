package Controller;

import Interfaces.iLoginController;
import Model.Repo.Repo;
import Model.User;
import View.Utils.Utils;
import View.ViewLogin;

public class ControllerLogin implements iLoginController {
    ViewLogin viewLogin = new ViewLogin();
    //Repo repo = new Repo();

    @Override
    public void createUser() {
        User userToCreate = viewLogin.displayRegister();
        User userTemp = Repo.getInstance().createUser(userToCreate);
        //User userTemp = repo.createUser(userToCreate);
        if (userTemp != null) {
            // Mostrar mensaje de usuario registrado
            viewLogin.showMessageStartSessionSuccessful();
        } else {
            // Mostrar mensaje de fallo en la creación de usuario
            viewLogin.showMessageStartSessionFailed();
        }
    }


    @Override
    public User selectUser() {
        User loginUser = viewLogin.displayLogIn(); // Método que muestra la interfaz de inicio de sesión y devuelve un objeto User con las credenciales ingresadas
        User existingUser = Repo.getInstance().selectUser(loginUser.getNameUser());

        if (existingUser != null && existingUser.getPassword().equals(loginUser.getPassword())) {
            // Las credenciales son válidas, se devuelve el usuario autenticado
            return existingUser;
        } else {
            // Mostrar mensaje de fallo en el inicio de sesión
            Utils.printMsg("Fallo en el inicio de sesión");
            return null;
        }
    }
}


