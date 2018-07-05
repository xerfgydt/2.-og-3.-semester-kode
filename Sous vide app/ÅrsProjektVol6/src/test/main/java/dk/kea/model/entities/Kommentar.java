package dk.kea.model.entities;

public class Kommentar {

    private int id;
    private String tekst;
    private String username;
    private String dato;

    public Kommentar() {
    }

    public Kommentar(int id, String tekst, String username, String dato) {
        this.id = id;
        this.tekst = tekst;
        this.username = username;
        this.dato = dato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return id + tekst + username + dato;
    }
}
