package Controller;

import Interfaces.iUserController;
import Model.Repo.Repo;
import Model.User;
import View.Utils.Utils;
import View.ViewLogin;
import View.ViewUser;

public class ControllerUser implements iUserController {
    ViewUser viewUser = new ViewUser();

    @Override
    public User showUser() {
        String usernameToShow = viewUser.getUsernameToShow(); // Puedes implementar este método en tu vista para obtener el nombre del usuario a mostrar
        User user = Repo.getInstance().showUser(usernameToShow);

        if (user != null) {
            // Mostrar información del usuario en la vista
            ViewUser.displayUserInfo(user);
        } else {
            // Mostrar mensaje de que el usuario no fue encontrado
            Utils.printMsg("Usuario no encontrado");
        }

        return user;
    }

    @Override
    public User removeUser() {
        //Tiene que ser void
       String userNameToDelete = ViewUser.getUserNameToDelete(); // Puedes implementar este método en tu vista para obtener el nombre del usuario a eliminar
        boolean isUserRemoved = Repo.getInstance().removeProject(userNameToDelete);

        if (isUserRemoved) {
            // Mostrar mensaje de usuario eliminado exitosamente
            Utils.printMsg("Usuario elinminado correctamente");
        } else {
            // Mostrar mensaje de fallo al eliminar usuario (puede deberse a que el nombre no existe)
            Utils.printMsg("Fallo al eleminar el usuario, comprueba el nombre");
        }
        return null;
    }

    @Override
    public User upgradeUser() {
        return null;
    }
}