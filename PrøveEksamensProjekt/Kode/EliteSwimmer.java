import java.util.*;
import java.io.*;

public class EliteSwimmer extends Member implements java.io.Serializable{

    File newDisciplineLibrary = new File("newDisciplineLibrary.txt");
    private String team;
    private ArrayList<Discipline> disciplineList;

    public EliteSwimmer(String firstName, String lastName, int age, String cpr, String membership,String team){
        super (firstName, lastName, age, cpr, membership);
        this.team = team;
        this.disciplineList = new ArrayList<Discipline>();
    }
    
    public void addDisciplineToDisciplineList(String category){
        disciplineList.add(new Discipline(category));
}

    public Discipline getDiscipline(String category){
        for (Discipline d : disciplineList){
            if (category.equals(d.getCategory())){
                return d;
            }    
        }
        return null;
    }   
    public void displayAllDisciplines(){
        for (Discipline d : disciplineList){
                if(disciplineList == null){
                    System.out.println("This member does not have any diciplines!! ");
                }else{
                    System.out.println();
                    System.out.println("Discipline: " + d.getCategory());
                    d.diplayEvetnList();

                }
        }
    }   

@SuppressWarnings("unchecked")
    public void serializationWriteTofile(){
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(newDisciplineLibrary));
            oos.writeObject(disciplineList);
            oos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

@SuppressWarnings("unchecked")
    public void serializationReadFile(){
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(newDisciplineLibrary));
            disciplineList = (ArrayList<Discipline>)ois.readObject();
            ois.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
public String Tostring(){
    return firstName + lastName + age + cpr + membership;
}

public void displayEliteSwimmer(){
    super.displayMember();
    System.out.println("TEAM AWESOME " + team);

}

public void displayName(){
    System.out.println();
    System.out.println("Name: " + firstName + " " + lastName);
    System.out.println("Team: " + team);
}


}