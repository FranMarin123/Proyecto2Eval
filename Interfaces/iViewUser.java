package Interfaces;

import Model.User;

public interface iViewUser {
    User removeUser();
    User upgradeUser();
    User searchUser();
    void displayUser(User user);
}
