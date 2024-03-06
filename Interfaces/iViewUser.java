package Interfaces;

import Model.User;

public interface iViewUser {
    int selectLoginRegister();
    User register();
    User login();
}
