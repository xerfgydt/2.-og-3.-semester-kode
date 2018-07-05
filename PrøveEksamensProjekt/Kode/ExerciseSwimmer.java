import java.util.*;
import java.io.*;

    public class ExerciseSwimmer extends Member implements java.io.Serializable{

        public ExerciseSwimmer(String firstName, String lastName, int age, String cpr, String membership){
        super (firstName, lastName, age, cpr, membership);
    }
    public String ToString(){
        return firstName + lastName + age + cpr + membership;
    }

    
}

