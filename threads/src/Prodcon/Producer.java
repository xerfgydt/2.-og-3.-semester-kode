package Prodcon;

import java.util.Random;

public class Producer implements Runnable {
    private Diamanter diamanter;

    public Producer(Diamanter diamanter) {
        this.diamanter = diamanter;
    }

    @Override
    public void run(){
        while (true){
            diamanter.inc();
            System.out.println("har tilføjet en diamant");
            Random random = new Random();
            try {
                Thread.sleep(random.nextInt(1000));
            }catch (Exception e){

            }



    }
    // 1.tilføj en diamant hvis der er færre end 5
        //      2.Udskriv "har tilføjet en diamant "
        //      3. og sleep derefter i 500ms

        // 4.vent hvis der er 5.
}
}
