package hw13;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try (Socket socket = new Socket("localhost", 8091)) {
                ExampleClient exampleClient = new ExampleClient(socket.getInputStream(), socket.getOutputStream());
                System.out.print("Введите выражение, пробел должен являться разделителем (или введите exit): ");
                String userMessage = scanner.nextLine();
                exampleClient.send(userMessage);
                if (userMessage.equalsIgnoreCase("exit")) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
