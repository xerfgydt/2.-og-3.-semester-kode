package dk.adventurealley.app.Model.Entities;

public class Instructor {

    private Integer id;
    private String name;

    public Instructor() {
    }

    public Instructor(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
