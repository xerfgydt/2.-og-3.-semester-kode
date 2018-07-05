package dk.kea.Model.Repository;

import dk.kea.Model.Entites.Blog;
import dk.kea.Model.Entites.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class BlogRepository implements BlogInterface {

    @Autowired
    private JdbcTemplate jdbc;

    private ArrayList<Blog> blogs = new ArrayList<Blog>();


    @Override
    public void create(Blog b) {

        jdbc.update("INSERT INTO db.blog_table(title, body) VALUES('" + b.getTitle() + "','" + b.getBody() + "')");

    }

    @Override
    public Blog read(int id) /* kan laese 1 bruger */  //razz
    {
        SqlRowSet sqlRowSet;

        sqlRowSet = jdbc.queryForRowSet("SELECT  * FROM db.blog_table WHERE id =" + id + " ");
        if (sqlRowSet.next()) {

            //indhold af database sqlRowSet ned i arrayliste
            return new Blog(sqlRowSet.getInt("id"), sqlRowSet.getString("title"), sqlRowSet.getString("body"));
        }
        return null;

    }

    @Override
    public ArrayList<Blog> readAll() {

        SqlRowSet sqlRowSet;
        blogs.clear();

        sqlRowSet = jdbc.queryForRowSet("SELECT * FROM db.blog_table");
        while(sqlRowSet.next()) {
            // indhold af sqlRowset ned i en arrayliste
            blogs.add(new Blog(sqlRowSet.getInt("id"), sqlRowSet.getString("title"), sqlRowSet.getString("body")));
        }
        return blogs;
    }

    @Override
    public void delete(int id) {


        jdbc.update("DELETE FROM db.blog_table WHERE id = '" + id + "'");

    }


    @Override
    public void updatedb(int id, String newBody) {
        jdbc.update("Update db.blog_table SET body =  '" + newBody + "' WHERE id = '" + id + "'");
    }

    /*
    @Override
    public User greenLight(String password, int id)
    {
    SqlRowSet sqlRowSet;
    sqlRowSet = jdbc.queryForRowSet("SELECT * FROM user_table WHERE password='" + password + "' AND id='" + id + "'");
        if (sqlRowSet.next())
        {
            return new User(sqlRowSet.getInt("id"), sqlRowSet.getString("name"), sqlRowSet.getString("password"), sqlRowSet.getString("address"), sqlRowSet.getString("email"), sqlRowSet.getString("role"));
        }
        return null;
    }




    public User loginDB(String email, String password) // kan laese alle brugere
    {
        SqlRowSet sqlRowSet;

        sqlRowSet = jdbc.queryForRowSet("SELECT * FROM user_table WHERE email ='" + email + "'AND password='" + password + "'");
        if (sqlRowSet.next()){


            return new User(sqlRowSet.getInt("id"), sqlRowSet.getString("name"), sqlRowSet.getString("password"), sqlRowSet.getString("address"), sqlRowSet.getString("email"), sqlRowSet.getString("role"));


        }
    return null;
}*/





}