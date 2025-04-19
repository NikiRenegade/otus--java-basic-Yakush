package hw12;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        File[] files = getListTextFiles();
        File file = chooseFile(files);
        readFile(file);
        writeInFile();

    }
    private static File[] getListTextFiles() {
        File currentDir = new File("./src/main/java/hw12/Files");
        File[] files = currentDir.listFiles();
        System.out.println("Доступные txt файлы:");
        for (File file : files) {
            System.out.println(file.getName());
        }
        return files;
    }

    private static File chooseFile(File[] files) {
        System.out.println("\n------------------------------------------------------------------");
        System.out.print("Введите имя файла, с которым хотите работать: ");
        String fileName = new Scanner(System.in).nextLine();

        for (File file : files) {
            if (file.getName().equals(fileName)) {
                return file;
            }
        }
        return null;
    }

    private static void readFile(File file) {
        System.out.println("Содержимое файла:");
        try (InputStreamReader in = new InputStreamReader(new FileInputStream(file))) {
            int symbol = in.read();
            while (symbol != -1) {
                System.out.print((char)symbol);
                symbol = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeInFile() {
        System.out.println("\n\n------------------------------------------------------------------");
        System.out.print("Введите строки для записи в файл: ");
        String data = new Scanner(System.in).nextLine();
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("./src/main/java/hw12/Files/4.txt"))) {
            byte[] buffer = data.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < buffer.length; i++) {
                out.write(buffer[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
