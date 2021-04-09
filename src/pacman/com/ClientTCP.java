package pacman.com;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientTCP {
    public static void main(String[] args) throws Exception {
        String sentenceFromServer;
        String sentenceToServer;

        // tao input stream( tu ban phim)
        System.out.println("Input from client: " );
        BufferedReader dataFromUser = new BufferedReader(new InputStreamReader(System.in));

        //doc du lieu tu ban phim
        sentenceToServer = dataFromUser.readLine();
        // tao socket cho client noi den server qua IP address va port number
        Socket clientSocket = new Socket("127.0.0.1", 1234);

        // tao output stream
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
         //tao input stream
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        //gui chuoi ki tu tu server thong qua outputStream da noi voi socket
        outToServer.writeBytes(sentenceToServer+"\n");

         //doc data tu server thong qua input da noi voi socket
        sentenceFromServer = inFromServer.readLine();


        //print ket qua ra man hinh
        System.out.println("From server: "+sentenceFromServer);

        //dong socket
        clientSocket.close();


        //



    }
}
