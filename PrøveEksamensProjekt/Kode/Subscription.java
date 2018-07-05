import java.util.*;
import java.io.*;

public class Subscription implements java.io.Serializable{
    
    private double price;
    private String paymentDate;
    private String subStatus;

public Subscription(double price, String paymentDate){
    this.price = price;
    this.subStatus = "not active";
    this.paymentDate = paymentDate;

    
}
public double getPrice(){
    return price;
}
public String getPaymentDate(){
    return paymentDate;
}
public void setPaymentDate(){
    Scanner scan = new Scanner (System.in);
    System.out.println();
    System.out.print("Please set a date ");

    paymentDate = scan.nextLine();
    
}
public String toString(){
    return price + "kr " + paymentDate + " Status: " + subStatus; 
} 

public String getSubscriptionStatus(){
    return subStatus;
}
public void setSubStatus(){
 subStatus = "active";
}

public void setPrice(Member m){

if (m.getActivity().equals("passive")){
     price = 500;    
}
else if (m.getAge()<18){
        price = 1000;
}
else if(m.getAge()<=60){
    price = 1600;
    }
else {
    price = 1600 * 0.75;
}



}
}