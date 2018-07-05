import java.util.ArrayList;
import java.util.*;

public class Movie implements java.io.Serializable{
    
    private String title;
    private int prodYear; 
    private String genre;
    private ArrayList<Actor> actorList; 
    
    public Movie(String title, int prodYear, String genre, ArrayList<Actor> actorList){
        this.title = title;
        this.prodYear = prodYear;
        this.genre = genre;
        this.actorList = actorList;
    }

    public String getMovieTitle(){
        return title;
    }

    public int getProdYear(){
        return prodYear;
    }

    public String getGenre(){
        return genre;
    }

    public void addToMovieList(){
        Scanner scan = new Scanner(System.in);
            System.out.println("Title?");
            this.title = scan.nextLine();
            System.out.println("Genre?");
            this.genre = scan.nextLine();
            System.out.println("Year?");
            this.prodYear = Integer.parseInt(System.console().readLine());
    }

    public void deleteMovie(ArrayList<Movie> movieList){
        
        for(int i = 0; i < movieList.size(); i++) {
                    System.out.println("NR: " + i);
                    System.out.println(movieList.get(i));
                }        
                
                System.out.println("which movie");
                int deleteNr = Integer.parseInt(System.console().readLine());
                movieList.remove(deleteNr);
    }

    public String toString(){
        System.out.println("Title of Movie: " + title);
        System.out.println("Production Year of Movie: " + prodYear);
        System.out.println("Genre of Movie: " + genre);
        System.out.println();
        System.out.println("Actors in Movie:");
        System.out.println(actorList);
        System.out.println();
        return "";
    }
}