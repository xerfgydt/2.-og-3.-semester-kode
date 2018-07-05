package dk.kea.model.repository;

import dk.kea.model.Interface.IOpskrifterRep;
import dk.kea.model.entities.Opskrift;
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
public class OpskriftRep implements IOpskrifterRep {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public void create(Opskrift o, int id) throws SQLException
    {
        Connection myConn1 = null;
        PreparedStatement myStmt1 = null;


        try
        {
            // 1. Get a connection to database
            myConn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306", "simon", "simon003");

            // 2. Prepare statement
            myStmt1 = myConn1.prepareStatement("INSERT INTO db.opskrifter(title, vurdering, karakter, fk_user_id) VALUES (?,?,?,?)");

            // 3. Set the parameters
            myStmt1.setString(1, o.getTitle());
            myStmt1.setString(2, o.getVurdering());
            myStmt1.setString(3, o.getKarakter());
            myStmt1.setInt(4, id);

            // 4. Execute SQL query
            myStmt1.executeUpdate();



            myStmt1 = myConn1.prepareStatement("INSERT INTO db.emner(type, vægt, tykkelse, bemærkning, fk_opskrift_id) VALUES (?, ?, ?, ?, LAST_INSERT_ID())");
            myStmt1.setString(1, o.getEmne());
            myStmt1.setString(2, o.getWeight());
            myStmt1.setString(3, o.getTykkelse());
            myStmt1.setString(4, o.getE_bemærkning());
            myStmt1.executeUpdate();



            myStmt1 = myConn1.prepareStatement("INSERT INTO db.tilberedninger(tid, temp, detaljer, fk_emne_id) VALUES (?,?,?, LAST_INSERT_ID())");
            myStmt1.setString(1, o.getTid());
            myStmt1.setString(2, o.getTemperatur());
            myStmt1.setString(3, o.getT_detaljer());
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

    public Opskrift read(int id){

        SqlRowSet sqlRowSet;
        sqlRowSet = jdbc.queryForRowSet("SELECT * FROM db.tilberedninger " +
                                        "INNER JOIN db.emner ON fk_emne_id = emne_id " +
                                        "INNER JOIN db.opskrifter ON fk_opskrift_id = opskrift_id " +
                                        "WHERE opskrift_id = '" + id + "'");

        if(sqlRowSet.next()){
            return new Opskrift(sqlRowSet.getInt("opskrift_id"), sqlRowSet.getString("title"), sqlRowSet.getDate("dato"), sqlRowSet.getString("karakter"),
                                sqlRowSet.getString("vurdering"), sqlRowSet.getString("type"), sqlRowSet.getString("vægt"), sqlRowSet.getString("tykkelse"),
                                sqlRowSet.getString("bemærkning"), sqlRowSet.getString("tid"), sqlRowSet.getString("temp"), sqlRowSet.getString("detaljer"));
        }

        return null;
    }

    public void update(int id, Opskrift o) throws SQLException{
        Connection myConn1 = null;
        PreparedStatement myStmt1 = null;


        try {
            // 1. Get a connection to database
            myConn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306", "simon", "simon003");

            // 2. Prepare statement
            myStmt1 = myConn1.prepareStatement("UPDATE db.opskrifter SET title, karakter, vurdering WHERE opskrift_id = '" + o.getId() + "'  VALUES (?, ?, ?) ");

            // 3. Set the parameters
            myStmt1.setString(1, o.getTitle());
            myStmt1.setString(2, o.getKarakter());
            myStmt1.setString(3, o.getVurdering());
            // 4. Execute SQL query
            myStmt1.executeUpdate();



            myStmt1 = myConn1.prepareStatement("UPDATE db.emner SET type, vægt, tykkelse, bemærkning WHERE fk_opskrift_id = '" + o.getId() +"' VALUES (?, ?, ?, ?)");

            myStmt1.setString(1, o.getEmne());
            myStmt1.setString(2, o.getWeight());
            myStmt1.setString(3, o.getTykkelse());
            myStmt1.setString(4, o.getE_bemærkning());

            myStmt1.executeUpdate();



            myStmt1 = myConn1.prepareStatement("UPDATE db.tilberedninger SET tid, temp, detaljer WHERE fk_emne_id = '" + o.getId() +"' VALUES (?, ?, ?)");

            myStmt1.setString(1, o.getTid());
            myStmt1.setString(2, o.getTemperatur());
            myStmt1.setString(3, o.getT_detaljer());

            myStmt1.executeUpdate();

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {

            if (myStmt1 != null) {
                myStmt1.close();
            }

            if (myConn1 != null) {
                myConn1.close();
            }
        }
    }


    public void delete(int id){
        jdbc.update("DELETE FROM db.opskrifter WHERE opskrift_id = '" + id + "'");
    }

    public ArrayList<Opskrift> readAll(int id){

        ArrayList<Opskrift> opskrifter = new ArrayList<>();

        SqlRowSet sqlRowSet;
        sqlRowSet = jdbc.queryForRowSet("SELECT * FROM db.tilberedninger " +
                "INNER JOIN db.emner ON fk_emne_id = emne_id " +
                "INNER JOIN db.opskrifter ON fk_opskrift_id = opskrift_id " +
                "WHERE db.opskrifter.fk_user_id = '" + id + "'");

        while(sqlRowSet.next()){

            opskrifter.add(new Opskrift(sqlRowSet.getInt("opskrift_id"), sqlRowSet.getString("title"), sqlRowSet.getDate("dato"), sqlRowSet.getString("karakter"),
                    sqlRowSet.getString("vurdering"), sqlRowSet.getString("type"), sqlRowSet.getString("vægt"), sqlRowSet.getString("tykkelse"),
                    sqlRowSet.getString("bemærkning"), sqlRowSet.getString("tid"), sqlRowSet.getString("temp"), sqlRowSet.getString("detaljer")));
        }

        return opskrifter;
    }


}
