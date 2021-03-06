package matrix;

public class AdditionMatrix<T extends Number> extends Matrix<T> {

    public AdditionMatrix(Matrix<T> aMatrix, Matrix<T> bMatrix) {
        super(aMatrix.rows, aMatrix.cols);
        if (!validate(aMatrix, bMatrix)) {
            throw new IllegalArgumentException("Both matrices must have the same number of rows and columns.");
        }
        this.matrix = addition(aMatrix, bMatrix);


    }

    @SuppressWarnings("unchecked")
    protected T[][] addition(Matrix<T> aMatrix, Matrix<T> bMatrix) {
        T[][] data = (T[][]) new Number[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = aMatrix.matrix[i][j] + bMatrix.matrix[i][j];
            }
        }
        return data;
    }

    protected boolean validate(Matrix<T> aMatrix, Matrix<T> bMatrix) {
        return aMatrix.rows == bMatrix.rows && aMatrix.cols == bMatrix.cols;
    }
}
