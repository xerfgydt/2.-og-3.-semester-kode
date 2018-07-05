package dk.kea.model.Interface;

import dk.kea.model.entities.Opskrift;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IOpskrifterRep {

    ArrayList<Opskrift> readAll( int id);

    void create(Opskrift o, int id) throws SQLException;
}
