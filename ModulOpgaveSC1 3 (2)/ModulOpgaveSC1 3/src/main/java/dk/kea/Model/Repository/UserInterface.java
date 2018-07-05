package dk.kea.Model.Repository;

import dk.kea.Model.Entites.User;

import java.util.ArrayList;

public interface UserInterface {

    void create(User u);

    void delete(int id);

    User loginDB(String username, String password);

    User read(int id);

    void updatedb(int id, String newPassword);

    User greenLight(String password, int id);

    //void byebye();
}
