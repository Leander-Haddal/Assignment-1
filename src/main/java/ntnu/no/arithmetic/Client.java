package ntnu.no.arithmetic;

import java.net.*;
import java.io.*;

public class Client extends Thread {
    private String host;
    private int port;
    private double num1;
    private double num2;
    private char operator;

    public Client(String host, int port, double num1, double num2, char operator) {
        this.host = host;
        this.port = port;
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }

    public void run() {
        try {
            
            Socket socket = new Socket(host, port);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());
    
            
            dos.writeDouble(num1);
            dos.writeDouble(num2);
            dos.writeChar(operator);
    
            
            double result = dis.readDouble();
            System.out.println("Result: " + result);
    
            
            dos.close();
            dis.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}