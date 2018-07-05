import java.util.*;
import java.io.*;

 
public class Cashier{
private ArrayList<Member> memberList = new ArrayList<Member>();
    File memberLibrary = new File("MemberLibrary.txt");
 
public void cashierOptions(President p){
    Scanner scan = new Scanner(System.in);
    System.out.println();
    System.out.println("Choose your options");
    
    String optionInput;
        do{
            System.out.println();
            System.out.println("(1) to update Member activity status");
            System.out.println("(2) to activate subscription of members");
            System.out.println("(q) to quit to main menu");
            
                optionInput = scan.nextLine();
                switch (optionInput){
                    
                    case "1":
                        updateActivity();
                    break;
 
                    case "2":
                        activateSubscription(p);
                        break;
                    
                    case "q":
                
                        break;
                    
                    default:
                        System.out.println();
                        System.out.println("not a valid option");
                        
                        break;
                }
        }while(!optionInput.equals("q"));
  
}
 
 
public void updateActivity(){
    Scanner scan = new Scanner (System.in);
    System.out.println();
    System.out.print("Please enter the cpr of the Member you want to update: ");
    
    String cpr = scan.nextLine();
        if (getMember(cpr) == null){
            System.out.println();
            System.out.println("there is no such member");
            
        }
        else{
            System.out.println();
            System.out.print("please choose member activity status.  (a) Active or (p) Passive: ");
            
            String activity = scan.nextLine();    
            getMember(cpr).setActivity(activity);
            getMember(cpr).getSub().setPrice(getMember(cpr));
            System.out.println();
            System.out.println("The Members acitivty status have been updated " );
            System.out.println();
        }            
}


public void activateSubscription(President p){
    for (Iterator<Member> i = p.getNewMemberList().iterator(); i.hasNext(); ){
        Member m = i.next();
        m.getSub().setPrice(m);
        m.displayMember();
        m.getSub().setPaymentDate();
        Scanner scan = new Scanner (System.in);
        System.out.println();
        System.out.print("you can choose to activate a member subscription. (y) Active or (n) declined or (q) for quit ");
        
        String subAnswer = scan.nextLine();    
            if (subAnswer.equals("q")){
            break;
            }
            
            else if(subAnswer.equals("y")){
                m.getSub().setSubStatus();
                memberList.add(m);
                i.remove();
                System.out.println();
                System.out.println("Subscription succesfully activated");
            }

            else if(subAnswer.equals("n")){
                System.out.println();
                System.out.println("You have not activated the member ");
                
            }
            else{
                System.out.println();    
                System.out.println("You have pushed the wrong key ");
                
            }
            
    
    }
}
    
public Member getMember(String cpr){
        for (Member m : memberList){
            if (cpr.equals(m.getCpr())){
                return m;
            }
        }
        return null;
    }

public EliteSwimmer getEliteSwimmer(String cpr){
    for (Member m : memberList) {
        if (m instanceof EliteSwimmer) {
            EliteSwimmer el = (EliteSwimmer)m;
        
            if (cpr.equals(el.getCpr())){
                        return el;
            }
        }
    }
            return null;
}

public ArrayList<Member> getMemberList(){
        return memberList;
}

 @SuppressWarnings("unchecked")
    public void serializationWriteTofile(){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(memberLibrary));
            oos.writeObject(memberList);
            oos.close();
        }catch(Exception e){
            e.printStackTrace();
    }
}
 
@SuppressWarnings("unchecked")
    public void serializationReadFile(){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(memberLibrary));
            memberList = (ArrayList<Member>)ois.readObject();
            ois.close();
        }catch(Exception e){
            e.printStackTrace();
}
}


}
