package dk.adventurealley.app.Model.Entities;

import java.util.ArrayList;

/**
 * Created by Ejer on 05-03-2018.
 */
public class Activity {
    private Integer id;
    private String name;
    private ArrayList<Requirement> reqList;
    private String equipment;
    private String imagePath;
    private String description;

    public Activity() {
    }

    public Activity(Integer id, String name, String imagePath) {
        this.id = id;
        this.name = name;
        this.imagePath = imagePath;
    }

    public Activity(Integer id, String name, ArrayList<Requirement> reqList, String equipment, String imagePath, String description) {
        this.id = id;
        this.name = name;
        this.reqList = reqList;
        this.equipment = equipment;
        this.imagePath = imagePath;
        this.description = description;
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

    public ArrayList<Requirement> getReqList() {
        return reqList;
    }

    public void setReqList(ArrayList<Requirement> reqList) {
        this.reqList = reqList;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", reqList=" + reqList +
                ", equipment='" + equipment + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}