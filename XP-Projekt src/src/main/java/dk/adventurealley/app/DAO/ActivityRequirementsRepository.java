package dk.adventurealley.app.DAO;

import dk.adventurealley.app.Model.Entities.Requirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ActivityRequirementsRepository {
    @Autowired
    private JdbcTemplate jdbc;
    private ArrayList<Requirement> requirements = new ArrayList<>();

    // Returns a list of requirements(with req_values) from an activity
    public ArrayList<Requirement> readAllReqForActivity(Integer activityID) {
        requirements.clear();
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM act_reqs WHERE fk_act_id="+activityID);
        while (rs.next()){
            Requirement temp = read(rs.getInt("fk_req_id"));
            temp.setValue(rs.getString("req_value"));
            requirements.add(temp);
        }
        return requirements;
    }

    // Returns specific requirement
    public Requirement read(Integer reqID){
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM requirements WHERE id="+reqID);
        while (rs.next()) {
            return new Requirement(rs.getInt("id"), rs.getString("name"));
        }
        return null;
    }

    // Updates Requirements of an Activity in DB with given Requirements
    public void updateActivityRequirements(Integer activityID, ArrayList<Requirement> reqList){
        deleteActivityRequirements(activityID);
        for (Requirement req : reqList){
            jdbc.update("INSERT INTO act_reqs (fk_act_id, fk_req_id, req_value) " +
                    "VALUES ('" + activityID +"', '" + req.getId() + "', '" + req.getValue() +"')");
        }
    }

    // Deletes Requirements belonging to given Activity in DB
    public void deleteActivityRequirements(Integer activityID){
        jdbc.update("DELETE FROM act_reqs WHERE fk_act_id='"+ activityID + "'");
    }
}
