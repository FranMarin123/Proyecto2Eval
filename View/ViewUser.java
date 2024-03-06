package View;

import Interfaces.IViewUser;
import Model.User;

public class ViewUser implements IViewUser {
    @Override
    public int selectLoginRegister() {
        return 0;
    }

    @Override
    public User register() {
        return null;
    }

    @Override
    public User login() {
        return null;
    }
}
