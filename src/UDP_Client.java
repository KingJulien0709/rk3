import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;

public class UDP_Client {
    private static final int PORT = 2345;
    private static final String HOST = "localhost";

    private static void createUDPClient(){
        try{
            DatagramSocket socket = new DatagramSocket();
            InetAddress address = InetAddress.getByName(HOST);
            for(int i = 0; i < 1000001; i++) {
                byte[] buf = ByteBuffer.allocate(4).putInt(i).array();
                DatagramPacket packet = new DatagramPacket(buf, buf.length,address, PORT);
                socket.send(packet);
                Thread.sleep(0);
            }
            socket.close();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        createUDPClient();
    }
}
