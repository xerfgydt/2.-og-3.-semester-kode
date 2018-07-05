package dk.kea.model.entities;


public class Emne {

    private int id;
    private String emne;
    private String udskæring;
    private String vægt;
    private String tykkelse;

    public Emne() {
    }

    public Emne(int id, String emne, String udskæring, String vægt, String tykkelse) {
        this.id = id;
        this.emne = emne;
        this.udskæring = udskæring;
        this.vægt = vægt;
        this.tykkelse = tykkelse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmne() {
        return emne;
    }

    public void setEmne(String emne) {
        this.emne = emne;
    }

    public String getUdskæring() {
        return udskæring;
    }

    public void setUdskæring(String udskæring) {
        this.udskæring = udskæring;
    }

    public String getVægt() {
        return vægt;
    }

    public void setVægt(String vægt) {
        this.vægt = vægt;
    }

    public String getTykkelse() {
        return tykkelse;
    }

    public void setTykkelse(String tykkelse) {
        this.tykkelse = tykkelse;
    }

    @Override
    public String toString() {
        return id + emne + udskæring + vægt + tykkelse;
    }
}
