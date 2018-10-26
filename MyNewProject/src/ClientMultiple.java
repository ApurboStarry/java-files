import java.net.*;
import java.io.*;
import java.util.*;

public class ClientMultiple {

    public static void main(String[] args) {
        try{
            Scanner scn = new Scanner(System.in);
            InetAddress ip = InetAddress.getByName("localhost");
            Socket socket = new Socket(ip,5056);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            while(true){
                System.out.println(dis.readUTF());
                String toSend = scn.nextLine();
                dos.writeUTF(toSend);
                if(toSend.equals("Exit")){
                    System.out.println("Closing the connection : "+socket);
                    socket.close();
                    System.out.println("Connection closed");
                    break;
                }
                String recieved = dis.readUTF();
                System.out.println(recieved);
            }
            scn.close();
            dis.close();
            dos.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
