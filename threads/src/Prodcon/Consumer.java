package Prodcon;

import java.util.Random;

public class Consumer implements Runnable {
    private Diamanter diamanter;

    public Consumer(Diamanter diamanter) {
        this.diamanter = diamanter;
    }

    @Override
    public void run() {
        while (true) {
            diamanter.dec();
            System.out.println("har taget en diamant");
            Random random = new Random();
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (Exception e) {

            }
        }
        // 1.tag en diamant hvis der er nogen
        //      2.Udskriv "har taget en diamant "
        //      3. og sleep derefter i 500ms

        // 4.vent hvis der ikke er nogen.
    }
}
