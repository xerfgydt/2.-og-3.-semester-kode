package dk.kea.model.entities;

import java.util.ArrayList;

public class Indlæg {

    private int id;
    private String title;
    private String tekst;
    private String username;
    private String dato;
    private ArrayList<Kommentar> kommentare;

    public Indlæg() {
    }

    public Indlæg(int id, String title, String tekst, String username, String dato, ArrayList<Kommentar> kommentare) {
        this.id = id;
        this.title = title;
        this.tekst = tekst;
        this.username = username;
        this.dato = dato;
        this.kommentare = kommentare;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public ArrayList<Kommentar> getKommentareListe() {
        return kommentare;
    }

    public void setKommentareListe(ArrayList<Kommentar> kommentare) {
        this.kommentare = kommentare;
    }

    @Override
    public String toString() {
        return id + title + tekst + username + dato + kommentare;
    }
}
