public class WashCard{
    private String washcardNr;
    private int balanceWc;
    private int cardPrice;


    public WashCard(String washcardNr,int balanceWc, int cardPrice){
        this.washcardNr = washcardNr;
        this.balanceWc = balanceWc;
        this.cardPrice = cardPrice;

    }
    public void useWashcard(int carwashPrice){
        if(carwashPrice <= balanceWc){
            balanceWc = balanceWc - carwashPrice;
        }
        else{
            System.out.println("Insufficient funds");
        }
    }
    public void refillWashcard(int input){
            if(balanceWc + input <= 1000 ){
            balanceWc = balanceWc + input;
            System.out.print("The amount of money on this card has been changed to: " + balanceWc + "Kr");
        }
        else{
            System.out.println("Insufficient gold");
    }
    }
        

    public void setprice( int newCardPrice){
        if(newCardPrice <= 1000 && newCardPrice >= 200){
            cardPrice = newCardPrice;
            balanceWc = newCardPrice;
            
        }
        else{
            System.out.println("You failed!");
        }
 
    }
    

    public int getCardPrice(){
        return cardPrice;
    }

    public int getBalanceWc(){
        return balanceWc;
    }
    public void printReciept(String input){
        System.out.println();
        System.out.println("________________");
        System.out.println(input);
        System.out.println("Your balance on your washcard is now: " + balanceWc + " kr");
       
    }
  
}