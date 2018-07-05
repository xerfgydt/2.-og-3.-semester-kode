import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {
        try{
            DatagramSocket dgs = new DatagramSocket();
            System.out.println("client: dgs created...");
            byte[] sendArr = "Greetings from Simon".getBytes();
            InetAddress address = InetAddress.getByName("192.168.0.2"); // "localhost" for at skrive til mig selv
            int port = 6780;
            DatagramPacket datagramPacket = new DatagramPacket(sendArr,sendArr.length,address,port);
            dgs.send(datagramPacket);
            System.out.println("arr length: " + sendArr.length);


        }catch(Exception e){

        }
    }
}
