package Model.Repo;

import Model.User;
import Serializator.Serializator;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class UserRepo extends Repo<User> {

    /**
     * Este método inicia sesión con un usuario
     * @param selected Recibe el usuario que quiere iniciar sesión
     * @return Devuelve el usuario que se instancia o null si hay algún error con el usuario
     */
    @Override
    public User selectAndSaveInAFile(User selected) {
        File userSelectedFile = new File("./src/UserFileSaves/" + selected.getNameUser().toLowerCase().replaceAll(" ", ""));
        User userInFile=Serializator.deserializeObject(userSelectedFile.toString());
        User userLogged = null;
        if (userInFile!=null && userSelectedFile.exists() && userInFile.getPassword().equals(selected.getPassword())) {
            userLogged = userInFile;
            UserSesion.getInstance(userLogged);
        }
        return userLogged;
    }

    /**
     * Este método crea un usuario
     * @param selected Recibe un usuario para crear
     * @return Devuelve el usuario creado o null si no se ha creado
     */
    public User createUser(User selected) {
        File userSelectedFile = new File("./src/UserFileSaves/" + selected.getNameUser().toLowerCase().replaceAll(" ", ""));
        User userCreated = null;
        if (!userSelectedFile.exists() && addUserToArrayFile(selected)) {
            UserSesion.getInstance(selected);
            userCreated = selected;
            saveUser(UserSesion.getInstance().getCurrentUser());
        }
        return userCreated;
    }

    /**
     * Elimina el usuario introducido
     * @param selected Recibe el usuario a eliminar
     * @return Devuelve el usuario borrado
     */
    @Override
    public User removeFromFiles(User selected) {
        File userSelectedFile = new File("./src/UserFileSaves/" + selected.getNameUser().toLowerCase().replaceAll(" ", ""));
        User savedUserToProve = Serializator.deserializeObject("./src/UserFileSaves/" + selected.getNameUser().toLowerCase().replaceAll(" ", ""));
        User userToReturn=null;
        if (userSelectedFile.exists() && savedUserToProve.getPassword().equals(selected.getPassword())
                && !UserSesion.getInstance().getCurrentUser().getNameUser().equals(selected.getNameUser())) {
            removeFromArrayFile(savedUserToProve);
            userToReturn=savedUserToProve;
            userSelectedFile.delete();

        }
        return userToReturn;
    }

    /**
     * Este método busca un usuario por nombre
     * @param id Recibe el nombre del usuario
     * @return Devuelve el usuario buscado
     */
    @Override
    public User browseOne(String id) {
        File userSelectedFile = new File("./src/UserFileSaves/" + id.toLowerCase().replaceAll(" ", ""));
        User userToReturn=null;
        if (userSelectedFile.exists()){
            userToReturn=Serializator.deserializeObject(userSelectedFile.toString());
        }
        return userToReturn;
    }

    /**
     * Este método actualiza un usuario
     * @param userToUpgrade Recibe el usuario actualizado
     * @param name Recibe el nombre del usuario a actualizar
     * @return Devuelve el usuario sin actualizar
     */
    @Override
    public User upgrade(User userToUpgrade, String name) {
        File userSelectedFile = new File("./src/UserFileSaves/" + name.toLowerCase().replaceAll(" ", ""));
        File userUpgradedFile = new File("./src/UserFileSaves/" + userToUpgrade.getNameUser().toLowerCase().replaceAll(" ", ""));
        User userToReturn=null;
        if (!userUpgradedFile.exists()){
            userToReturn=Serializator.deserializeObject(userSelectedFile.toString());
            removeFromArrayFile(userToReturn);
            userSelectedFile.delete();
            saveUser(userToUpgrade);
            addUserToArrayFile(userToUpgrade);
        }
        return userToReturn;
    }

    /**
     * Devuelve todos los usuarios
     * @return Devuelve todos los usuarios
     */
    @Override
    public ArrayList<User> browseList() {
        return Serializator.deserializeObject("./src/UserFileSaves/users.bin");
    }

    /**
     * Este método añade un usuario a un fichero con todos los
     * usuarios registrados, si no se ha registrado ningún
     * usuario aún, crea el fichero con el primer usuario.
     *
     * @param userToAdd Recibe el usuario que queremos añadir al fichero
     * @return Devuelve true si el usuario se ha añadido y false si no se ha añadido
     */
    public boolean addUserToArrayFile(User userToAdd) {
        File usersFile = new File("./src/UserFileSaves/users.bin");
        boolean correctAdd = false;
        if (usersFile.exists()) {
            List<User> usersFromFile = Serializator.deserializeObject(usersFile.toString());
            if (verifyMailAndUsername(usersFromFile, userToAdd)) {
                usersFromFile.add(userToAdd);
                Serializator.serializeObject(usersFromFile, usersFile.toString());
                correctAdd = true;
            }
        } else {
            List<User> usersFromFile = new ArrayList<User>();
            usersFromFile.add(userToAdd);
            Serializator.serializeObject(usersFromFile, usersFile.toString());
            correctAdd = true;
        }

        return correctAdd;
    }

    /**
     * Este método elimina el usuario del archivo con todos los usuarios
     * @param userToRemove Recibe el usuario a eliminar
     * @return Devuelve true si se ha eliminado correctamente y false si ha habido algun error
     */
    public boolean removeFromArrayFile(User userToRemove) {
        File usersFile = new File("./src/UserFileSaves/users.bin");
        boolean correctRemove = false;
        List<User> usersFromFile = Serializator.deserializeObject(usersFile.toString());
        if (usersFromFile.remove(userToRemove)) {
            correctRemove = true;
        }
        return correctRemove;
    }

    /**
     * Este método comprueba en un conjunto de usuarios si ya hay un
     * usuario creado con el username o el correo introducidos
     *
     * @param usersToCheck Recibe la lista de los usuarios registrados
     * @param userFromView Recibe el usuario que queremos comprobar
     * @return Devuelve verdadero si no existe y falso si ya existe
     */
    public boolean verifyMailAndUsername(List<User> usersToCheck, User userFromView) {
        boolean comp = false;
        Iterator<User> iterator = usersToCheck.iterator();
        while (iterator.hasNext()) {
            User tmpUser = iterator.next();
            if (Objects.equals(tmpUser.getNameUser(), userFromView.getNameUser()) ||
                    Objects.equals(tmpUser.getGmail(), userFromView.getGmail())) {
                comp = false;
            } else {
                comp = true;
            }
        }
        return comp;
    }

    /**
     * Guarda un usuario en un archivo
     * @param userToSave Recibe el usuario a guardar
     * @return Devuelve true si se ha guardado y false si no
     */
    public static boolean saveUser(User userToSave){
        return Serializator.serializeObject(userToSave,"./src/UserFileSaves/" + userToSave.getNameUser().toLowerCase().replaceAll(" ",""));
    }
}
