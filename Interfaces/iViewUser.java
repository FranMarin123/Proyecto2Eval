package Interfaces;

import Model.User;

public interface iViewUser {
    User removeUser();
    User upgradeUser();
    void searchUser();
    void displayUser(User user);
}
