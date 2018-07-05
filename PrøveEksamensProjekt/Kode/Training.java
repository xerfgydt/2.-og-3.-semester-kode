import java.util.*;
import java.io.*;

public class Training implements java.io.Serializable{
    private String result;
    private String date;

    public Training(String result, String date){
    this.result = result;
    this.date = date;
    }
    
    public String getResult(){
        return result;
    }
    public String getDate(){
        return date;
    }
    public void setResult(String result){
        this.result = result;
    }

    public void setDate(String date){
        this.date = date;
    }
    public String toString(){
    return result + date;
    }

    public void displayTraining(){
        System.out.println();
        System.out.println("Best Training time was: " + result + " seconds on Date: " + date);
        
    } 

}