import java.util.*;
import java.io.*;

public class Customer implements java.io.Serializable{
    
    private String userName;
    private String loginCode;
    private ArrayList<Movie> historyList; 
    private ArrayList<Movie> favoriteList;

    public Customer(String userName, String loginCode){
        this.userName = userName;
        this.loginCode = loginCode;
        this.historyList = new ArrayList<Movie>();
        this.favoriteList = new ArrayList<Movie>();
    }

    public String getUserName(){
        return userName;
    }

    public String getLoginCode(){
        return loginCode;
    }

    public ArrayList<Movie> getHistoryList(){
        return historyList;
    }
    
    public ArrayList<Movie> getFavoriteList(){
        return favoriteList;
    }

//PLAY MOVIE!!!!!!!!
    public void play(Movie movie, Customer c){
        
        if(movie == null){
            System.out.println();
             System.out.println("No Result");
              System.out.println();
        }
        else{

        Scanner scan = new Scanner(System.in);
        System.out.println("Do you wanna watch this movie: y/n");
        String play = scan.nextLine();
            if (play.equals("y")){        
                c.getHistoryList().add(movie);

                System.out.println("");
                System.out.println("THE END");
                System.out.println("Actors in the Movie");
                System.out.println();
                for(Actor a : movie.getActorList()){
                System.out.println(a);
                }

                System.out.println("");
                System.out.println("");
                System.out.println("Do you wanna add this movie to your favoriteList y/n");
                String addToFavorite = scan.nextLine(); 
                if (addToFavorite.equals("y")){
                    c.getFavoriteList().add(movie);
                }              
            }   
        }   
    }

    public void displayFavoriteList(Customer c){

        for(int i = 0; i < c.getFavoriteList().size(); i++) {
            System.out.println();
            System.out.println("NR: " + i);
            System.out.println(c.getFavoriteList().get(i));
            System.out.println("----------------------------------");
        }
            if (c.getFavoriteList().size() < 1){
        System.out.println();
        System.out.println("You have no movies on your favoriteList");
        System.out.println();
        }
    } 

    public void deleteMovie(Customer c){
        
        for(int i = 0; i < c.getFavoriteList().size(); i++) {
            System.out.println("NR: " + i);
            System.out.println(c.getFavoriteList().get(i));
        }        
            if (c.getFavoriteList().size() > 0){
        System.out.println("which movie");
        int deleteNr = Integer.parseInt(System.console().readLine());
        System.out.println();
        c.getFavoriteList().remove(deleteNr);
            }
            else {
                System.out.println();
                System.out.println("You have no movies on your favoriteList");
                System.out.println();
            }
    } 

    public void displayHistoryList(Customer c){
        for(int i = 0; i < c.getHistoryList().size(); i++) {
            System.out.println("NR: " + i);
            System.out.println(c.getHistoryList().get(i));
            System.out.println("----------------------------------");
        }  
            if (c.getHistoryList().size() > 0){
        System.out.println("Do you want to clear your historyList? y/n");
        String clear = System.console().readLine();
                if (clear.equals("y")){
                    c.getHistoryList().clear();
                }                
            }
            else {
                System.out.println();
                System.out.println("Your historyList is Empty");
                System.out.println();
            }
    } 
}