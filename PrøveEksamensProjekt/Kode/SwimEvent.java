import java.util.*;
import java.io.*;

public class SwimEvent implements java.io.Serializable{

    private String eventName;
    private String placement;
    private String time;
    


    public SwimEvent(String eventName, String placement, String time){
        this.eventName = eventName;
        this.placement = placement;
        this.time = time;
    }


    public String getPlacement(){
        return placement;
    }

    public String getTime(){
        return time;
    }

    public String getEventName(){
        return eventName;
    }    

    public void displayEvent(){
         System.out.println();   
         System.out.println("The eventName was " + eventName);
         System.out.println("The Placment was " + placement + " place");
         System.out.println("The Best time Was " + time + " Seconds");
    }

    public String toString(){
       
        return eventName + placement + time;
    }
}