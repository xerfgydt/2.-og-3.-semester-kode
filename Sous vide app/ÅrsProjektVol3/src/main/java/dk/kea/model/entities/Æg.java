package dk.kea.model.entities;

public class Æg {

    private int id;
    private String type;
    private String vægt;
    private String størrelse;

    public Æg() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVægt() {
        return vægt;
    }

    public void setVægt(String vægt) {
        this.vægt = vægt;
    }

    public String getStørrelse() {
        return størrelse;
    }

    public void setStørrelse(String størrelse) {
        this.størrelse = størrelse;
    }

    @Override
    public String toString() {
        return id + type + vægt + størrelse;
    }
}
