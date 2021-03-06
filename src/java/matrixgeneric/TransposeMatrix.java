package matrixgeneric;

public class TransposeMatrix<T extends Number> extends Matrix<T> {

    public TransposeMatrix(Matrix<T> matrix) {
        super(matrix.cols, matrix.rows);
        this.matrix = transpose(matrix);
    }

    @SuppressWarnings("unchecked")
    protected T[][] transpose(Matrix<T> matrix) {
        T[][] data = (T[][]) new Number[rows][cols];
        T[][] m = matrix.toArray();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = m[j][i];
            }
        }
        return data;
    }
}
