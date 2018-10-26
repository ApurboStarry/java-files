import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Client extends JFrame {
    private JTextField userText;
    private JTextArea chatWindow;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private String message = "";
    private String serverIP;
    private Socket connection;

    public Client(String host){
        super("Client mofo");
        userText = new JTextField();
        userText.setEditable(false);
        userText.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        sendMessage(e.getActionCommand());
                        userText.setText("");
                    }
                }
        );
        add(userText,BorderLayout.SOUTH);
        chatWindow = new JTextArea();
        add(new JScrollPane(chatWindow),BorderLayout.CENTER);
        setSize(500,300);
        setVisible(true);
    }

    //connect to server
    public void startRunning(){
        try{
            connectToServer();
            setupStreams();
            whileChatting();
        }catch (EOFException eof){
            showMessage("\nCLIENt terminated connection");
        }catch (IOException io){
            io.printStackTrace();
        }finally{
            closeCrap();
        }
    }

    //connect to server
    private void connectToServer() throws IOException{
        showMessage("\nAttempting connection....\n");
        connection = new Socket(InetAddress.getByName(serverIP),6789);
        showMessage("Connected to : "+connection.getInetAddress().getHostName());
    }

    //setup streams to send and receive messages
    private void setupStreams() throws IOException{
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input = new ObjectInputStream(connection.getInputStream());
        showMessage("\nDude your streams are now good to go\n");
    }

    //while chatting with server
    private void whileChatting(){
        ableToType(true);
        do{
            try{
                message = (String) input.readObject();
                showMessage("\n" + message);
            }catch (ClassNotFoundException cof){
                showMessage("\nI don't know that object type");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }while(!message.equals("SERVER - END"));
    }

    //close the streams and sockets
    private void closeCrap(){
        showMessage("\nClosing crap down");
        ableToType(false);
        try{
            input.close();
            output.close();
            connection.close();
        }catch(IOException io){
            io.printStackTrace();
        }
    }

    //send messages to server
    private void sendMessage(String message){
        try{
            output.writeObject("\nCLIENT - "+message);
            output.flush();
            showMessage("\nCLIENT - "+message);
        }catch(IOException io){
            chatWindow.append("\nsomething messed up sending message hoss!");
        }
    }

    //change or update chat window
    private void showMessage(final String m){
        SwingUtilities.invokeLater(
                new Runnable(){
                    public void run(){
                        chatWindow.append(m);
                    }
                }
        );
    }

    //gives user permission to type into the text box
    private void ableToType(final boolean tof){
        SwingUtilities.invokeLater(
                new Runnable(){
                    public void run(){
                        userText.setEditable(tof);
                    }
                }
        );
    }
}

















