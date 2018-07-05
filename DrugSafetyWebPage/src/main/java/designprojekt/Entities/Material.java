package designprojekt.Entities;

public class Material {
    private String link;

    public Material(String link) {
        this.link = link;
    }

    public Material() {
    }
//
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return link;
    }
}
