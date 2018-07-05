public class Actor{
    private String actorName;
    private String actorRoles;


    public Actor(String actorName,String actorRoles){

    }

    public String getActorName(){
        return actorName;
    }
    public String getActorRoles(){
        return actorRoles;
    }

    public void addToActorList(){

    }
    public String toString(){
    return "Actor Name:  " + actorName + " in the role as:  " + actorRoles;
    }

    

}