package hw13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8091);
        System.out.println("SERVER APP STARTED!");
        while (true) {
            Socket client = socket.accept();
            DataInputStream inputStream = new DataInputStream(client.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
            System.out.println("Клиент с портом " + client.getPort() + " подключился к серверу");
            String userInput = inputStream.readUTF();
            System.out.println(userInput);
            if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Клиента с портом " + client.getPort() + " отключили от сервера");
                client.close();
                continue;
            }
            String result = calculate(userInput);
            outputStream.writeUTF(result);
            outputStream.flush();
        }
    }

    private static String calculate(String userInput) {
        String[] parts = userInput.trim().split(" ");
        double a = Double.parseDouble(parts[0]);
        String op = parts[1];
        double b = Double.parseDouble(parts[2]);
        switch (op) {
            case "+": return String.valueOf(a + b);
            case "-": return String.valueOf(a - b);
            case "*": return String.valueOf(a * b);
            case "/": return String.valueOf(a / b);
            default: return null;
        }
    }
}
