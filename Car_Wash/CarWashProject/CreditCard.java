public class CreditCard{
    private String creditcardNr;
    private double balanceCc;

    public CreditCard(String creditcardNr,double balanceCc){
        this.creditcardNr = creditcardNr;
        this.balanceCc = balanceCc;
    }


    public void setBalance(double newBalanceCc){
        balanceCc = newBalanceCc;

    }
    public double getBalanceCc(){
        return balanceCc;
    }
       
       
       
       
    public void buyWashCard(int cardprice){

        if(balanceCc - cardprice >= 0){
            balanceCc = balanceCc - cardprice;
            System.out.print("Here is your WashCard ");
            System.out.print("The amount of money on this card is: " + cardprice + " Kr");
        }
        else{
            System.out.println("Insufficient gold");
        } 
    }




}