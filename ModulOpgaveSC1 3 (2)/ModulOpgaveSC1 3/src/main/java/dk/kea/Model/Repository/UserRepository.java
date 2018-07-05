package dk.kea.Model.Repository;

import dk.kea.Model.Entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
@Repository
public class UserRepository implements UserInterface {


    @Autowired
    private JdbcTemplate jdbc;


    @Override
    public void create(User u) {

        jdbc.update("INSERT INTO db.user_table(name, password, address,email,role) VALUES('" + u.getName() + "','" + u.getPassword() + "','" + u.getAddress() + "','" + u.getEmail() + "','" + u.getRole() + "')");

    }

    @Override
    public void delete(int id) {


        jdbc.update("DELETE FROM db.user_table WHERE id = '" + id + "'");

    }


    @Override
    public User greenLight(String password, int id)
    {
    SqlRowSet sqlRowSet;
    sqlRowSet = jdbc.queryForRowSet("SELECT * FROM db.user_table WHERE password='" + password + "' AND id='" + id + "'");
        if (sqlRowSet.next())
        {
            return new User(sqlRowSet.getInt("id"), sqlRowSet.getString("name"), sqlRowSet.getString("password"), sqlRowSet.getString("address"), sqlRowSet.getString("email"), sqlRowSet.getString("role"));
        }
        return null;
    }


    @Override
    public void updatedb(int id, String newPassword) {
        jdbc.update("Update db.user_table SET password =  '" + newPassword + "' WHERE id = '" + id + "'");
    }

    @Override
    public User loginDB(String email, String password) // kan laese alle brugere
    {
        SqlRowSet sqlRowSet;

        sqlRowSet = jdbc.queryForRowSet("SELECT * FROM db.user_table WHERE email ='" + email + "'AND password='" + password + "'");
        if (sqlRowSet.next()){


            return new User(sqlRowSet.getInt("id"), sqlRowSet.getString("name"), sqlRowSet.getString("password"), sqlRowSet.getString("address"), sqlRowSet.getString("email"), sqlRowSet.getString("role"));


        }
    return null;
}




    @Override
    public User read(int id) /* kan laese 1 bruger */  //razz
    {
        SqlRowSet sqlRowSet;

        sqlRowSet = jdbc.queryForRowSet("SELECT  * FROM db.user_table WHERE id =" + id + " ");
        if (sqlRowSet.next()) {


            //indhold af database sqlRowSet ned i arrayliste
            return new User(sqlRowSet.getInt("id"), sqlRowSet.getString("name"), sqlRowSet.getString("password"), sqlRowSet.getString("address"), sqlRowSet.getString("email"), sqlRowSet.getString("role"));
        }
        return null;

    }
}