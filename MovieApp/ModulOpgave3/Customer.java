import java.util.*;
import java.io.*;

import java.util.ArrayList;


public class Customer{
    
    private ArrayList<Movie> historyList; 
    private ArrayList<Movie> favoriteList; 
    private String loginName;
    private String loginCode;
    

    public Customer(String loginName, String loginCode){
        this.historyList = new ArrayList<Movie>();
        this.favoriteList = new ArrayList<Movie>();
        this.loginName = loginName;
        this.loginCode = loginCode;

    }

    public void deleteFavorite(){

    }

    public void addFavorite(){

    }
    public void addToHistList(){

    }
    
    public Customer login(ArrayList<Customer> customerList){
        Scanner scan = new Scanner(System.in);

            System.out.println("Enter UserName?");
            String userName = scan.nextLine();
            System.out.println("Enter Code?");
            String code = scan.nextLine();

        for (Customer c : customerList){
            System.out.println(c.getLoginName());
            if ( userName.equals(loginName) && code.equals(loginCode)){
                System.out.println("hallo!" + loginName);
                return c;
            }         
        } 
        System.out.println("please try again");
        return null;

    }



//         try{
//             Scanner scan = new Scanner(System.in);
//             Scanner scan1 = new Scanner(new File("costumerLibary.txt"));
//             boolean login = false;

            // System.out.println("Enter UserName?");
            // String userName = scan.nextLine();
            // System.out.println("Enter Code?");
            // String code = scan.nextLine();
        
//                 while(scan1.hasNext() && login == false){ 
//                     if(scan1.next().equals(userName)){
//                         if(scan1.next().equals(code)){
//                             System.out.println("Hallo! " + userName);
// return custe.get(username)
//                             login = true;
//                             System.out.println("Choosen an Option");
//                             System.out.println("(1) Display MovieList");
//                             System.out.println("(2) Display FavoriteList");
//                             System.out.println("(3) Display HistoryList");
//                             System.out.println("(4) Search for Movie");
//                             System.out.println("(q) GET OUT");

//                             String optionChoice = scan.nextLine();

//                             switch(optionChoice)


                        
//                         }
//                     }
                         
//                     else if (!scan1.hasNext()){
//                         System.out.println("Please try again.");
//                     }
//                 }
        // }catch(Exception e){
        //     System.out.println(e);
        // }
    
    public String getLoginName(){
        return loginName;
    }
    
    public String getLoginCode(){
        return loginCode;
    }


    public void register(File costumerLibary, ArrayList<Customer> costumerList){

        try{
                    Scanner scan = new Scanner(System.in);
                    Scanner scan1 = new Scanner(new File("costumerLibary.txt"));
                    //ArrayList<Customer> costumerList = new ArrayList<Customer>();

                    System.out.println("UserName?");
                    String userName = scan.nextLine();
                    System.out.println("Code?");
                    String code = scan.nextLine();
 
                        while(scan1.hasNextLine()){
                        costumerList.add(new Customer(scan1.next(), scan1.next()));   
                        }

                        PrintStream file = new PrintStream(new File("costumerLibary.txt"));
                        costumerList.add(new Customer(userName,code));
                        for(int i = 0; i < costumerList.size(); i++){  
                            file.print(costumerList.get(i).getLoginName() + " " + costumerList.get(i).getLoginCode());
                                if(i != costumerList.size() -1){
                                    file.println();
                            }
                        }
                        
                    }catch(Exception e)
                    {
                    System.out.println(e);
                    }
    }


}