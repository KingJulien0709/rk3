
import java.io.*;
import java.net.*;
public class TCP_Server {


    private static final int PORT = 2345;
    private static final String HOST = "localhost";

    private void createServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started");
            int last_msg_int = -1;
            while (true) {

                Socket socket = serverSocket.accept();
                DataInputStream in = new DataInputStream(socket.getInputStream());

                System.out.println("Client accepted");
                int msg_load_int;
                while(true) {
                    msg_load_int = in.readInt();
                    if(last_msg_int+1 != msg_load_int) {
                        System.out.println("Error");
                    } else {
                        System.out.println(msg_load_int);
                    }
                    last_msg_int = msg_load_int;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        TCP_Server server = new TCP_Server();
        server.createServer();
    }
}