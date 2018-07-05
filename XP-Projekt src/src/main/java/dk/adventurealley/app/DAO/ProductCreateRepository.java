package dk.adventurealley.app.DAO;

import dk.adventurealley.app.Model.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class ProductCreateRepository {

    @Autowired
    private JdbcTemplate jdbc;

    //writes a new product object to db
    public void create(Product p) {
        jdbc.update("INSERT INTO adventure_alley_db.products(name, price, imagePath)" + "VALUES ('" + p.getName() + "', '" + p.getPrice() + "', '" + p.getProductImagePath() + "')");
    }

    //returns a specific Product out from id attribute
    public Product readSpecific(int id) {
        SqlRowSet sqlRowSet = jdbc.queryForRowSet("SELECT * FROM adventure_alley_db.products WHERE id =" + id + "");

        if(sqlRowSet.next()) {
            return new Product(sqlRowSet.getInt("id"), sqlRowSet.getString("name"), sqlRowSet.getDouble("price"), sqlRowSet.getString("imagePath"));
        }
        return new Product();
    }

    //updates a booking out from booking id
    public void updateProduct(Product p) {
        jdbc.update("UPDATE adventure_alley_db.products set name = '"+ p.getName() +"', price = '"+ p.getPrice() + "', imagePath = '"+ p.getProductImagePath() + "' WHERE id =" + p.getId() +"");
    }
}

