import java.util.*;
import java.io.*;

public class App{
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);

        ArrayList<Actor> a = new ArrayList<Actor>();

        Database d = new Database();
        Movie m = new Movie("Title", "Genre", 0000, a);
        Customer c = new Customer("Username", "LoginCode");
        App app = new App();
        // d.readFromCostumerList();
        d.readCustomerFromFile();
        d.readFromMovieFile();
        String optionInput;
        do{
            
            System.out.println();
            System.out.println("Login Menu - choose to Login or Register");
            System.out.println("1: Login");
            System.out.println("2: Register");
            System.out.println("3: Quit");

            optionInput = scan.nextLine();
            switch(optionInput){
                case "1": 

                    String userName;
                    String code;
                    
       
                        System.out.println("Enter UserName?");
                        userName = scan.nextLine();
                        System.out.println("Enter code?");
                        code = scan.nextLine();
                 
                    if(d.login(userName, code) == null){
                        break;
                    }    
                    
                    app.userOption(d.login(userName, code));                                     

                    String userInput;
                    do{   

                        System.out.println("1. Search for a movie");
                        System.out.println("2. Display all movies");
                        System.out.println("3. Display favouriteList");
                        System.out.println("4. Remove movie from favouriteList");
                        System.out.println("5. Display historyList");
                        System.out.println("6. Quit to Login Menu");

                        userInput = scan.nextLine();
                        switch(userInput){
                
                //MAIN MENU - Main Menu Options
                            case "1":
                                c.play(d.searchForMovie(), d.login(userName, code));
                                // d.addFavouriteListFile(d.login(userName, code));
                                // d.addHistorieListFile(d.login(userName, code));
                            break;
                            case "2":
                                d.displayMovieList();
                            break;
                            case "3":
                                c.displayFavoriteList(d.login(userName, code));
                            break;
                            case "4":
                                c.deleteMovie(d.login(userName, code));
                            break;
                            case "5":
                                c.displayHistoryList(d.login(userName, code));
                            break;
                        }
                    }
                    while(!userInput.equals("6"));
                break;

               // LOGIN MENU - Register option 
                case "2":
                    d.register();
                break;

                // LOGIN MENU - admin option
                case "112":
                    String adminInput;
                    do{
                        System.out.println();
                        System.out.println("1: Create Movie");
                        System.out.println("2: Delete Movie");
                        System.out.println("3: Display MovieList");                         
                        System.out.println("4: Back to Login Menu");                         

                        adminInput = scan.nextLine();
                        switch(adminInput){

                            // ADMIN OPTION - Create Movie
                            case "1":
                                d.setMovieList();
                            break;

                            // ADMIN OPTION - delete movie
                            case "2":
                                d.deleteMovie();
                            break;
                            // ADMIN OPTION - Display movielist
                            case "3":
                                d.displayMovieList();
                            break;
                        }
                    }
                    while(!adminInput.equals("4"));
                break;
            }
        }
        while(!optionInput.equals("3"));
        d.addMovieToFile();
        d.addCustomerToFile();
    }

    public void userOption(Customer c){
                System.out.println("");
                System.out.println("Hallo! " + c.getUserName());
                System.out.println("");
                System.out.println("FavoriteList: " + c.getFavoriteList().size());
                System.out.println("HistoryList: " + c.getHistoryList().size());
                System.out.println("");
    }
}