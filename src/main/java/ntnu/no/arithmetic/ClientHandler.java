package ntnu.no.arithmetic;

import java.net.*;
import java.io.*;

public class ClientHandler extends Thread {
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());

            double num1 = dis.readDouble();
            double num2 = dis.readDouble();
            char operator = dis.readChar();
            Thread.sleep(1000); // 1 second delay

            double result = 0;
            switch (operator) {
                case 'A':
                    result = num1 + num2;
                    break;
                case 'S':
                    result = num1 - num2;
                    break;
                case 'M':
                    result = num1 * num2;
                    break;
                case 'D':
                    if (num2 != 0) {
                        result = num1 / num2;
                    }
                    break;
            }

            dos.writeDouble(result);

            clientSocket.close();
            dis.close();
            dos.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}