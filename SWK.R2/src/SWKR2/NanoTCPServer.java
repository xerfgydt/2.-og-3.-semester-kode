package SWKR2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
// server skal kører før client for at client skal kunne oprette forbindelse til server.
//

public class NanoTCPServer {

    public static void main(String[] args) {
        try {

            System.out.println("Starter server op");
            ServerSocket serverSocket = new ServerSocket(5555);
            System.out.println("venter på client...");
            Socket socket = serverSocket.accept(); // blokerer


            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream, true);


            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader brIn = new BufferedReader(new InputStreamReader(System.in));

            printWriter.println("starter op");




            printWriter.println("Hello There!");

            // læser beskeder fra client
            Scanner scanner = new Scanner(socket.getInputStream());

            String inputLine = "";
            //brug buffereader
            String message = scanner.nextLine();
            while ((message = scanner.nextLine()) != null) {
                if (".".equals(message)) {
                    System.out.println("good bye");
                    break;
                }
                System.out.println(inputLine);
            }



            // besked 1

            System.out.println(message);



            // besked 2
            String message2 = scanner.nextLine();
            System.out.println(message2);

            // sender ny besked til client
            System.out.println("indtast svar tak...");
            Scanner keyboardInput = new Scanner(System.in);
            printWriter.println(keyboardInput.nextLine());





        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
