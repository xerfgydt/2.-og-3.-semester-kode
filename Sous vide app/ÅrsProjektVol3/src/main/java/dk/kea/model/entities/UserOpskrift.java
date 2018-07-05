package dk.kea.model.entities;

import java.sql.Date;

public class UserOpskrift {

    private int id;
    private String name;
    private String tid;
    private String temp;
    private String details;
    private String karakter;
    private String vudering;
    private Date date;

    public UserOpskrift() {
    }

    public UserOpskrift(int id, String name, String tid, String temp, String details, String karakter, String vudering, Date date) {
        this.id = id;
        this.name = name;
        this.tid = tid;
        this.temp = temp;
        this.details = details;
        this.karakter = karakter;
        this.vudering = vudering;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getKarakter() {
        return karakter;
    }

    public void setKarakter(String karakter) {
        this.karakter = karakter;
    }

    public String getVudering() {
        return vudering;
    }

    public void setVudering(String vudering) {
        this.vudering = vudering;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return id + name + tid + temp + details + karakter + vudering + date;
    }
}


