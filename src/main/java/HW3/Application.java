package HW3;

public class Application {
    public static void main(String[] args) {

    }

    private static int sumOfPositiveElements(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > 0) {
                    sum = sum + matrix[i][j];
                }
            }
        }
        return sum;
    }

    private static void printSquare(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("*  ");
            }
            System.out.println();
        }
    }

    private static void zeroDiagonal(int[][] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    array[i][j] = 0;
                }
            }
        }
    }

    private static int findMaxElement(int[][] matrix) {
        int max = matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }
        return max;
    }

    private static int sumSecondRow(int[][] matrix) {
        if (matrix.length < 2) {
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < matrix[1].length; i++) {
            sum = sum + matrix[1][i];
        }
        return sum;
    }
}
