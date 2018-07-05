import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static String[] row1;
    static String[] row2;
    static String[] row3;

    public static void main(String[] args) throws Exception {


        //String ip = InetAddress.getLocalHost().getHostAddress();
        String ip = "localhost";
        Socket socket = new Socket(ip, 5555);

        InputStream inputStream = socket.getInputStream();



        row1 = new String[3];
        row2 = new String[3];
        row3 = new String[3];

        row1[0] = "1";
        row1[1] = "2";
        row1[2] = "3";
        row2[0] = "4";
        row2[1] = "5";
        row2[2] = "6";
        row3[0] = "7";
        row3[1] = "8";
        row3[2] = "9";


        BufferedReader buffOut = new BufferedReader(new InputStreamReader(inputStream));
        BufferedReader buffIn = new BufferedReader(new InputStreamReader(System.in));

        OutputStream outputStream = socket.getOutputStream();

        PrintWriter printWriter = new PrintWriter(outputStream, true);



        while (true) {
            if (buffOut.ready()) { // Modtager fra Server

                // der laves et string objekt af buffOut(altså det man modtog fra Server)
                int choice = Integer.parseInt(buffOut.readLine());

                System.out.println("Server Chose This Spot " + choice);

                // if else spørger om man modtog et tal fra 1-9 og sætter et X ind på tilsvarende plads hvis det er tilfældet
                // herefter printes det nye "bord"
                if (choice == 1 || choice == 2 || choice == 3) {
                    row1[choice - 1] = "X";
                    //System.out.println(row1[0] + " " + row1[1] + " " + row1[2]);
                    //System.out.println(row2[0] + " " + row2[1] + " " + row2[2]);
                    //System.out.println(row3[0] + " " + row3[1] + " " + row3[2]);
                    printboard();
                } else if (choice == 4 || choice == 5 || choice == 6) {
                    row2[choice - 4] = "X";
                    printboard();

                } else if (choice == 7 || choice == 8 || choice == 9) {
                    row3[choice - 7] = "X";
                    printboard();

                }
            }


            if (buffIn.ready()) { // Sender til Server

                // laver string objekt af buffIn (altså det man skriver)
                int choice2 = Integer.parseInt(buffIn.readLine());
                System.out.println("Client Chose this Spot " + choice2);
                // forespørger om det man skrev var et tal mellem 1-9 og sætter et O ind på den tilsvarende plads hvis det er rigtigt
                // hvorefter det opdateret "bord" bliver printet
                if(choice2 == 1 || choice2 == 2 || choice2 == 3){
                    row1[choice2 -1] = "O";
                    printboard();
                }else if (choice2 == 4 || choice2 == 5 || choice2 == 6 ){
                    row2[choice2 - 4] = "O";
                    printboard();

                }else if (choice2 == 7 || choice2 == 8 || choice2 == 9 ){
                    row3[choice2 - 7] = "O";
                    printboard();

                }

                // her sendes det man skrev til Server
                printWriter.println(choice2);



            }

            Thread.sleep(1000);
        }

    }
    public static void printboard(){
        System.out.println(row1[0]+ " " + row1[1] + " " + row1[2]);
        System.out.println(row2[0]+ " " + row2[1] + " " + row2[2]);
        System.out.println(row3[0]+ " " + row3[1] + " " + row3[2]);

    }
}

