package matrix;

import java.util.Objects;

public abstract class BaseMatrix implements Matrix {
    protected final int rows;
    protected final int cols;
    protected Object[][] matrix;

    public BaseMatrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new Object[rows][cols];
    }

    public BaseMatrix(Object[][] inputMatrix) {
        this.matrix = inputMatrix;
        this.rows = inputMatrix.length;
        this.cols = inputMatrix[0].length;
    }

    @Override
    public Object[][] toArray() {
        return matrix;
    }

    @Override
    public Object get(int row, int col) {
        return matrix[row][col];
    }

    @Override
    public void put(int row, int col, Object data) {
        matrix[row][col] = data;
    }

    @Override
    public Object[] getRow(int row) {
        return (Object[]) matrix[row];
    }

    @Override
    public Object[] getCol(int col) {
        Object[] data = new Object[rows];
        for (int i = 0; i < rows; i++) {
            data[i] = matrix[i][col];
        }
        return (Object[]) data;
    }

    @Override
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

    @Override
    public Matrix clone() {
        Object[][] data = new Object[rows][cols];
        Matrix m = null;
        try {
            m = (Matrix) super.clone();
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

    @Override
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

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof BaseMatrix)) {
            return false;
        }

        BaseMatrix other = (BaseMatrix) o;
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

    @Override
    public int size() {
        return rows * cols;
    }

    @Override
    public int rows() {
        return rows;
    }

    @Override
    public int cols() {
        return cols;
    }
}

