package matrixgeneric;

import java.util.Objects;

public class Matrix<T extends Number> implements Cloneable {
    protected final int rows;
    protected final int cols;
    protected T[][] matrix;

    @SuppressWarnings("unchecked")
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = (T[][]) new Number[rows][cols];
    }

    public Matrix(T[][] extArray) {
        this.matrix = extArray;
        this.rows = extArray.length;
        this.cols = extArray[0].length;
    }

    public Matrix(Matrix<T> extMatrix) {
        this.rows = extMatrix.rows;
        this.cols = extMatrix.cols;
        this.matrix = extMatrix.matrix;
    }

    public T[][] toArray() {
        return matrix;
    }

    public T get(int row, int col) {
        return matrix[row][col];
    }

    public void put(int row, int col, T data) {
        matrix[row][col] = data;
    }

    public T[] getRow(int row) {
        return matrix[row];
    }

    @SuppressWarnings("unchecked")
    public T[] getCol(int col) {
        T[] data = (T[]) new Number[rows];
        for (int i = 0; i < rows; i++) {
            data[i] = matrix[i][col];
        }
        return data;
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

    @SuppressWarnings("unchecked")
    public Matrix<T> clone() {
        T[][] data = (T[][]) new Number[rows][cols];
        Matrix<T> m = null;
        try {
            m = (Matrix<T>) super.clone();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    m.put(i, j, this.matrix[i][j]);
                }
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return m;
    }

    public int hashCode() {
        int hashCode = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                T e = matrix[i][j];
                hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
            }
        }
        return hashCode;
    }

    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Matrix)) {
            return false;
        }

        Matrix<T> other = (Matrix<T>) o;
        if (this.size() != other.size() || this.rows != other.rows) {
            return false;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!Objects.equals(this.matrix[i][j], other.matrix[i][j])) {
                    return false;
                }
            }
        }

        return true;
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
