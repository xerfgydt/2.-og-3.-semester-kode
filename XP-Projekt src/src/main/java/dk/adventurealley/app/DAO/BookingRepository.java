package dk.adventurealley.app.DAO;

import dk.adventurealley.app.Model.Entities.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.SessionProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class BookingRepository {

    @Autowired
    private JdbcTemplate jdbc;
    @Autowired
    private ActivityRepository aR;
    @Autowired
    private ActivityRequirementsRepository aRR;
    @Autowired
    private CustomerRepository cR;
    @Autowired
    private InstructorRepository iR;

    //reads a specific booking out from id attribute
    public Booking read(Integer id) {
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM bookings WHERE id ='" + id + "'");
        if (rs.next()) {
            return new Booking(rs.getInt("id"), aR.read(rs.getInt("activityID")), cR.read(rs.getInt("customerID")), rs.getTimestamp("date").toLocalDateTime(),
                    rs.getString("description"), rs.getInt("numOfParticipants"), iR.read(rs.getInt("instructorID")));
        }
        return null;
    }

    //updates a booking out from booking id
    public void update(Booking booking) {

        jdbc.update("UPDATE bookings SET activityID ='" + booking.getActivity().getId() + "', " +
                "customerID ='" + booking.getCustomer().getId() + "', " +
                "date ='" + booking.getDate() + "', description ='" + booking.getDescription() + "', " +
                "numOfParticipants ='" + booking.getNumOfParticipants() + "'," +
                "instructorID ='" + booking.getInstructor().getId() + "' WHERE id ='" + booking.getId() + "'");

        cR.update(booking.getCustomer());
    }

    //returns ArrayList with booking objects from db
    public ArrayList<Booking> readAll() {
        ArrayList<Booking> bookingList = new ArrayList<>();
        SqlRowSet sqlRowSet = jdbc.queryForRowSet("SELECT * FROM bookings ORDER BY date");
        while (sqlRowSet.next()) {
            bookingList.add(
                    new Booking(
                            sqlRowSet.getInt("id"),
                            aR.read(sqlRowSet.getInt("activityID")),
                            cR.read(sqlRowSet.getInt("customerID")),
                            sqlRowSet.getTimestamp("date").toLocalDateTime(),
                            sqlRowSet.getString("description"), sqlRowSet.getInt("numOfParticipants"),
                            iR.read(sqlRowSet.getInt("instructorID"))));
        }
        return bookingList;
    }

    //deletes a booking in db out from id attribute
    public void deleteBooking(int id) {
        jdbc.update("DELETE FROM bookings WHERE id = " + id);
    }

    //returns an ArrayList with bookings that has the searched values
    public ArrayList<Booking> searchBooking(Booking searchBooking, String da){
        ArrayList<Booking> bookingArray = new ArrayList<>();
        bookingArray = this.readAll();
        ArrayList<Booking> searchedBookings = new ArrayList<>();

        for (Booking b : bookingArray) {
            if (b.getActivity().getName().toLowerCase().equals(searchBooking.getActivity().getName().toLowerCase()) &&
                    b.getCustomer().getCustomerName().toLowerCase().equals(searchBooking.getCustomer().getCustomerName().toLowerCase()) &&
                    b.getDate().toLocalDate().toString().equals(da)){
                searchedBookings.add(b);
            }
            else if (da.isEmpty() && searchBooking.getCustomer().getCustomerName().isEmpty()){
                if (b.getActivity().getName().toLowerCase().equals(searchBooking.getActivity().getName().toLowerCase())){
                    searchedBookings.add(b);
                }
            }
            else if (searchBooking.getActivity().getName().isEmpty() && searchBooking.getCustomer().getCustomerName().isEmpty()){
                if (b.getDate().toLocalDate().toString().equals(da)){
                    searchedBookings.add(b);
                }
            }
            else if (searchBooking.getActivity().getName().isEmpty() && da.isEmpty()){
                if (b.getCustomer().getCustomerName().toLowerCase().equals(searchBooking.getCustomer().getCustomerName().toLowerCase())){
                    searchedBookings.add(b);
                }
            }
            else if (searchBooking.getActivity().getName().isEmpty()){
                if (b.getCustomer().getCustomerName().toLowerCase().equals(searchBooking.getCustomer().getCustomerName().toLowerCase()) && b.getDate().toLocalDate().toString().equals(da)) {
                    searchedBookings.add(b);
                }
            }
            else if (searchBooking.getCustomer().getCustomerName().isEmpty()){
                if (b.getDate().toLocalDate().toString().equals(da) && b.getActivity().getName().toLowerCase().equals(searchBooking.getActivity().getName().toLowerCase())) {
                    searchedBookings.add(b);
                }
            }
            else if (da.isEmpty()){
                if (b.getCustomer().getCustomerName().toLowerCase().equals(searchBooking.getCustomer().getCustomerName().toLowerCase()) && b.getActivity().getName().toLowerCase().equals(searchBooking.getActivity().getName().toLowerCase())) {
                    searchedBookings.add(b);
                }
            }
        }
        return searchedBookings;
    }

}
