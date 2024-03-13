package Controller;

import Interfaces.iUserController;
import Model.Repo.ProjectRepo;
import Model.Repo.SelectedProject;
import Model.Repo.UserRepo;
import Model.User;
import View.Utils.Utils;
import View.ViewLogin;
import View.ViewUser;

import java.util.ArrayList;
import java.util.List;

public class ControllerUser implements iUserController {
    ViewUser viewUser = new ViewUser();
    ViewLogin viewLogin = new ViewLogin();
    UserRepo userRepo = new UserRepo();
    ProjectRepo projectRepo = new ProjectRepo();

    /**
     * Este método pide un  usuario  a través de la vista (viewUser)
     * Luegolo pasa el usuario al repositorio de usuarios (userRepo).
     * Si el usuario existe, se muestra en la vista, de lo contrario,
     * se muestra un mensaje indicando que el usuario no se encontró.
     */
    @Override
    public void showUser() {
        User UserName = viewUser.searchUser();

        User existingUser = userRepo.browseOne(UserName.getNameUser());

        if (existingUser != null) {
            viewUser.displayUser(existingUser);
        } else {
            Utils.printMsg("❌ Usuario no encontrado");
        }
    }

    /**
     * Este método muestra pide un  usuario  a través de la vista (viewUser)
     * Luegolo pasa el usuario al repositorio de usuarios (userRepo).
     * Si el usuario existe, se elemina, de lo contrario,
     * se muestra un mensaje indicando que el usuario no se encontró.
     */
    @Override
    public User removeUser() {
        User userNameToDelete = viewUser.removeUser();

        User removedUser = userRepo.removeFromFiles(userNameToDelete);

        if (removedUser != null) {
            Utils.printMsg("✅ Usuario eliminado correctamente");
        } else {
            Utils.printMsg("❌ Fallo al eliminar el usuario, comprueba el nombre");
        }

        return removedUser;

    }

    /**
     * Este método pide un incio de sesión a través de la vista (viewUser)
     * Luegolo pasa el usuario al repositorio de usuarios (userRepo).
     * Si el usuario existe, se podrá actualizar, de lo contrario,
     * se muestra un mensaje indicando que el usuario no se encontró.
     */
    @Override
    public void upgradeUser() {
        User loginUser = viewLogin.displayLogIn();

        User existingUser = userRepo.selectAndSaveInAFile(loginUser);

        if (existingUser != null && existingUser.getPassword().equals(loginUser.getPassword())) {
            Utils.printMsg("✅ Inicio de sesión exitoso");

            User updatedUser = viewUser.upgradeUser();

            if (updatedUser != null) {
                userRepo.upgrade(updatedUser, existingUser.getNameUser());
                Utils.printMsg("✅ Datos del usuario actualizados exitosamente");
            } else {
                Utils.printMsg("❌ No se han realizado cambios en los datos del usuario");
            }
        } else {
            Utils.printMsg("❌ Fallo en el inicio de sesión");
        }
    }

    /**
     * Método para listar todos los miembros del proyecto actual.
     * - Obtiene la lista de miembros del proyecto actual a través del objeto SelectedProject.
     * - Muestra la lista de miembros si existe alguno, de lo contrario, muestra un mensaje de error.
     */
    @Override
    public void listAllMember() {
        List<User> allMembers= SelectedProject.get_instance().getActualProject().getMembers();
        if (allMembers!=null) {
            viewUser.listUsers(allMembers);
        }else {
            Utils.printMsg("❌ Error, todavía no hay miembros");
        }
    }

    /**
     * Método para añadir un miembro al proyecto.
     * - Solicita al usuario que introduzca el nombre del miembro a añadir.
     * - Utiliza el repositorio de proyectos para añadir el miembro.
     * - Muestra un mensaje indicando si el miembro se ha añadido correctamente o si ha ocurrido un error.
     */
    @Override
    public boolean addMember() {
        boolean comp = false;
        String memberName = Utils.readString("Introduce el usuario del miembro que quieres añadir: ");
        if (projectRepo.addMember(memberName)) {
            Utils.printMsg("✅ Miembro añadido correctamente");
        } else {
            Utils.printMsg("❌ Error al añadir el miembro");
        }

        return comp;
    }

    /**
     * Método para eliminar un miembro del proyecto.
     * - Solicita al usuario que introduzca el nombre del miembro a eliminar.
     * - Utiliza el repositorio de proyectos para eliminar el miembro.
     * - Muestra un mensaje indicando si el miembro se ha eliminado correctamente o si ha ocurrido un error.
     */
    @Override
    public boolean removeMember() {
        boolean comp = false;
        String memberName = Utils.readString("Introduce el usuario del miembro que quieres eliminar: ");
        if (projectRepo.removeMember(memberName)) {
            Utils.printMsg("✅ Miembro eliminado correctamente");
        } else {
            Utils.printMsg("❌ Error al eliminar el miembro");
        }

        return comp;
    }

}










