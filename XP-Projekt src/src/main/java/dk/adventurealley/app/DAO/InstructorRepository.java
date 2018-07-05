package dk.adventurealley.app.DAO;

import dk.adventurealley.app.Model.Entities.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class InstructorRepository {

    ArrayList<Instructor> intlist = new ArrayList<>();

    @Autowired
    private JdbcTemplate jdbc;

    //creates/inserts a instructor in db
    public void createInstructor (String name){
        jdbc.update("INSERT INTO adventure_alley_db.instructors(name) VALUES (?)", name);
    }

    //returns a instructor from db with specific id
    public Instructor read(int instructorID){
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM instructors WHERE id ='"+ instructorID +"'");

        if (rs.next()){
            return new Instructor(rs.getInt("id"), rs.getString("name"));
        }
        return null;
    }

    //returns a instructor from db with specific name
    public Instructor readOutFromName(String instructorName){
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM instructors WHERE name ='"+ instructorName +"'");

        if (rs.next()){
            return new Instructor(rs.getInt("id"), rs.getString("name"));
        }
        return null;
    }

    //returns ArrayList with all intructors from db
    public ArrayList<Instructor> readAll(){
        ArrayList<Instructor> instructors = new ArrayList<>();
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM instructors");

        while (rs.next()){
            instructors.add(new Instructor(rs.getInt("id"), rs.getString("name")));
        }

        return instructors;
    }
}
