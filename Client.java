package client;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        System.out.println("client is trying to connect");

        Socket socket = new Socket("localhost",4567);

        DataInputStream din = new DataInputStream(socket.getInputStream());
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1="",str2=" ";

        while(true)
        {
            str2 = din.readUTF();
            System.out.println("server says : " + str2);

            str1 = br .readLine();
            dout.writeUTF(str1);


        }



    }
}
