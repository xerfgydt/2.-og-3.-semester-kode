public class RunThreads {

    public static void main(String[] args) {
        SimpelThreads simpelThreads = new SimpelThreads();
        SimpelThreads simpelThreads2 = new SimpelThreads();
        // simpelThreads.run() // duer ikke
        Thread thread = new Thread(simpelThreads);
        thread.start();

        Thread thread2 = new Thread(simpelThreads2);
        thread2.start();
    }
}
