import java.util.*;
import java.io.*;

public class Discipline implements java.io.Serializable{
    private String category;
    private Training training;
    private ArrayList<SwimEvent> comHistList;


    public Discipline(String category){
        this.category = category;
        this.training = new Training("Result", "Date");
        this.comHistList = new ArrayList<SwimEvent>();
    }

    public String getCategory(){
        return category;
    }

    public Training getTraining(){
        return training;
    }

    public ArrayList<SwimEvent> getComHistList(){
        return comHistList;
    }
    
    public void setTraining(String result, String date){
        training = new Training(result, date);
    }

    public void addToComHistList(String eventName, String placement, String time){
        comHistList.add(new SwimEvent(eventName, placement, time));
}
    public String Tostring(){
        return category + training;
} 

    public void displayC(){
        System.out.println();
        System.out.println("Category: " + category);
    }

    public void diplayEvetnList(){
        for(SwimEvent se: comHistList){
            if (comHistList == null){
                System.out.println("This member havent ben to any events");
            }
            else{
                se.displayEvent();
            }
        }
    }

}