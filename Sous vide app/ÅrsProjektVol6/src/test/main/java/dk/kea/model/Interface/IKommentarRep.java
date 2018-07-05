package dk.kea.model.Interface;

import dk.kea.model.entities.Kommentar;

import java.util.ArrayList;

public interface IKommentarRep {

    ArrayList<Kommentar> readAll(int indlægId);
}
