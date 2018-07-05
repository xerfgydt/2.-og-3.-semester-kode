import java.util.*;
import java.io.*;

public class Database{
    
     private File movieLibary = new File("MovieLibary.txt"); 

     @SuppressWarnings("unchecked")

     public void readFromMovieFile(ArrayList<Movie> movieList){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(movieLibary));
            movieList = (ArrayList<Movie>)ois.readObject();
            ois.close();
        }catch(Exception e){
             e.printStackTrace();
        } 
     }

     public void addToMovieFile(ArrayList<Movie> movieList){

         try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(movieLibary));
            oos.writeObject(movieList);
            oos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
     }

     public void addToHistoryFile(ArrayList<Movie> historyList){

     }
     public void addToFavoriteFile(ArrayList<Movie> favoriteList){

     }

     public void print(){
         System.out.println(movieLibary);
     }
}
