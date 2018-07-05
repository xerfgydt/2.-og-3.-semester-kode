import java.util.*;
import java.io.*;
 
public class President{
 
 
 
    private ArrayList<Member> newMemberList = new ArrayList<Member>();
    File newMemberLibrary = new File("newMemberLibrary.txt");
 
    public ArrayList<Member> getNewMemberList(){
        return newMemberList;
    }
    public void presidentOptions(Cashier c){
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("Choose your options");
        String optionInput;
        do{
            System.out.println();
            System.out.println("(1) to create new member");
            System.out.println("(2) to to update member");
            System.out.println("(3) to delete member");
            System.out.println("(q) to exit to main menu");
            
                optionInput = scan.nextLine();
            switch (optionInput){
                case "1":
                    createNewMember();
                break;
 
                case "2":
                    updateMember(c);
                break;
                
                case "3":
                    deleteMember(c);
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
 
    
 
public void createNewMember(){
    Scanner scan = new Scanner(System.in);
    String membership;
    String team;
    
    System.out.println();
    System.out.print("Type in Firstname ");
    String firstName = scan.nextLine();
    System.out.print("Type in Lastname ");
    String lastName = scan.nextLine();
    System.out.print("Type in Age ");
    
    int age = Integer.parseInt(System.console().readLine());
        if (age < 18){
            membership = "Junior ";
            team = "Junior"; 
        }
        else {
            membership = "Senior ";
            team = "Senior";
       }   
    System.out.print("Type in Cpr ");
    
    String cpr = scan.nextLine();
 

 
    while(true){
    System.out.println();    
    System.out.print("Type in memberType: 1 for EliteSwimmer or 2 for ExerciseSwimmer: ");
    
    String memberType = scan.nextLine();
        
        if (memberType.equals("1")){
            newMemberList.add(new EliteSwimmer(firstName,lastName,age,cpr,membership,team));
            System.out.println();
            System.out.println("New Elite Swimmer succesfully created");
            break;
        
        }
        else if (memberType.equals("2")){
            newMemberList.add(new ExerciseSwimmer(firstName,lastName,age,cpr,membership));
            System.out.println();
            System.out.println("New Exercise Swimmer succesfully created");
            break;
        }
        System.out.println();
        System.out.println("please try again");
        
    }
    
    }
 
public void updateMember(Cashier c){
    Scanner scan = new Scanner(System.in);
    System.out.println();
    System.out.print("Please enter the cpr of the member you want to update: ");
    
    String cpr = scan.nextLine();
        if (c.getMember(cpr)== null){
            System.out.println();
            System.out.println("You failed to find a member scrub! ");
            
        }
        else{
            
            String optionInput;
        do{
            System.out.println();
            System.out.println("Choosen one of the following or press q to quit: ");
            System.out.println("Press 1 to update first name: ");
            System.out.println("Press 2 to update last name: ");
            System.out.println("Press 3 to update age: ");
            System.out.println("Press 4 to update cpr: ");
            
            optionInput = scan.nextLine();
        
            switch (optionInput){
                
                case "1":
                    c.getMember(cpr).setFirstName();
                        break;
 
                case "2":
                    c.getMember(cpr).setLastName();
                    break;
 
                case "3":
                    c.getMember(cpr).setAge();
                        break;
 
                case "4":
                    c.getMember(cpr).setCpr();
                        break;
            }
            }while(!optionInput.equals("q"));
        }
}

 
public void deleteMember(Cashier c){
    Scanner scan = new Scanner(System.in);
    System.out.println();
    System.out.print("Please enter the cpr of the member you want to delete ");
    
    String cpr = scan.nextLine();
        
        if (c.getMember(cpr)== null){
            System.out.println();
            System.out.println("You did not find a member! ");
            
        }
        else{
            c.getMember(cpr).displayMember();
            System.out.println();
            System.out.print("Are you sure you want to delete this member? y/n ");
            
            String answer = System.console().readLine();
                if (answer.equals("y")){
                    c.getMemberList().remove(c.getMember(cpr));
                    System.out.println();
                    System.out.println("You chose to delete the member");
                    
                }
                else if(answer.equals("n")){
                    System.out.println();
                    System.out.println("You chose not to delete this member ");
                     
                }
                else{
                    System.out.println();
                    System.out.println(" You hit the wrong key and failed to delete member");
                    
                }
        }
}
 
 @SuppressWarnings("unchecked")
    public void serializationWriteTofile(){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(newMemberLibrary));
            oos.writeObject(newMemberList);
            oos.close();
        }catch(Exception e){
            e.printStackTrace();
    }
}
 
@SuppressWarnings("unchecked")
    public void serializationReadFile(){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(newMemberLibrary));
            newMemberList = (ArrayList<Member>)ois.readObject();
            ois.close();
        }catch(Exception e){
            e.printStackTrace();
}
}
    
    
 
}
 

