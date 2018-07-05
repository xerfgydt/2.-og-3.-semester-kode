package messageobject;

import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ObjectServer {
    public static void main(String[]args){
        try{
            ServerSocket serverSocket = new ServerSocket(6780);
            Socket socket = serverSocket.accept();
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Message message = (Message) objectInputStream.readObject();
            message.verify();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream.close();
            objectOutputStream.close();
            socket.close();

        }catch(Exception e){

        }
    }
}
