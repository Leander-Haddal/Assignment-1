package ntnu.no.arithmetic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SingleThreadedServer {
    private int port;

    public SingleThreadedServer(int port) {
        this.port = port;
    }

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandler.run(); // Handle client in the main thread
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SingleThreadedServer server = new SingleThreadedServer(1234);
        server.start();
    }
}