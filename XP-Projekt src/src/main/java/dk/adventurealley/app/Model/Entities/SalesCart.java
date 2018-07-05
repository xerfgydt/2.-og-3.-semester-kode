package dk.adventurealley.app.Model.Entities;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by Ejer on 19-03-2018.
 */
public class SalesCart {
    private ArrayList<SaleItem> list;

    public SalesCart() {
        list = new ArrayList<>();
    }

    public Sale makeSale(){
        LocalDate localDate = LocalDate.now();
        return new Sale(localDate, calculateTotal());
    }

    public void addProductToCart(Product product){
        boolean containsProduct = false;
        for(SaleItem saleItem: list){
            if(saleItem.getProduct().getId() == product.getId()){
                saleItem.countOneUp();
                containsProduct = true;
            }
        }
        if(containsProduct == false){
            list.add(new SaleItem(product));
        }
    }

    public ArrayList<SaleItem> getList() {
        return list;
    }

    public void setList(ArrayList<SaleItem> list) {
        this.list = list;
    }
    public void removeProduct(int id){
        boolean delete = false;
        SaleItem itemToRemove = null;
        for(SaleItem saleItem : list){
            if(saleItem.getProduct().getId() == id){
                if(saleItem.getAmount() > 1){
                    saleItem.countOneDown();
                }
                else {
                   itemToRemove = saleItem;
                   break;
                }
            }
        }
        if(itemToRemove != null){
            list.remove(itemToRemove);
        }
    }
    public int cartSize(){
        return list.size();
    }

    @Override
    public String toString() {
        return "SalesCart{" +
                "list=" + list +
                '}';
    }

    public double calculateTotal() {
        double sum = 0;
        for(SaleItem saleItem: list){
            sum = sum + saleItem.getSubTotal();
        }
        return sum;
    }

}
