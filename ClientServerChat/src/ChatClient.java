import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) throws IOException {

        String text, message;
        String ip = InetAddress.getLocalHost().getHostAddress();
        Scanner scanner = new Scanner(System.in);
        Socket socket = new Socket(ip,5555);
        Scanner scanner1 = new Scanner(socket.getInputStream());

        System.out.println("indtast text");
        text = scanner.nextLine();

        PrintStream p = new PrintStream(socket.getOutputStream());
        p.print(text);

        message = scanner1.nextLine();
        System.out.println(message);
    }
}
