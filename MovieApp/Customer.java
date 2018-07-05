import java.util.ArrayList;


public class Customer{
    
    private ArrayList<Movie> historyList; 
    private ArrayList<Movie> favoriteList; 
    private String loginName;
    private String loginCode;

    public Customer(String loginName, String loginCode){
        this.historyList = new ArrayList<Movie>();
        this.favoriteList = new ArrayList<Movie>();
    } 
    
    public void deleteFavorite(){

    }

    public void addFavorite(){

    }
    public void addToHistList(){

    }
    public void checkLoginName(String loginName){

    }
    public String getLoginName(){
        return loginName;
    }
    public void checkLoginCode(){

    }
    public String getLoginCode(){
        return loginCode;
    }


}