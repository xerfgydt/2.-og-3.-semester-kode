import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
    public static void main(String[] args) throws IOException {

        String text, message;
        ServerSocket serverSocket1 = new ServerSocket(5555);
        System.out.println("Starter server op...");
        Socket ss = serverSocket1.accept();
        System.out.println("venter på svar fra client...");
        Scanner scanner = new Scanner(ss.getInputStream());
        text = scanner.nextLine();

        message = text + " skrevet i server";

        PrintStream p = new PrintStream(ss.getOutputStream());
        p.println(message);



    }
}
