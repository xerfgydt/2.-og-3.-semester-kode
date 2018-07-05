package dk.kea.model.entities;



import java.util.Date;


public class Opskrift {

    private int id;
    private String title;
    private Date dato;
    private String karakter;
    private String vurdering;
    private String emne;
    private String weight;
    private String tykkelse;
    private String e_bemærkning;
    private String tid;
    private String temperatur;
    private String t_detaljer;

    public Opskrift() {
    }

    public Opskrift(int id, String title, Date dato, String karakter, String vurdering, String emne, String weight, String tykkelse, String e_bemærkning, String tid, String temperatur, String t_detaljer) {
        this.id = id;
        this.title = title;
        this.dato = dato;
        this.karakter = karakter;
        this.vurdering = vurdering;
        this.emne = emne;
        this.weight = weight;
        this.tykkelse = tykkelse;
        this.e_bemærkning = e_bemærkning;
        this.tid = tid;
        this.temperatur = temperatur;
        this.t_detaljer = t_detaljer;
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

    public Date getDato() {
        return dato;
    }

    public void setDato(Date dato) {
        this.dato = dato;
    }

    public String getKarakter() {
        return karakter;
    }

    public void setKarakter(String karakter) {
        this.karakter = karakter;
    }

    public String getVurdering() {
        return vurdering;
    }

    public void setVurdering(String vurdering) {
        this.vurdering = vurdering;
    }

    public String getEmne() {
        return emne;
    }

    public void setEmne(String emne) {
        this.emne = emne;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getTykkelse() {
        return tykkelse;
    }

    public void setTykkelse(String tykkelse) {
        this.tykkelse = tykkelse;
    }

    public String getE_bemærkning() {
        return e_bemærkning;
    }

    public void setE_bemærkning(String e_bemærkning) {
        this.e_bemærkning = e_bemærkning;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTemperatur() {
        return temperatur;
    }

    public void setTemperatur(String temperatur) {
        this.temperatur = temperatur;
    }

    public String getT_detaljer() {
        return t_detaljer;
    }

    public void setT_detaljer(String t_detaljer) {
        this.t_detaljer = t_detaljer;
    }

    @Override
    public String toString() {
        return id + title + dato + karakter + vurdering + emne + weight + tykkelse + e_bemærkning + tid + temperatur + t_detaljer;
    }
}
