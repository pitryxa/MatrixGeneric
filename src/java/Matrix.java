public class Matrix<T> {
    private final int rows;
    private final int cols;
    private final Object[][] matrix;

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

    public T get(int row, int col) {
        return (T) this.matrix[row][col];
    }

    public T[] getRow(int row) {
        return (T[]) this.matrix[row];
    }

    public T[] getCol(int col) {
        Object[] data = new Object[this.rows];
        for (int i = 0; i < this.rows; i++) {
            data[i] = this.matrix[i][col];
        }
        return (T[]) data;
    }

    public Matrix<T> transpose() {
        Object[][] data = new Object[this.cols][this.rows];
        for (int i = 0; i < this.cols; i++) {
            for (int j = 0; j < this.rows; j++) {
                data[i][j] = this.matrix[j][i];
            }
        }
        return new Matrix<>(data);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.rows; i++) {
            if (i != 0)
                sb.append(" ");
            sb.append("[");
            for (int j = 0; j < this.cols; j++) {
                sb.append(matrix[i][j]);
                if (j != this.cols - 1)
                    sb.append(", ");
            }
            sb.append("]");
            if (i != this.rows - 1)
                sb.append(",\n");
            else
                sb.append("]\n");
        }
        return sb.toString();
    }
}

