package matrix;

import java.util.Random;
import java.util.stream.IntStream;

public class Matrix<T> implements Cloneable {
    protected final int rows;
    protected final int cols;
    protected Object[][] matrix;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new Object[rows][cols];
    }

    public Matrix(Object[][] inputMatrix) {
        this.matrix = inputMatrix;
        this.rows = inputMatrix.length;
        this.cols = inputMatrix[0].length;
    }

    public Object[][] toArray() {
        return matrix;
    }

    public T get(int row, int col) {
        return (T) matrix[row][col];
    }

    public void put(int row, int col, T data) {
        matrix[row][col] = data;
    }

    public T[] getRow(int row) {
        return (T[]) matrix[row];
    }

    public T[] getCol(int col) {
        Object[] data = new Object[rows];
        for (int i = 0; i < rows; i++) {
            data[i] = matrix[i][col];
        }
        return (T[]) data;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < rows; i++) {
            if (i != 0)
                sb.append(" ");
            sb.append("[");
            for (int j = 0; j < cols; j++) {
                sb.append(matrix[i][j]);
                if (j != cols - 1)
                    sb.append(", ");
            }
            sb.append("]");
            if (i != rows - 1)
                sb.append(",\n");
            else
                sb.append("]\n");
        }
        return sb.toString();
    }

    public Matrix<T> clone() {
        Object[][] data = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(matrix[i], 0, data[i], 0, cols);
        }
        return new Matrix<>(data);
    }

    public int hashCode() {
        int hashCode = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Object e = matrix[i][j];
                hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
            }
        }
        return hashCode;
    }

    public Matrix<Integer> fillInteger(IntStream ints) {
        int[] arr = ints.toArray();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int index = i * cols + j;
                matrix[i][j] = arr[index];
            }
        }
        return (Matrix<Integer>) this;
    }

    public Matrix<Integer> fillInteger(int origin, int bound) {
        Random rnd = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rnd.nextInt(bound - origin) + origin;
            }
        }
        return (Matrix<Integer>) this;
    }

    public Matrix<Integer> fillInteger() {
        Random rnd = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rnd.nextInt();
            }
        }
        return (Matrix<Integer>) this;
    }

    public int size() {
        return rows * cols;
    }

    public int rows() {
        return rows;
    }

    public int cols() {
        return cols;
    }
}

