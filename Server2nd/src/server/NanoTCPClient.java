package server;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class NanoTCPClient {

    public static void main(String[] args) throws Exception {


        //String ip = InetAddress.getLocalHost().getHostAddress();
        String ip = "localhost";
        Socket socket = new Socket(ip, 5555);

        InputStream inputStream = socket.getInputStream();


        BufferedReader buffOut = new BufferedReader(new InputStreamReader(inputStream));
        BufferedReader buffIn = new BufferedReader(new InputStreamReader(System.in));

        OutputStream outputStream = socket.getOutputStream();

        PrintWriter pw = new PrintWriter(outputStream, true);


        while (true) {
            if (buffOut.ready())
                System.out.println(buffOut.readLine());

            if (buffIn.ready()) {
                pw.println(buffIn.readLine());
            }
            Thread.sleep(1000);
        }





    }
    }

