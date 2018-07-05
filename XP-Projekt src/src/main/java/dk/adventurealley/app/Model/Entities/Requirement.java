package dk.adventurealley.app.Model.Entities;

/**
 * Created by Ejer on 05-03-2018.
 */
public class Requirement {
    private Integer id;
    private String reqName;
    private String value;

    //Full constructor
    public Requirement(Integer id, String reqName, String value) {
        this.id = id;
        this.reqName = reqName;
        this.value = value;
    }

    public Requirement(String reqName, String value) {
        this.reqName = reqName;
        this.value = value;
    }

    // Lavet af Andreas og Jonas
    // Bruges til; "Create requirement name" i Requirement repo
    public Requirement(Integer id, String reqName) {
        this.id = id;
        this.reqName = reqName;
    }

    // Bruges af Create Controller, til model
    public Requirement() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReqName() {
        return reqName;
    }

    public void setReqName(String reqName) {
        this.reqName = reqName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return  reqName + ": " + value;
    }
}