import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;

public class UDP_Server {

    private static final int PORT = 2345;

    private static final byte[] buf = new byte[256];

    private static void createUDPServer(int port){
        try{
            DatagramSocket serverSocket = new DatagramSocket(port);
            System.out.println("Server started");
            int last_msg_int = -1;
            while (true) {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                serverSocket.receive(packet);
                int msg_load_int = ByteBuffer.wrap(packet.getData()).getInt();
                if(last_msg_int+1 != msg_load_int) {
                    System.out.println("Error");
                    msg_load_int++;
                } else {
                    System.out.println(msg_load_int);
                }
                last_msg_int = msg_load_int;
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        createUDPServer(PORT);
    }
}
