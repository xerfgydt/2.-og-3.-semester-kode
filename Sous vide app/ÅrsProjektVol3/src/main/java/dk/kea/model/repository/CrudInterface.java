package dk.kea.model.repository;

import dk.kea.model.entities.UserOpskrift;

import java.sql.SQLException;

public interface CrudInterface<T> {


    void create(T t, int id) throws SQLException;

    T read(int id);

    void update(int id) throws SQLException;

    void delete(int id);

}
