import java.io.*;
import java.text.*;
import java.net.*;
import java.util.*;

public class ServerMultiple {
    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(5056);

        while(true){
            Socket s =null;
            try{
                s = ss.accept();
                System.out.println("A new client has connected");
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                System.out.println("Assigning new thread for the client" );
                Thread t = new ClientAndler(s,dis,dos);
                t.start();
            }catch(Exception i){
                s.close();
                System.out.println(i);
            }
        }

    }
}

class ClientAndler extends Thread{
    DateFormat forDate = new SimpleDateFormat("dd/mm/yyyy");
    DateFormat forTime = new SimpleDateFormat("hh:mm:ss");
    DataInputStream dis;
    DataOutputStream dos;
    Socket s;

    public ClientAndler(Socket s, DataInputStream dis,DataOutputStream dos){
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }

    String recieved,toReturn;
    @Override
    public void run(){
        while(true){
            try{
                dos.writeUTF("What do you want : Time or Date?\nEnter Exit to terminate");
                recieved = dis.readUTF();
                if(recieved.equals("Exit")){
                    System.out.println("Client "+this.s+" sent Exit");
                    System.out.println("Closing this connection");
                    s.close();
                    System.out.println("Connection closed");
                }
                Date date = new Date();
                switch (recieved){
                    case "Date" :
                        toReturn = forDate.format(date);
                        dos.writeUTF(toReturn);
                        break;
                    case "Time" :
                        toReturn = forTime.format(date);
                        dos.writeUTF(toReturn);
                        break;
                    default:
                        dos.writeUTF("Invalid input");
                        break;
                }
            }catch (IOException i){
                System.out.println(i);
            }
            try {
                this.dos.close();
                this.dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}











