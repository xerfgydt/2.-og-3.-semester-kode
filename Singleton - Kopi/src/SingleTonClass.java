public class SingleTonClass {

    private static SingleTonClass obj= new SingleTonClass();
    private SingleTonClass(){
// en privat konstruktør gør at den ikke kan tilgås fra andre
    }
    public static SingleTonClass objectCreationMethod(){
// gør at der kun kan være 1 Singletonclass

        return obj;
    }
    public void display(){
        System.out.println("this is Singleton");
    }
}




  /*if (obj == null){
           // laver Synchronize så der kun er plads til 1 thread
            synchronized (SingleTonClass.class){
                if (obj == null){
                    obj = new SingleTonClass();
                }
            }
        }
*/