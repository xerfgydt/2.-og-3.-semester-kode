import java.util.*;
import java.io.*;

public class Actor implements java.io.Serializable{
    private String actorName;
    private String actorRole;

    public Actor(String name,String role){
        this.actorName = name;
        this.actorRole = role;
    }

    public String getActorName(){
        return actorName;
    }
    public String getActorRoles(){
        return actorRole;
    }

    public ArrayList<Actor> addToActorList(){
        Scanner scan = new Scanner(System.in);
        ArrayList<Actor> actorList = new ArrayList<Actor>();
            System.out.println("Actors?");
            int actorAmount = Integer.parseInt(System.console().readLine());                
                for(int i = 0; i < actorAmount; i++){
                    System.out.println("Name?");
                    this.actorName = scan.nextLine();
                    System.out.println("Role");
                    this.actorRole = scan.nextLine();
                    actorList.add(new Actor(actorName, actorRole));
        }
        return actorList;
    }
    
    public String toString(){
    return "Name:  " + actorName + "  as:  " + actorRole;
    }

    

}