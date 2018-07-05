package dk.adventurealley.app.DAO;

import dk.adventurealley.app.Model.Entities.Activity;
import dk.adventurealley.app.Model.Entities.Booking;
import dk.adventurealley.app.Model.Entities.Customer;
import dk.adventurealley.app.Model.Entities.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;


@Repository
public class BookingCreateRepository {


    @Autowired
    private JdbcTemplate jdbc;
    // write booking object to DB
    public void create (Booking b, Customer c, String intName, String actiName) {
        Customer cnew = new Customer();
        Activity anew = new Activity();
        Instructor inew = new Instructor();

        jdbc.update("INSERT INTO adventure_alley_db.customers(name, companyName, phone) " + "VALUES ('" + c.getCustomerName() + "', '" + c.getCompanyName() + "', '" + c.getPhone() + "')");
        SqlRowSet sr1 = jdbc.queryForRowSet("SELECT * FROM customers WHERE phone = '" + c.getPhone() + "'");

        if(sr1.next()) {
            cnew.setId(sr1.getInt("id")); cnew.setCustomerName(sr1.getString("name")); cnew.setCustomerName(sr1.getString("companyName")); cnew.setPhone(sr1.getString("phone"));
        }

        SqlRowSet rs = jdbc.queryForRowSet("SELECT id FROM activities WHERE name='" + actiName + "'");
            if (rs.next()) {
                anew.setId(rs.getInt("id"));
            }

        SqlRowSet rs1 = jdbc.queryForRowSet("SELECT id FROM instructors WHERE name='" + intName + "'");
        if (rs1.next()) {
            inew.setId(rs1.getInt("id"));
        }

    jdbc.update("INSERT INTO adventure_alley_db.bookings(date, customerID, numOfParticipants, description, activityID, instructorID) " + "VALUES ('" + b.getDate() + "', '" + cnew.getId() + "', '" + b.getNumOfParticipants() + "', '" + b.getDescription() + "', '" + anew.getId() + "', '" + inew.getId() + "')");
    }

}
