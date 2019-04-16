package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStreamReader;

public class Main {



    public static void main(String[] args) throws Exception
    {

        SearchFile search = new SearchFile();

        System.out.println("iit homepage");
        ServerSocket serverSocket = new ServerSocket(4567);
        Socket socket = new Socket();
        socket = serverSocket.accept();

        DataInputStream din = new DataInputStream(socket.getInputStream());
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1="",str2="";

        while(true)
        {
            dout.writeUTF("1. get certificate\n2. see academic information\n");
            str1 = din.readUTF();
            System.out.println("client says : " + str1);

            if(str1.equals("1") )
            {
                dout.writeUTF("enter your registration number : ");
                String reg = din.readUTF();
                System.out.println("client says : " + reg);

                if(search.SearchInFile(reg)!=null)
                {
                    dout.writeUTF("your information is valid");
                }

                dout.writeUTF("enter your account number : ");
                String number = din.readUTF();
                System.out.println("client says : " + number);

                dout.writeUTF("enter your account password : ");
                String pin = din.readUTF();
                System.out.println("client says : " + pin);

                search.setFile("account.txt");
                String s1 = search.SearchInFile(number);
                String s2 = search.SearchInFile(pin);

                if(s1 != null && s2!= null)
                {
                    dout.writeUTF("account found");
                    String[] temp = s1.split(",");
                    double balance = Double.parseDouble(temp[2]);
                    dout.writeUTF("your current balance is " + balance);

                    if(balance < 100)
                    {
                        dout.writeUTF("you don't have enough money");
                    }

                    else
                    {
                        balance -= 100;
                        String newTxt = temp[0] + "," +temp[1] + "," + Double.toString(balance);
                        Replace rp =new Replace("account.txt");
                        rp.replace(temp[0],newTxt);

                        Certificate c = new Certificate();
                        c.writeCertificate(temp[0]);
                    }

                }
            }
            else if(str1.equals("2") )
            {
                dout.writeUTF("enter your registration number or roll number");
                str2 = din.readUTF();

                SearchFile searchit = new SearchFile("academic.txt");
                String temp = searchit.SearchInFile(str2);
                String[] words = temp.split(",");

                dout.writeUTF("registration number: "+ words[0]+"\n");
                dout.writeUTF("session: "+ words[1]+"\n");
                dout.writeUTF("semester: "+ words[2]+"\n");
                dout.writeUTF("year: "+ words[3]+"\n");
                dout.writeUTF("cgpa: "+ words[4]+"\n");
                dout.writeUTF("class-roll: "+ words[5]+"\n");
                dout.writeUTF("\n\n\n");

            }
        }


    }
}
