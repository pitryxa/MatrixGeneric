package matrix;

import java.util.Random;
import java.util.stream.IntStream;

public class RandomMatrix<T> extends BaseMatrix<T> {

    public RandomMatrix(int rows, int cols) {
        super(rows, cols);
        this.matrix = fill(T.)
    }

    public BaseMatrix<Integer> fillInteger(IntStream ints) {
        int[] arr = ints.toArray();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int index = i * cols + j;
                matrix[i][j] = arr[index];
            }
        }
        return (BaseMatrix<Integer>) this;
    }

    public BaseMatrix<Integer> fillInteger(int origin, int bound) {
        Random rnd = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rnd.nextInt(bound - origin) + origin;
            }
        }
        return (BaseMatrix<Integer>) this;
    }

    public BaseMatrix<Integer> fillInteger() {
        Random rnd = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rnd.nextInt();
            }
        }
        return (BaseMatrix<Integer>) this;
    }
}
