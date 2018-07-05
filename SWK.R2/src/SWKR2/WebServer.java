package SWKR2;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WebServer {

  /*
1.forb.
2.modtage req
3. parse
4. læs fil
5. send fil
6. luk
 */

    static String path = System.getProperty("user.dir") + "/"; // giver roden til projektmappen
    public static void main(String[] args){
        try{
            ServerSocket serverSocket = new ServerSocket(6500);
            while(true){
                System.out.println("Server starter op");
                Socket socket = serverSocket.accept();
                System.out.println("Forbindelse oprettet");
                Scanner requestScanner = new Scanner(socket.getInputStream());
                String requestLine = requestScanner.nextLine();
                StringTokenizer stringTokenizer = new StringTokenizer(requestLine);
                String fileName = "";
                DataOutputStream DOS = new DataOutputStream(socket.getOutputStream());
                if(stringTokenizer.nextToken().equals("GET")){
                    String fileString = stringTokenizer.nextToken();
                    if(fileString.startsWith("/")){
                        fileName = fileString.substring(1);
                    }
                    if(fileString.endsWith("/")){
                        fileName = path + "index.html";
                    }
                    File file = new File(fileName);
                    if(!file.isFile()){
                        System.out.println("bad request");
                        fileName = path + "error404.html";
                    }
                    int numBytes = (int)file.length(); // caster til en int da det er en long
                    byte[] fileArray = new byte[numBytes];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    fileInputStream.read(fileArray,0,numBytes);
                    fileInputStream.close();

                    DOS.writeBytes("HTTP/1.0 200 OK\r\n"); // r\n skal være der fordi det er gammelt og skal bare være der
                    if(fileName.endsWith(".jpg")){
                        DOS.writeBytes("Content-Type:image/jpeg\r\n");
                    }
                    if(fileName.endsWith(".gif")){
                        DOS.writeBytes("Content-Type:image/gif\r\n");
                    }
                    DOS.writeBytes("Content-Length:"+ numBytes + "\r\n");
                    DOS.writeBytes("\r\n");// dette er et krav fra protokollen. det skal bare være der.
                    DOS.write(fileArray, 0 ,numBytes); // her sendes filen
                    DOS.writeBytes("\r\n");
                }
                else{
                    System.out.println("bad request (not a GET)");
                    DOS.writeBytes("HTTP/1.0 400 unkown request, what are you doing?");
                    DOS.writeBytes("\r\n");
                }
                DOS.close();
                socket.close();//lukker dem når man er færdig

            }
        }catch (IOException e) {
            e.printStackTrace();
        } {
        }
    }

}
