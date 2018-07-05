package dk.kea.model.repository;

import dk.kea.model.entities.Emne;
import dk.kea.model.entities.User;
import dk.kea.model.entities.UserOpskrift;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class OpskriftRepository implements CrudInterface<UserOpskrift> {

    CrudInterface<Emne> eRep = new EmneRepository();

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public void create(UserOpskrift u, int id) throws SQLException
    {
        Connection myConn1 = null;
        PreparedStatement myStmt1 = null;

        try
        {
            // 1. Get a connection to database
            myConn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            // 2. Prepare statement


            myStmt1 = myConn1.prepareStatement("INSERT INTO db.user_opskrift_table(fk_user_id, opskrift_tid, opskrift_temp, opskrift_navn, opskrift_dato, opskrift_detaljer, opskrift_karakter, opskrift_vudering) VALUES(?,?,?,?,?,?,?,?)");
            // 3. Set the parameters
            myStmt1.setInt(1, id);
            myStmt1.setString(2, u.getTid());
            myStmt1.setString(3, u.getTemp());
            myStmt1.setString(4, u.getName());
            myStmt1.setDate(5, u.getDate());
            myStmt1.setString(6, u.getDetails());
            myStmt1.setString(7, u.getKarakter());
            myStmt1.setString(8, u.getVudering());
            // 4. Execute SQL query
            myStmt1.executeUpdate();

        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
        finally
        {

            if (myStmt1 != null)
            {
                myStmt1.close();
            }

            if (myConn1 != null)
            {
                myConn1.close();
            }
        }


    }

    @Override
    public UserOpskrift read(int id){
        SqlRowSet sqlRowSet;

        sqlRowSet = jdbc.queryForRowSet("SELECT * FROM db.user_opskrift_table WHERE id = '" + id + "'");
        if(sqlRowSet.next()){
            return new UserOpskrift(sqlRowSet.getInt("opskrift_id"), sqlRowSet.getString("opskrift_navn"), sqlRowSet.getString("opskrift_tid"), sqlRowSet.getString("opskrift_temp"),   sqlRowSet.getString("opskrift_detaljer"), sqlRowSet.getString("opskrift_karakter"), sqlRowSet.getString("opskrift_vudering"), sqlRowSet.getDate("opskrift_dato"));
        }
        return null;
    }


    @Override
    public void update(int id) throws SQLException
    {
        Connection myConn1 = null;
        PreparedStatement myStmt1 = null;

        UserOpskrift o = read(id);


        try
        {
            // 1. Get a connection to database
            myConn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            // 2. Prepare statement


            myStmt1 = myConn1.prepareStatement("UPDATE db.user_opskrift_table SET opskrift_tid, opskrift_temp, opskrift_navn, opskrift_dato, opskrift_detaljer, opskrift_karakter, opskrift_vudering VALUES(?,?,?,?,?,?,?) WHERE opskrift_id = '" + id + "'");
            // 3. Set the parameters
            myStmt1.setString(1, o.getTid());
            myStmt1.setString(2, o.getTemp());
            myStmt1.setString(3, o.getName());
            myStmt1.setDate(4, o.getDate());
            myStmt1.setString(5, o.getDetails());
            myStmt1.setString(6, o.getKarakter());
            myStmt1.setString(7, o.getVudering());

            // 4. Execute SQL query
            myStmt1.executeUpdate();
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
        finally
        {

            if (myStmt1 != null)
            {
                myStmt1.close();
            }

            if (myConn1 != null)
            {
                myConn1.close();
            }
        }

        eRep.update(id);

    }

    @Override
    public void delete(int id){
        jdbc.update("DELETE FROM db.user_opskrift_table WHERE id='" + id + "'");
        eRep.delete(id);
    }

}
