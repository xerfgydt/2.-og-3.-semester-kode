package dk.adventurealley.app.DAO;

import dk.adventurealley.app.Model.Entities.Activity;
import dk.adventurealley.app.Model.Entities.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class DailyIncomeRepository {
    @Autowired
    private JdbcTemplate jdbc;

    //Læser alle daglige indkomster/omsætning fra sales tabellen
    public ArrayList<Sale> readAll(){
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM sales ORDER BY date DESC ");
        ArrayList<Sale> sales = new ArrayList<>();
        while (rs.next()){
            sales.add(new Sale(rs.getInt("id"),rs.getDate("date").toLocalDate(), rs.getDouble("totalPrice")));
        }
        return sales;
    }

}
