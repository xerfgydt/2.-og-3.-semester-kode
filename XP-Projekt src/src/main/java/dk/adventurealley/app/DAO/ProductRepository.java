package dk.adventurealley.app.DAO;

import dk.adventurealley.app.Model.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class ProductRepository {
    @Autowired
    JdbcTemplate jdbc = new JdbcTemplate();

    ArrayList<Product> productList = new ArrayList<>();

    // Returns a list of Products with name and price (used in product-page for display)
    public ArrayList<Product> readAll(){
        productList.clear();
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM products");
        while(rs.next()){
            productList.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("imagePath")));
        }
        return productList;
    }



    // Delete specific Product
    public void deleteProduct(Integer id){
        jdbc.update("DELETE FROM products WHERE id='"+id+"'");
    }

    public Product read(int id) {
        Product product = new Product();
        SqlRowSet rs = jdbc.queryForRowSet("SELECT * FROM products WHERE id = ?",id);
        while(rs.next()){
            product = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("imagePath"));
        }
        return product;
    }
}
