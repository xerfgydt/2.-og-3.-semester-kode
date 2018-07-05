package dk.kea.model.Interface;

import dk.kea.model.entities.Opskrift;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IOpskrifterRep {

    ArrayList<Opskrift> readAll( int id);

    void create(Opskrift o, int id) throws SQLException;

    void delete(int id);

    Opskrift read(int id);

    void update(int id, Opskrift o) throws SQLException;
}
