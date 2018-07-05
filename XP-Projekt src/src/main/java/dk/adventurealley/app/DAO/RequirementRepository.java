package dk.adventurealley.app.DAO;

import dk.adventurealley.app.Model.Entities.Requirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

// Lavet af Andreas og Jonas
@Repository
public class RequirementRepository {

    @Autowired
    private JdbcTemplate jdbc;

    private ArrayList<Requirement> requirementsList = new ArrayList<>();

    // readAll er kun til requirement names, outputter kun Requirements uden værdier
    public ArrayList<Requirement> readAll() {
        requirementsList.clear();
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM requirements");
        while (rs.next()) {
            requirementsList.add(new Requirement(rs.getInt("id"), rs.getString("name")));
        }
        return requirementsList;
    }

    //reads a specific requirement id out from name attribute
    public Integer readReqID(String name){
        SqlRowSet rs = jdbc.queryForRowSet("SELECT id FROM requirements WHERE name='" + name + "'");
        while (rs.next()) {
            return rs.getInt("id");
        }
        return null;
    }

    // Create requirement name
    public void createRequirement(String requirementName) {
        jdbc.update("insert into requirements (name) values (?)",requirementName);
    }


}