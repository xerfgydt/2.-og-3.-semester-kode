package dk.adventurealley.app.Model.Entities;

/**
 * Created by Ejer on 19-03-2018.
 */
public class SaleItem {

    private Product product;
    private int amount;

    public SaleItem(Product product) {
        this.product = product;
        this.amount = 1;
    }

    public SaleItem() {
    }
    //This adds a one to amount
    public void countOneUp(){
        amount++;
    }
    // this removes one from amount
    public void countOneDown(){
        amount--;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "SaleItem{" +
                ", product=" + product +
                ", amount=" + amount +
                '}';
    }

    public double getSubTotal() {
        return product.getPrice() * amount;
    }

}
