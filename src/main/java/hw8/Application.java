package hw8;

public class Application {

    public static void main(String[] args) {

        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        String[][] invalidArrayData = {
                {"1", "2", "3", "4"},
                {"5", "6", "X", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        String[][] invalidArraySize = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        try {
            int result = SumArrayElements(validArray);
            System.out.println("Сумма всех элементов: " + result);
        } catch (AppArraySizeException | AppArrayDataException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
        try {
            int result = SumArrayElements(invalidArrayData);
            System.out.println("Сумма всех элементов: " + result);
        } catch (AppArraySizeException | AppArrayDataException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
        try {
            int result = SumArrayElements(invalidArraySize);
            System.out.println("Сумма всех элементов: " + result);
        } catch (AppArraySizeException | AppArrayDataException e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }

    public static int SumArrayElements(String[][] array) throws AppArraySizeException, AppArrayDataException {
        if (array.length != 4) {
            throw new AppArraySizeException("Массив должен быть 4x4");
        }
        for (int i = 0; i < 4; i++) {
            if (array[i].length != 4) {
                throw new AppArraySizeException("Массив должен быть 4x4");
            }
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException("В ячейке [" + i + "][" + j + "]: \"" + array[i][j] + "\" не является числом.");
                }
            }
        }

        return sum;
    }
}
