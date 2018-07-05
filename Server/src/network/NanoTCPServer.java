package network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NanoTCPServer {


    public static void main(String[] args)throws Exception{

            ServerSocket serverSocket = new ServerSocket(5555);
            Socket socket = serverSocket.accept(); //blokeret = venter på svar

            InputStream inputStream = socket.getInputStream();

            BufferedReader buffOut = new BufferedReader(new InputStreamReader(inputStream));
            BufferedReader buffIn = new BufferedReader(new InputStreamReader(System.in));

            OutputStream outputStream = socket.getOutputStream();


            PrintWriter printWriter = new PrintWriter(outputStream,true);
            //printWriter.println(" hello fra server");

            //outputStream.write(97); // 97 = A

            while(true){
                if(buffOut.ready())
                System.out.println(buffOut.readLine());

                if(buffIn.ready()){
                    printWriter.println(buffIn.readLine());
            }
                Thread.sleep(1000);
            }



           // Scanner scanner = new Scanner(inputStream);
            //String message = scanner.nextLine();
            //System.out.println(message);
            // den svare først når client svarer



        }
    }

