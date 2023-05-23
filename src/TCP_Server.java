
import java.io.*;
import java.net.*;
public class TCP_Server {


    private static final int PORT = 2345;
    private static final String HOST = "loacalhost";//"10.21.36.108";

    private static void createServer(int port){
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started");
            int last_msg_int = -1;
            while (true) {

                Socket socket = serverSocket.accept();
                DataInputStream in = new DataInputStream(socket.getInputStream());

                System.out.println("Client accepted");
                int msg_load_int = -1;
                while(msg_load_int<1000001) {
                    msg_load_int = in.readInt();
                    if(last_msg_int+1 != msg_load_int) {
                        System.out.println("Error");
                        msg_load_int++;
                    } else {
                        System.out.println(msg_load_int);
                    }
                    last_msg_int = msg_load_int;
                }
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    public static void main(String[] args) {
       createServer(PORT);
    }
}