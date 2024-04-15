package ntnu.no;

import ntnu.no.arithmetic.Client;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("localhost", 1234, 10, 20, 'A'));
        clients.add(new Client("localhost", 1234, 300, 40, 'S'));
        clients.add(new Client("localhost", 1234, 500, 60, 'M'));
        clients.add(new Client("localhost", 1234, 700, 80, 'D'));

        
        long startTime = System.currentTimeMillis();

        
        for (Client client : clients) {
            client.start();
        }

        
        for (Client client : clients) {
            try {
                client.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        
        long endTime = System.currentTimeMillis();

        
        long totalTime = endTime - startTime;
        System.out.println("Total time " + totalTime);
    }
}