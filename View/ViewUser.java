package View;

import Interfaces.iViewUser;
import Model.User;

public class ViewUser implements iViewUser {
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
