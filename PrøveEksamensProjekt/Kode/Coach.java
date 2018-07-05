import java.util.*;
import java.io.*;

public class Coach{
    
    
    
    public void updateEliteSwimmer(Cashier c){
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.print("Please enter the cpr of your choosen one: ");
        
        String cpr = scan.nextLine();
            
            if (c.getMember(cpr)== null){
                System.out.println();
                System.out.println("No match of Elite Swimmer was found");
            }
            else{

            
                String optionInput;
            do {
                System.out.println();
                System.out.println("Choosen on of the following: ");
                System.out.println("(1) Set up a discipline for the list of disciplines");
                System.out.println("(2) Record the results for a recent event");
                System.out.println("(3) Update the training result");
                System.out.println("(4) Display list of events");
                System.out.println("(5) Display trainingresults");
                System.out.println("(q) Will get you the hell out of here");
        
                optionInput = scan.nextLine();
            switch (optionInput){
                
            case "1":
                setDiscipline(c.getEliteSwimmer(cpr));
                    break;
            case "2":
                setEventResult(c.getEliteSwimmer(cpr)); 
                    break;
            case "3":
                updateTrainingResult(c.getEliteSwimmer(cpr));
                    break;
            case "4":
                diplayEvents(c.getEliteSwimmer(cpr));
                break;
            case "5":
                seeTrainingresult(c.getEliteSwimmer(cpr));
                break;
            case "q":
                break;
            
            default:
                System.out.println();
                System.out.println("Dimwit, stop TROLLIN");
            
                    break;
        
            }
            }while(!optionInput.equals("q"));

            }
}
    
    
    public void setDiscipline(EliteSwimmer el){
        Scanner scan = new Scanner(System.in);
        
        System.out.println();
        System.out.print("Please enter a new Discipline to add to the members Discipline list: ");
        String category = scan.nextLine();
        el.addDisciplineToDisciplineList(category);

        System.out.println();
        System.out.println("The category: " + category + " was added to the list of disciplines ");

        System.out.println();
        System.out.print("Please enter the Elite Swimmers best training result for the Discipline: ");
        String result = scan.nextLine();

        System.out.println();
        System.out.print("Please enter the date of the best training result: ");

        String date = scan.nextLine();
        el.getDiscipline(category).setTraining(result, date);

        System.out.println();
        System.out.println("Results archived (x_X)");

        el.displayName();
        el.getDiscipline(category).displayC();
        el.getDiscipline(category).getTraining().displayTraining(); 

    }
    
    public void displayMember(EliteSwimmer el){
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.print("Please enter the category you want results from: ");
        String category = scan.nextLine();
        if (el.getDiscipline(category) == null){
            System.out.println("The member is not registered in that disciplin ");
        }
        else{
        
        el.displayName();
        el.getDiscipline(category).getTraining().displayTraining();
        }
    }


    public void setEventResult(EliteSwimmer el){
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.print("Please enter the category of the event: ");
        String category = scan.nextLine();
        if (el.getDiscipline(category) == null){
            System.out.println("The member is not registered in that disciplin ");
        }
        else{

        System.out.println();
        System.out.print("Please enter the name of the event: ");
        String eventName = scan.nextLine();

        System.out.println();
        System.out.print("Please enter the placement of the Elite Swimmer: ");
        String placement = scan.nextLine(); 

        System.out.println();
        System.out.print("Please enter the Time for the Elite Swimmer: ");
        String time  = scan.nextLine();
        el.getDiscipline(category).addToComHistList(eventName, placement, time);

        System.out.println();
        System.out.println("The Achivements have now been recorded (-.-)");
        System.out.println();
        }
    }
    
    public void updateTrainingResult(EliteSwimmer el){
    Scanner scan = new Scanner(System.in);
    System.out.println();
    System.out.print("Please enter the new Discipline: ");
    String category = scan.nextLine();
        if (el.getDiscipline(category) == null){
            System.out.println("The member is not registered in that disciplin ");
        }
        else{

    System.out.println();
    System.out.print("Please enter the Results: ");
    String result = scan.nextLine();

    System.out.println();
    System.out.print("Please enter the date: ");
    String date = scan.nextLine();
    el.getDiscipline(category).setTraining(result, date);

    System.out.println();
    System.out.println("Training results have been updated (^v^)");

    
    el.displayName();
    el.getDiscipline(category).getTraining().displayTraining();
    }
}

public void seeTrainingresult(EliteSwimmer el){
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.print("Please enter the discipline: ");
        String category = scan.nextLine();
        if (el.getDiscipline(category) == null){
            System.out.println("The member is not registered in that disciplin ");
        }
        else{
        el.displayName();
        el.getDiscipline(category).getTraining().displayTraining();
        }
}

public void diplayEvents(EliteSwimmer el){

         el.displayAllDisciplines();
   
}
}




