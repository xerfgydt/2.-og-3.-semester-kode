package dk.kea.model.entities;

public class Kommentar {

    private int id;
    private String tekst;

    public Kommentar() {
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

    @Override
    public String toString() {
        return id + tekst;
    }
}
