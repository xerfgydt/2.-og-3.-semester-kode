import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    static String[] row1;
    static String[] row2;
    static String[] row3;


    public static void main(String[] args)throws Exception{

        ServerSocket serverSocket = new ServerSocket(5555);
        Socket socket = serverSocket.accept(); //blokeret = venter på svar

        InputStream inputStream = socket.getInputStream();

        //deklarerer String arrays og giver hvad deres længde er og hvad der skal stå i dem



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

        PrintWriter printWriter = new PrintWriter(outputStream,true);

        while(true){

            if(buffOut.ready()) { // modtager fra client
                // laver et string objekt af buffout der blev modtaget fra Client
                int choice = Integer.parseInt(buffOut.readLine());

                System.out.println("Client Chose This Spot " + choice);
                // alle disse if else siger at hvis det der blev modtaget var et tal mellem 1-9 skal der sættes et O på den tilsvarende plads
                // og derefter skal det opdateret "bord" printes
                if (choice == 1 || choice == 2 || choice == 3) {
                    row1[choice - 1] = "O";
                    printboard();

                } else if (choice == 4 || choice == 5 || choice == 6) {
                    row2[choice - 4] = "O";
                    printboard();

                } else if (choice == 7 || choice == 8 || choice == 9) {
                    row3[choice - 7] = "O";
                    printboard();


                }
            }

            if(buffIn.ready()){ //sender til client

                // laver string objekt af buffin (altså det som server skriver)
                int choice2 = Integer.parseInt(buffIn.readLine());
                System.out.println("Server Chose this Spot " + choice2);
                // if else spørger om det man skrev var et tal fra 1-9 og i så tilfælde skal der sættes i X
                // på tilsvarende plads og det opdateret "bord" printes
                if(choice2 == 1 || choice2 == 2 || choice2 == 3){
                    row1[choice2 - 1] = "X";
                    printboard();
                }else if(choice2 == 4 || choice2 == 5|| choice2 == 6){
                    row2[choice2 - 4] = "X";
                    printboard();

                }else if (choice2 == 7 || choice2 == 8 || choice2 == 9 ){
                    row3[choice2 - 7] = "X";
                    printboard();

                }
                // her sendes det man skrev til Client
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