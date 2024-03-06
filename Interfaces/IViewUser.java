package Interfaces;

import Model.User;

public interface IViewUser {
    int selectLoginRegister();
    User register();
    User login();
}
