package hw1;
import java.util.Scanner;
import java.util.Random;
public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Введите число от 1 до 5:");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                greetings();
                break;
            case 2:
                checkSign((int)(Math.random() * 200-100), (int)(Math.random() * 200-100), (int)(Math.random() * 200-100));
                break;
            case 3:
                selectColor();
                break;
            case 4:
                compareNumbers();
                break;
            case 5:
                addOrSubtractAndPrint((int)(Math.random() * 200-100), (int)(Math.random() * 200-100), random.nextBoolean());
                break;
            default:
                System.out.println("Некорректный ввод. Введите число от 1 до 5.");
        }
    }

    public static void greetings() {
        System.out.println("Hello\nWorld\nfrom\nJava");
    }

    public static void checkSign(int a, int b, int c) {
        int sum = a + b + c;
        if (sum >= 0) {
            System.out.println("Сумма положительна");
        } else {
            System.out.println("Сумма отрицательна");
        }
    }

    public static void selectColor() {
        int data = new Random().nextInt(30);
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data <= 20) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = (int)(Math.random() * 100);
        int b = (int)(Math.random() * 100);
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        if (increment) {
            System.out.println(initValue + delta);
        } else {
            System.out.println(initValue - delta);
        }
    }
}
