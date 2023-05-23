import java.io.*;
import java.net.*;

public class TCP_Client {

    private static final int PORT = 2345;
    private static final String HOST = "localhost";

    private void createClient(int port, String host){
        try{
            Socket socket = new Socket(host, port);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            for(int i = 0; i < 1000001; i++) {
                out.writeInt(i);
                out.flush();
            }
            out.close();
            socket.close();

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        TCP_Client client = new TCP_Client();
        client.createClient(PORT, HOST);
    }
}
