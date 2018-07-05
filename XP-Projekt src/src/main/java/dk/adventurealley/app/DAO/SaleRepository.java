package dk.adventurealley.app.DAO;

import dk.adventurealley.app.Model.Entities.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class SaleRepository {

    @Autowired
    private JdbcTemplate jdbc;

    /*public Double fixComma(String price){
        price.replaceAll(",",".");
        return Double.parseDouble(price);
    }*/

    public void create(Sale sale) {
        //Hvis den første sql statement ikke påvirker nogle rows, så indsætter vi en ny row.
        if(jdbc.update("UPDATE adventure_alley_db.sales SET totalPrice = sales.totalPrice + ? WHERE date = ?",
                sale.getTotalPrice(),
                sale.getDate() ) == 0 ){
            //indsæt ny row, da denne dato ikke allerede eksisterer

            jdbc.update("INSERT INTO adventure_alley_db.sales(date, totalPrice) VALUES (?,?)",
                    sale.getDate(),
                    sale.getTotalPrice());
        }
    }

}

