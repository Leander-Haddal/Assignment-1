package ntnu.no.arithmetic;

import java.net.*;
import java.io.*;

public class Server {
    private int port;

    public Server(int port) {
        this.port = port;
    }

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server(1234);
        server.start();
    }
}