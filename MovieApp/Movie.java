import java.util.ArrayList;
public class Movie{
    
    private String title;
    private int prodYear;
    private ArrayList<Actor> actorList = new ArrayList<Actor>(); 
    private String genre; 
    
    public Movie(String title, int prodYear, ArrayList<Actor> actorList, String genre){

    }

    public String getMovieTitle(){
        return title;
    }

    public int getProdYear(){
        return prodYear;
    }

    public ArrayList<Actor> getActorList(){
        return actorList;
    }

    public String getGenre(){
        return genre;
    }

    public void createMovie(){

    }

    public void deleteMovie(Movie movie){

    }
    public String toString(){
        System.out.println("Title of Movie: " + title);
        System.out.println("Production Year of Movie: " + prodYear);
        System.out.println("Actors in Movie: " + actorList );
        System.out.println("Genre of Movie: " + genre);
    return "";
    }


}