import java.util.*;
import java.io.*;

public class EDB{
    public static void main(String[]args){
        
    ArrayList<Discipline> d = new ArrayList<Discipline>();
    
    Member m = new Member("firstname", "lastName", 175, "CPR", "Membership");
    Coach co = new Coach();
    President p = new President();
    Cashier ca = new Cashier();

    p.serializationReadFile();
    ca.serializationReadFile();
     String optionInput;
            Scanner scan = new Scanner(System.in);
            System.out.println();
            System.out.println("This is the Main Menu. Choose an option to continue");    
            do{
                System.out.println();   
                System.out.println("(1) for president options");
                System.out.println("(2) for cashier options");
                System.out.println("(3) coach options for specific Elite Swimmers");
                System.out.println("(q) Exit");
                    optionInput = scan.nextLine();
                    switch (optionInput){
                        case "1":
                            p.presidentOptions(ca);
                            break;
 
                        case "2":
                            ca.cashierOptions(p);
                            break;
                
                        case "3":
                            co.updateEliteSwimmer(ca);
                            break;
                        case "q":
                            break;    
                
                        default:
                            System.out.println();
                            System.out.println("not a valid option");
                                break;
 

                    }
    
        }while(!optionInput.equals("q"));
        ca.serializationWriteTofile();
        p.serializationWriteTofile();
}

}
