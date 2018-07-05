import java.util.*;
import java.io.*;

public class App{

    public static void main(String[]args){
        
        File costumerLibary = new File("costumerLibary.txt");
        Scanner scan = new Scanner(System.in);

        ArrayList<Movie> movieList = new ArrayList<Movie>();        
        ArrayList<Customer> costumerList = new ArrayList<Customer>();
        ArrayList<Actor> actorList = new ArrayList<Actor>();
        
        Actor a = new Actor("Name", "Role");
        Movie m = new Movie("Title", 0000, "Genre", actorList);
        Customer c = new Customer("UserName", "Code");
        Database d = new Database();
        
        String input;

        d.readFromMovieFile(movieList);
        do{
            System.out.println("1: login");
            System.out.println("2: register");
            
            input = scan.nextLine();
            switch(input){

                case "1":

                while (c.login(costumerList) == null){
                    c.login(costumerList);
                     System.out.println("du har logget ind og kommer forbi her i koden");
                }


                break;
               
                case "2":

                    c.register(costumerLibary, costumerList);

                break;

                

                case "6571":
                    String adminInput;
                    do{
                        System.out.println("1: Create Movie");
                        System.out.println("2: Delete Movie");

                        adminInput = scan.nextLine();
                        switch(adminInput){

                            case "1":

                                String exit = "";
                                    while(!exit.equals("n")){
                                    m.addToMovieList();
                                    movieList.add(new Movie(m.getMovieTitle(), m.getProdYear(), m.getGenre(), a.addToActorList()));
                                    System.out.println("wanna add another movie? Y/N");
                                    exit = scan.nextLine();
                                    } 

                            break;
                            
                            case "2":

                            m.deleteMovie(movieList);
                            
                            break;
                        }
                    }
                    while(!adminInput.equals("q"));
                    
                    
               break;
            }
        }
        while(!input.equals("q"));

d.addToMovieFile(movieList);
         
    }
}