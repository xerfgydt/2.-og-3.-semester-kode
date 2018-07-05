package dk.kea.model.Interface;

import dk.kea.model.entities.User;

import java.sql.SQLException;

public interface IUserRep {

    void create(User u) throws SQLException;

    User read(int id);

    User loginDB(User u) throws SQLException;

    void update(int id, User u) throws SQLException;

    void delete(int id);
}
