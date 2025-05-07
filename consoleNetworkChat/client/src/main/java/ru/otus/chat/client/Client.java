package ru.otus.chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Scanner scanner;
    private DataOutputStream out;
    private DataInputStream in;
    private Socket socket;

    public Client() throws IOException {
        scanner = new Scanner(System.in);
        socket = new Socket("127.0.0.1", 8087);
        out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(socket.getInputStream());
        try {
            new Thread(() -> {
                try {
                    while (true) {
                        String message = in.readUTF();
                        if (message.startsWith("/")) {
                            if (message.equals("/exitok")) {
                                break;
                            }
                            if (message.startsWith("/authok ")) {
                                System.out.println("Вы подключились под ником: " + message.split(" ")[1]);
                                continue;
                            }
                            if (message.startsWith("/regok ")) {
                                System.out.println("Вы успешно зарегистрировались и подключились под ником: " + message.split(" ")[1]);
                                continue;
                            }
                        }
                        System.out.println(message);
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    disconnect();
                }
            }).start();
            while (true) {
                String message = scanner.nextLine();
                out.writeUTF(message);
                if (message.equals("/exit")) {
                    break;

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
