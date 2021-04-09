package pacman.com;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    public static void main(String[] args) throws Exception{
        String sentenceFromClient;
        String sentenceToClient;
         // Tao socket server tai cong 1234
        ServerSocket serverSocket = new ServerSocket(1234);

        while(true){
             //chờ yêu cầu từ client
            Socket socket = serverSocket.accept();
             // tao input stream noi toi socket
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             // tao output stream noi toi socket
            DataOutputStream outToClient = new DataOutputStream(socket.getOutputStream());

            // doc thong tin tu client
            sentenceFromClient = inFromClient.readLine();
            sentenceToClient = sentenceFromClient + "  server accept " +"\n";

             // ghi du lieu ra socket
             outToClient.writeBytes(sentenceToClient);
             return;

        }
    }
}
