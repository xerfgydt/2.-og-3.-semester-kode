import java.util.*;
import java.io.*;

public class Member implements java.io.Serializable{

    protected String firstName;
    protected String lastName;
    protected int age;
    protected String cpr;
    protected String membership;
    protected Subscription sub;
    protected String activity;

public Member(String firstName, String lastName, int age, String cpr, String membership){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.cpr = cpr;
        this.membership = membership;
        this.sub = new Subscription(000.0,"paymentDate ");   
        this.activity = "Active";
}

public void setFirstName(){
    firstName = System.console().readLine();
}

public void setLastName(){
    lastName = System.console().readLine();
}

public void setAge(){
    age = Integer.parseInt(System.console().readLine());
}

public void setCpr(){
    cpr = System.console().readLine();
}

    
    
    public String getFirstName(){
        return firstName;
    }
    

    public String getLastName(){
        return lastName;
    }
    public int getAge(){
        return age;
    }

    public String getCpr(){
        return cpr;
    }
    
    public String getMembership(){
        return membership;
    }

    public Subscription getSub(){
        return sub;
    }

    public String getActivity(){
        return activity;
    }


 
        
    
    public void setActivity(String answer){
        if (answer.equals("p")){
            activity = "passive";
        }
        else if(answer.equals("a")){
            activity = "active";
        }
        else{
            System.out.println();
            System.out.print("that's not a legitimate option ");
            
    }    
    
    }
    public void displayMember(){
        System.out.println();
        System.out.println("Name of Member is: " + firstName + " " + lastName);                    
        System.out.println("Age is: " + age);    
        System.out.println();
        System.out.println("CPR is: " + cpr);    
        System.out.println("Membership is: " + membership);
        System.out.println("Subscription is: " + sub);
        System.out.println("Membership activity is: " + activity);
        
        
    }

    public String toString(){
        return  firstName + lastName + age + cpr + membership + sub + activity;
    }
    

}
 

    

