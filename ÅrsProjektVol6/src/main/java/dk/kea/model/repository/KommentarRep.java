package dk.kea.model.repository;

import dk.kea.model.Interface.IKommentarRep;
import dk.kea.model.Interface.IUserRep;
import dk.kea.model.entities.Kommentar;
import dk.kea.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class KommentarRep implements IKommentarRep{

    @Autowired
    private JdbcTemplate jdbc;

    IUserRep uRep = new UserRep();

    public void create(Kommentar k, String username, int indlaegId) throws SQLException{

        Connection myConn = null;
        PreparedStatement myStmt = null;


        //User u = uRep.read(userId);

        System.out.println(k + "goooooddaaaag");

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "simon", "simon003");

            // 2. Prepare statement
            myStmt = myConn.prepareStatement("INSERT INTO db.kommentare (tekst, fk_indlæg_id, username) VALUES (?,?,?) ");


            // 3. Set the parameters
            myStmt.setString(1, k.getTekst());
            myStmt.setInt(2, indlaegId);
            myStmt.setString(3, username);

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

    public ArrayList<Kommentar> readAll(int indlægId){

        ArrayList<Kommentar> kommentare = new ArrayList<>();

        SqlRowSet sqlRowSet2;
        sqlRowSet2 = jdbc.queryForRowSet( "SELECT * FROM db.kommentare WHERE fk_indlæg_id = '" + indlægId + "'");
        while (sqlRowSet2.next()){

            kommentare.add(new Kommentar(sqlRowSet2.getInt("kommentar_id"),
                    sqlRowSet2.getString("tekst"), sqlRowSet2.getString("username"), sqlRowSet2.getString("date")));
        }

        return kommentare;
    }

    public void delete(int kommentarId){

        jdbc.update("DELETE FROM db.kommentare WHERE kommentar_id = '" + kommentarId + "'");

    }
}
