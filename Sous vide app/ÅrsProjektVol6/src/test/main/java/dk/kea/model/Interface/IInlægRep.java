package dk.kea.model.Interface;

import dk.kea.model.entities.Indlæg;

import java.util.ArrayList;

public interface IInlægRep {

    ArrayList<Indlæg> readAll();
}
