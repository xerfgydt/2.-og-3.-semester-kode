package dk.kea.model.Interface;

import dk.kea.model.entities.Kommentar;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IKommentarRep {

    ArrayList<Kommentar> readAll(int indlægId);

    void create(Kommentar k, String username , int indlægId) throws SQLException;

    void delete(int kommentarId);
}
