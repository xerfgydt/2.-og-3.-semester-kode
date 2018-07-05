public class SingleTonClient{

public static void main(String args[]){
// den prøver at lave et object men er nødt til at bruge metoden
// som kun laver et single object pga private konstruktor
        SingleTonClass myobject= SingleTonClass.objectCreationMethod();
        myobject.display();
        }
}
