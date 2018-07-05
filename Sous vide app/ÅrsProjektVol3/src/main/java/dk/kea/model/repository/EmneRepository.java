package dk.kea.model.repository;

import dk.kea.model.entities.Emne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmneRepository implements CrudInterface<Emne>{

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public void create(Emne e, int id) throws SQLException
    {
        Connection myConn1 = null;
        PreparedStatement myStmt1 = null;

        try
        {
            // 1. Get a connection to database
            myConn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            // 2. Prepare statement

            myStmt1 = myConn1.prepareStatement("INSERT INTO db.emne_table(emne_emne, emne_udskæring, emne_vægt, emne_tykkelse, fk_opskrift_id) VALUES(?,?,?,?,LAST_INSERT_ID())");
            // 3. Set the parameters
            myStmt1.setString(1, e.getEmne());
            myStmt1.setString(2, e.getUdskæring());
            myStmt1.setString(3, e.getVægt());
            myStmt1.setString(4, e.getTykkelse());
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

    public Emne read(int id){
        SqlRowSet sqlRowSet;

        sqlRowSet = jdbc.queryForRowSet("SELECT * FROM db.emne_table WHERE fk_opskrift_id = '" + id + "'");
        if(sqlRowSet.next()){
            return new Emne(sqlRowSet.getInt("emne_id"), sqlRowSet.getString("emne_emne"), sqlRowSet.getString("emne_udskæring"), sqlRowSet.getString("emne_vægt"),   sqlRowSet.getString("emne_tykkelse"));
        }
        return null;
    }

    @Override
    public void update(int id) throws SQLException
    {
        Connection myConn1 = null;
        PreparedStatement myStmt1 = null;

        Emne e = read(id);

        try
        {
            // 1. Get a connection to database
            myConn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");

            // 2. Prepare statement
            myStmt1 = myConn1.prepareStatement("UPDATE db.emne_table SET emne_emne, emne_udskæring, emne_vægt, emne_tykkelse VALUES(?,?,?,?) WHERE fk_opskrift_id = '" + id + "'");

            // 3. Set the parameters
            myStmt1.setString(1, e.getEmne());
            myStmt1.setString(2, e.getUdskæring());
            myStmt1.setString(3, e.getVægt());
            myStmt1.setString(4, e.getTykkelse());

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
    public void delete(int id){
        jdbc.update("DELETE FROM db.emne_table WHERE fk_opskrift_id='" + id + "'");
    }
}
