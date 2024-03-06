package Controller;

import Interfaces.iLoginController;
import Model.Repo.Repo;
import Model.User;
import View.ViewLogin;

public class ControllerLogin implements iLoginController {
    ViewLogin viewLogin = new ViewLogin();

    @Override
    public User createUser() {
        ///User userToCreate = viewLogin.displayRegister();
        //Repo.getInstance().createUser(userToCreate);
        return null;
     }

    @Override
    public User selectUser() {
       // User userToLogin = viewLogin.displayLogIn();
        //Repo.
        return null;
    }
}
