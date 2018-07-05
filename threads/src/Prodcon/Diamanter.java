package Prodcon;

public class Diamanter {
    private int count = 0;
    public synchronized void inc() {
        try {
            while (count >= 5) {
                wait();
            }
            // her ventes og lyttes efter notifyAll()
            count = count + 1;
            System.out.print("inc: " + count + " ");
            notifyAll(); // signalere til consumer at der er én diamant mere

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




    public synchronized void dec(){
            try {
                while (count<= 0){
                    wait();
                }   // her ventes og lyttes efter notifyAll()
                    count = count - 1;
                    System.out.print("dec: " + count + " ");
                    notifyAll(); // signalere til consumer at der er én diamant mere
                }

            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }



