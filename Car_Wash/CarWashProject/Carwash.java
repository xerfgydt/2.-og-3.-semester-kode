import java.util.ArrayList;

public class Carwash{
    ArrayList<Carwash> statistics = new ArrayList<Carwash>();
    private String washTypes;
    private int price;
    // private String date;

    public Carwash(String washTypes,int price){
        this.washTypes = washTypes;
        this.price = price;
        // this.date = date;
    }

    public void setwashType(String input){
        if(input.equals("1")){
            washTypes = "GoldWash";
        }
        else if(input.equals("2")){
            washTypes = "SilverWash";
        }
        else if(input.equals("3")){
            washTypes = "BronzeWash";
        }
        else{
            System.out.println("Error. Does not compute");
        }
   }
   public String getwashtype(){
       return washTypes;
   }

   public void setprice(String newPrice){
       if(newPrice.equals("GoldWash")){
           price = 300;
           }
           else if(newPrice.equals("SilverWash")){
               price = 250;
           }
           else if(newPrice.equals("BronzeWash")){
               price = 200;
           }
        else{
            System.out.println("kijgh");
        }
    }

    public int getPrice(){
        return price;
    }
    public void printReciept(){
        System.out.println();
        System.out.println("___________________");
        System.out.println("Type of Wash: " + washTypes);
        System.out.println("the price was: " + price + "kr");
    }

public String toString(){
    return "Washtype: " + washTypes + ", price: " + price;
}

public void addCarwash(Carwash c){
    statistics.add(c);
}

public void printStatistic(){
    for(int i = 0; i < statistics.size(); i++){
        System.out.println(statistics.get(i));
    }
}


}