import java.util.*;
import java.io.*;

public class Actor implements java.io.Serializable{
    
    private String name;
    private String role;

    public Actor(String name, String role){
        this.name = name;
        this.role = role;
    }

    public String getName(){
        return name;
    }

    public String getRole(){
        return role;
    }

    public String toString(){
        return name + " as " + role;
    }
}