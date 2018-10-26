import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyClient1 {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        try{
            Socket s=new Socket("127.0.0.1",6666);
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            String in;
            in = scn.nextLine();
            while(!in.equals("Over")){
                dout.writeUTF(in);
                in = scn.nextLine();
            }
            dout.writeUTF("Terminated");
            dout.flush();
            dout.close();
            s.close();
        }catch(Exception e){System.out.println("Chatting Over");}
    }
} 