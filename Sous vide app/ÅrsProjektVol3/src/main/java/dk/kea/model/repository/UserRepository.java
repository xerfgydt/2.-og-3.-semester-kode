package dk.kea.model.repository;

import dk.kea.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class UserRepository implements CrudInterface<User> {

    @Autowired
    private JdbcTemplate jdbc;


    public void create(User u) throws SQLException {
        Connection myConn = null;
        PreparedStatement myStmt = null;


        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");

            // 2. Prepare statement
            myStmt = myConn.prepareStatement("INSERT INTO db.user_table(user_name, user_email, user_password, user_role) VALUES(?,?,?,?)");


            // 3. Set the parameters
            myStmt.setString(1, u.getName());
            myStmt.setString(2, u.getPassword());
            myStmt.setString(3, u.getEmail());
            myStmt.setString(4, u.getRole());


        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
    }

    public User read(int id){

        SqlRowSet sqlRowSet;

        sqlRowSet = jdbc.queryForRowSet("SELECT * FROM db.user_table WHERE id = '" + id + "'");
        if(sqlRowSet.next()){

            return new User(sqlRowSet.getInt("user_id"), sqlRowSet.getString("user_name"), sqlRowSet.getString("user_email"), sqlRowSet.getString("user_password"), sqlRowSet.getString("user_role"));
        }
        return null;
    }

    @Override
    public void update(int id) throws SQLException{
        Connection myConn = null;
        PreparedStatement myStmt = null;

        User u = read(id); //read(id)

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");

            // 2. Prepare statement
            myStmt = myConn.prepareStatement("UPDATE db.user_table SET user_name, user_email, user_password VALUES(?,?,?) WHERE id='" + id +"'");


            // 3. Set the parameters
            myStmt.setString(1, u.getName()); 
            myStmt.setString(2, u.getPassword());
            myStmt.setString(3, u.getEmail());

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
    }

    public void delete(int id){
        jdbc.update("DELETE FROM db.user_table WHERE id='" + id + "'");
    }


}
