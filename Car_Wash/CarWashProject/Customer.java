public class Customer{
    private String firstname;
    private String lastname;
    private int id;
    private boolean ownCard;

    public Customer(String firstname,String lastname,int id,boolean ownCard){
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
        this.ownCard = ownCard;

    }

    public void setName(String newfirstname,String newlastname){
        firstname = newfirstname;
        lastname = newlastname;
    }
     public String getName(){
        return firstname + " " + lastname;
    }

    public void setId(int newid){
        id = newid;
    }
         public int getId(){
        return id;
    }
    public void setOwnCard(boolean newOwnCard){
        ownCard = newOwnCard;

    }
   
    public boolean getOwnCard(){
        return ownCard;
    }
   



    
}