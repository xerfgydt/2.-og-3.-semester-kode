import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MultiChatServer {
    private Map<Socket,PrintWriter> socketMap = new HashMap<>();

    public static void main(String[] args) {
        MultiChatServer multiChatServer = new MultiChatServer();

    }

    public MultiChatServer(){
        try{
            ServerSocket serverSocket = new ServerSocket(6780);
            System.out.println("Klar til at modtage besked");
            while(true){
                Socket socket= serverSocket.accept(); // blokere
                System.out.println("Har modtaget besked fra klient");
                socketMap.put(socket,new PrintWriter(socket.getOutputStream()));

                ClientHandler clientHandler = new ClientHandler(socket,this);
                //Thread thread = new Thread(clientHandler); // en ny seperate proces(i Clienthandler) som kører uafhængig af main thread
                //thread.start();


            }

            }catch(Exception e){

            }
    }

    public void sendToAll(String message) {
        for(Map.Entry<Socket,PrintWriter> entry:socketMap.entrySet()){
            entry.getValue().println(message);

        }
    }
}
