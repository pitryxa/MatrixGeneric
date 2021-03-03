package matrix;

public class TransposeMatrix<T> extends Matrix<T>{

    public TransposeMatrix(Matrix<T> matrix) {
        super(matrix.cols(), matrix.rows());
        this.matrix = transpose(matrix);
    }

    private Object[][] transpose(Matrix<T> matrix) {
        Object[][] data = new Object[rows][cols];
        Object[][] m = matrix.toArray();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = m[j][i];
            }
        }
        return data;
    }
}
