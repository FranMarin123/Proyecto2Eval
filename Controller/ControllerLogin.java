package Controller;

import Interfaces.iLoginController;
import Model.Repo.Repo;
import Model.User;
import View.Utils.Utils;
import View.ViewLogin;

public class ControllerLogin implements iLoginController {
    ViewLogin viewLogin = new ViewLogin();
    userRepo repo = new UserRepo();

    /**
     * Método para crear un nuevo usuario.
     * - Obtiene la información del usuario a través de la vista.
     * - Utiliza el repositorio para seleccionar y guardar el usuario en un archivo.
     * - Muestra un mensaje de inicio de sesión exitoso o fallido según el resultado.
     */
    @Override
    public void createUser() {
        User userToCreate = viewLogin.displayRegister();
        User userTemp = repo.selectAndSaveInAfFile(userToCreate);

        if (userTemp != null) {
            viewLogin.showMessageStartSessionSuccessful();
        } else {
            viewLogin.showMessageStartSessionFailed();
        }
    }

    /**
     * Método para seleccionar un usuario e iniciar sesión.
     * - Obtiene las credenciales del usuario a través de la vista.
     * - Utiliza el repositorio para seleccionar y obtener un usuario existente.
     * - Verifica las credenciales y muestra mensajes apropiados en la consola.
     */
    @Override
    public void selectUser() {
        User loginUser = viewLogin.displayLogIn();
        User existingUser = repo.selectAndSaveInAfFile(loginUser);

        if (existingUser != null && existingUser.getPassword().equals(loginUser.getPassword())) {
            Utils.printMsg("Inicio de sesión exitoso");
        } else {
            Utils.printMsg("Fallo en el inicio de sesión");
        }
    }
}


