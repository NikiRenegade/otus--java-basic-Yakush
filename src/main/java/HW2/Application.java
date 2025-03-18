package HW2;

public class Application {
    public static void main(String[] args) {

    }

    private static void printStringMultiple(int count, String str) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

    private static void sumGreaterThanFive(int[] array) {
        int sum = 0;
        for (int num : array) {
            if (num > 5) {
                sum += num;
            }
        }
        System.out.println("Сумма чисел больше 5: " + sum);
    }

    private static void fillArray(int number, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = number;
        }
    }

    private static void increaseArrayElements(int number, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] += number;
        }
    }

    private static void compareHalvesArray(int[] array) {
        int arrayMiddle = array.length / 2;
        int sumFirstHalf = 0;
        int sumSecondHalf = 0;
        for (int i = 0; i < arrayMiddle; i++) {
            sumFirstHalf += array[i];
        }
        for (int i = arrayMiddle; i < array.length; i++) {
            sumSecondHalf += array[i];
        }
        if (sumFirstHalf > sumSecondHalf) {
            System.out.println("Сумма первой половины больше.");
        } else if (sumFirstHalf < sumSecondHalf) {
            System.out.println("Сумма второй половины больше.");
        } else {
            System.out.println("Сумма обеих половин равна.");
        }
    }

}
