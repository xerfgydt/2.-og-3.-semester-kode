import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) {
        try{
            DatagramSocket dgs = new DatagramSocket(6780);

            System.out.println("socket created...");

            byte[] receiveArr = new byte[1024];

            DatagramPacket datagramPacket = new DatagramPacket(receiveArr,receiveArr.length);

            dgs.receive(datagramPacket);

            String message = new String(receiveArr,0,datagramPacket.getLength()); // dette giver kun længden af beskeden og så stopper den for resten af de 1024 bytes
            System.out.println("Recieved from 'client': " + message);



        }catch (Exception e){

        }
    }
}
