package dk.kea.model.repository;

import dk.kea.model.Interface.IUserRep;
import dk.kea.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class UserRep implements IUserRep {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public void create(User u) throws SQLException {
        Connection myConn = null;
        PreparedStatement myStmt = null;


        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "simon", "simon003");

            // 2. Prepare statement
            myStmt = myConn.prepareStatement("INSERT INTO db.users(username, password, email, role) VALUES(?,?,?,?)");


            // 3. Set the parameters
            myStmt.setString(1, u.getUsername());
            myStmt.setString(2, u.getPassword());
            myStmt.setString(3, u.getEmail());
            myStmt.setString(4, u.getRole());

            myStmt.executeUpdate();

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

    @Override
    public User read(int id){

        SqlRowSet sqlRowSet;

        sqlRowSet = jdbc.queryForRowSet("SELECT * FROM db.users WHERE user_id = '" + id + "'");
        if(sqlRowSet.next()){

            return new User(sqlRowSet.getInt("user_id"), sqlRowSet.getString("username"), sqlRowSet.getString("password"),
                            sqlRowSet.getString("email"), sqlRowSet.getString("role"));
        }
        return null;
    }

    public void update(int id, User u) throws SQLException{
        Connection myConn = null;
        PreparedStatement myStmt = null;


        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "simon", "simon003");

            // 2. Prepare statement
            myStmt = myConn.prepareStatement("UPDATE db.users SET username = ?,  password = ?, email = ? WHERE user_id = ? ");


            // 3. Set the parameters
            myStmt.setString(1, u.getUsername());
            myStmt.setString(2, u.getPassword());
            myStmt.setString(3, u.getEmail());
            myStmt.setInt(4, id);

            myStmt.executeUpdate();

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
        jdbc.update("DELETE FROM db.users WHERE user_id = '" + id + "'");
    }

    public User loginDB(User u) throws SQLException// kan laese alle brugere
    {
        Connection myConn = null;
        PreparedStatement myStmt = null;


        try {

            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "simon", "simon003");

            myStmt = myConn.prepareStatement("SELECT * FROM db.users WHERE username = ? AND password = ?");

            myStmt.setString(1, u.getUsername());
            myStmt.setString(2, u.getPassword());

            ResultSet rs = myStmt.executeQuery();

            while (rs.next()){
                return new User(rs.getInt("user_id"), rs.getString("username"), rs.getString("password"),
                        rs.getString("email"), rs.getString("role"));
            }

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
        return null;
    }
}
