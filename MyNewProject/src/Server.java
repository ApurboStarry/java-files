import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Server extends JFrame{
    private JTextField userText;
    private JTextArea chatWindow;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private ServerSocket server;
    private Socket connection;

    //constructor
    public Server() {
        super("Apurbo's Instant Messenger");
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
        add(userText, BorderLayout.SOUTH);
        chatWindow = new JTextArea();
        add(new JScrollPane(chatWindow));
        setSize(500, 300);
        setVisible(true);
    }

    //setup and run the server
    public void startRunning() {
        try {
            server = new ServerSocket(6789, 100);
            while (true) {
                try {
                    //connect and have conversation
                    waitForConnection();
                    setupStreams();
                    whileChatting();
                } catch (EOFException eof) {
                    showMessage("\n Server ended the connection");
                } finally {
                    closeCrap();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //wait for connection and then display connection information
    private void waitForConnection() throws IOException{
        showMessage(" Waiting for someone to connect\n");
        connection = server.accept();
        showMessage(" Now connected to "+connection.getInetAddress().getHostName());
    }

    //get stream to send and receive data
    private void setupStreams() throws IOException{
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush();
        input = new ObjectInputStream(connection.getInputStream());
        showMessage("\n Streams are now setup!\n");
    }

    //while chatting and conversation
    private void whileChatting() throws IOException{
        String message = "You are connected now";
        sendMessage(message);
        ableToType(true);
        do{
            try{
                message = (String)input.readObject();
                showMessage("\n" + message);
            }catch (ClassNotFoundException cls){
                showMessage("I don't know what user has sent");
            }

        }while(!message.equals("CLIENT - END"));
    }

    //close streams and sockets after you are done chatting
    private void closeCrap(){
        showMessage("\nclosing connections");
        ableToType(false);
        try{
            input.close();
            output.close();
            connection.close();
        }catch(IOException io){
            io.printStackTrace();
        }
    }

    //send a message to a client
    private void sendMessage(String message){
        try{
            output.writeObject("SERVER - "+message);
            output.flush();
            showMessage("\nSERVER - "+message);
        }catch(IOException io){
            showMessage("\nERROR : Dude I cannot display the message");
        }
    }

    //updates chat window
    private void showMessage(final String text){
        SwingUtilities.invokeLater(
            new Runnable(){
                public void run(){
                    chatWindow.append(text);
                }
            }
        );
    }

    //let the user type stuff into their box
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
