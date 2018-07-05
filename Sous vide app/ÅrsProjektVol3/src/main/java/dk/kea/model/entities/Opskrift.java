package dk.kea.model.entities;

public class Opskrift {

    private int id;
    private String emne;
    private String udskæring;
    private String temp;
    private String vægt;
    private String tid;

    public Opskrift() {
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

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getVægt() {
        return vægt;
    }

    public void setVægt(String vægt) {
        this.vægt = vægt;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return id + emne + udskæring + temp + vægt + tid;
    }
}
