package hw11;

public class Application {
    public static void main(String[] args) {

    }
    public static void bubbleSort(int[] array) {
        boolean swapp = false;
        for (int i = 0; i < array.length - 1; i++) {
            swapp = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapp = true;
                }
            }
            if (!swapp) break;
        }
    }
}
