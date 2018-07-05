package dk.kea.model.repository;

import dk.kea.model.Interface.IInlægRep;
import dk.kea.model.Interface.IKommentarRep;
import dk.kea.model.Interface.IUserRep;
import dk.kea.model.entities.Indlæg;
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
public class IndlægRep implements IInlægRep{

    @Autowired
    IKommentarRep kRep = new KommentarRep();

    @Autowired
    IUserRep uRep = new UserRep();

    @Autowired
    private JdbcTemplate jdbc;

    public void create(Indlæg i, int userId) throws SQLException{

        Connection myConn = null;
        PreparedStatement myStmt = null;

        User u = uRep.read(userId);

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "simon", "simon003");

            // 2. Prepare statement
            myStmt = myConn.prepareStatement("INSERT INTO db.indlæg (title, tekst, username) VALUES (?,?,?) ");


            // 3. Set the parameters
            myStmt.setString(1, i.getTitle());
            myStmt.setString(2, i.getTekst());
            myStmt.setString(3, u.getUsername());

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

    public ArrayList<Indlæg> readAll(){


        ArrayList<Indlæg> forum = new ArrayList<>();



        SqlRowSet sqlRowSet1;
        sqlRowSet1 = jdbc.queryForRowSet("SELECT * FROM db.indlæg ");
        while(sqlRowSet1.next()) {

            int indlægId = sqlRowSet1.getInt("indlæg_id");

            ArrayList<Kommentar> kommentare = kRep.readAll(indlægId);

            forum.add(new Indlæg(sqlRowSet1.getInt("indlæg_id"), sqlRowSet1.getString("title"),
                    sqlRowSet1.getString("tekst"), sqlRowSet1.getString("username"), sqlRowSet1.getString("dato"), kommentare));
        }
        return forum;
    }

    public void delete(int indlægId){

        jdbc.update("DELETE FROM db.indlæg WHERE indlæg_id = '" + indlægId + "'");

    }


}
