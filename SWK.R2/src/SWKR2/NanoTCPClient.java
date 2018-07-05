package SWKR2;

import java.io.InputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class NanoTCPClient {



    public static void main(String[] args) {
        try { String ip = InetAddress.getLocalHost().getHostAddress();
            // ip = "192.168.0.4";
            System.out.println("opretter forbindelse...");
            Socket socket = new Socket(ip, 5555);
            System.out.println("har oprettet forbindelse.");

            //sender besked til server
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("indtast besked...");
            Scanner keyboardInput = new Scanner(System.in);
            pw.println(keyboardInput.nextLine());
            //pw.println("besked afsluttet");

            InputStream inputStream = socket.getInputStream();

            Scanner scanner = new Scanner(inputStream);
            String message = scanner.nextLine();
            System.out.println(message);

            System.out.println(ip);

        }catch (Exception e){

        }
    }
}