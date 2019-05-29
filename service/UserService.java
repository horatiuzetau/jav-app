package service;

import models.User;

public interface UserService {

    //Get user
    void updateUser(User userToUpdate);

    //Modifica rolul unui user
    void updateRoleUser(String username, String rolNou);

    //Adauga un user
    void addUser(User userToAdd);

    //Sterge un user dupa id
    void deleteUser(int id);

    //Gaseste un user dupa username
    User findByUsername(String username);

    //Schimba parola
    void changePassword(String parolaNoua, int id);

    //Functia de login
    User loginFunction(String username, String parola);

}
