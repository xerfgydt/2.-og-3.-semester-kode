package dk.adventurealley.app.Model.Entities;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Sale {
    private Integer id;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private double totalPrice;

    // Constructors
    public Sale(){
    }
    public Sale(Integer id, LocalDate date, double totalPrice) {
        this.id = id;
        this.date = date;
        this.totalPrice = totalPrice;
    }

    public Sale(LocalDate date, double totalPrice) {
        this.date = date;
        this.totalPrice = totalPrice;
    }

    // Methods
    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", date=" + date +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
