package hw19;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();

        System.out.print("Введите последовательность символов: ");
        String textEl = scanner.nextLine();
        String fileText = readFile(fileName);
        System.out.println("Указанная последовательность встречается " +
                getCountInText(fileText, textEl) + " раз(а)");


    }

    private static String readFile(String fileName) {
        String result = "";
        try (BufferedReader bufferedReader =
                     new BufferedReader(new InputStreamReader(
                             new FileInputStream("./otherHomework/src/hw19/" + fileName),
                             StandardCharsets.UTF_8))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result += line;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }
    private static int getCountInText(String text, String textEl) {
        var a = text.split(textEl);
        return (text+=" ").split(textEl).length - 1;
    }
}
