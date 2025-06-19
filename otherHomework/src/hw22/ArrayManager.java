package hw22;

import java.util.Arrays;

public class ArrayManager {
    public static int[] elementsAfterLastOne(int[] array) {
        int lastOneIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                lastOneIndex = i;
            }
        }
        if (lastOneIndex == -1) {
            throw new RuntimeException("В массиве нет единиц");
        }
        return Arrays.copyOfRange(array, lastOneIndex + 1, array.length);
    }

    public static boolean checkArrayForOnlyOneAndTwo(int[] array) {
        boolean hasOne = false;
        boolean hasTwo = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                hasOne = true;
            } else if (array[i] == 2) {
                hasTwo = true;
            } else {
                return false;
            }
        }
        return hasOne && hasTwo;
    }

}
