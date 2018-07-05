package dk.kea.Model.Repository;

import dk.kea.Model.Entites.Blog;
import dk.kea.Model.Entites.User;

import java.util.ArrayList;

public interface BlogInterface {

    void create(Blog b);

    void delete(int id);

    ArrayList<Blog> readAll();

    //User loginDB(String username, String password);

    Blog read(int id);

    void updatedb(int id, String newBody);

    //User greenLight(String password, int id);

    //void byebye();
}
