import java.util.*;
import java.io.*;

public class Movie implements java.io.Serializable{

    private String title;
    private String genre;
    private int year;
    private ArrayList<Actor> actorList;

    public Movie(String title, String genre, int year, ArrayList<Actor> actorList){
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.actorList = actorList;
    }

    public String getTitle(){
        return title;
    }

    public String getGenre(){
        return genre;
    }

    public int getYear(){
        return year;
    }


    public ArrayList<Actor> getActorList(){
         return actorList;
    }

    public String toString(){
        System.out.println();
        System.out.println("Title of Movie: " + title);
        System.out.println("Production Year of Movie: " + year);
        System.out.println("Genre of Movie: " + genre);
        System.out.println();
        System.out.println("Actors in Movie:");
        System.out.println(actorList);
        return "";
    }
}