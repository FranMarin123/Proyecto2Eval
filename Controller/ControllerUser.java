package Controller;

import Interfaces.iUserController;
import Model.Repo.Repo;
import Model.User;
import View.Utils.Utils;
import View.ViewLogin;
import View.ViewUser;

public class ControllerUser implements iUserController {
    ViewUser viewUser = new ViewUser();
    ViewLogin viewLogin = new ViewLogin();
    userRepo repo = new UserRepo();

    @Override
    public void showUser() {
        User UserName = viewUser.searchUser();

        // Obtener el usuario existente del repositorio
        User existingUser = repo.getUserByUsername(UserName);

        // Verificar si el usuario existe
        if (existingUser != null) {
            // Mostrar la información del usuario
            viewUser.displayUser(existingUser);
        } else {
            Utils.printMsg("Usuario no encontrado");
        }
    }



    @Override
    public User removeUser() {
        String userNameToDelete = viewUser.removeUser();

        User removedUser = Repo.getInstance().removeUser(userNameToDelete);

        if (removedUser != null) {
            Utils.printMsg("Usuario eliminado correctamente");
        } else {
            Utils.printMsg("Fallo al eliminar el usuario, comprueba el nombre");
        }

        return removedUser;
    }
    @Override
    public void upgradeUser() {
        // Solicitar al usuario el nombre de usuario y la contraseña
        User loginUser = viewLogin.displayLogIn();

        // Obtener el usuario existente
        User existingUser = repo.selectAndCheck(loginUser);

        // Verificar si el usuario existe y si la contraseña coincide
        if (existingUser != null && existingUser.getPassword().equals(loginUser.getPassword())) {
            Utils.printMsg("Inicio de sesión exitoso");

            // Llamar directamente al método en viewUser para actualizar los campos
            viewUser.updateUserFields(existingUser);

            Utils.printMsg("Datos del usuario actualizados exitosamente");
        } else {
            Utils.printMsg("Fallo en el inicio de sesión");
        }
    }

        }








