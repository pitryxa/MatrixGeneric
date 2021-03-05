package matrix;

import java.util.Random;
import java.util.function.Function;

public class RandomMatrix<T extends Number> extends Matrix<T> {

    public RandomMatrix(Matrix<T> extMatrix, Function<Random, T> creator) {
        super(extMatrix);
        random(creator);
    }

    public RandomMatrix(int rows, int cols, Function<Random, T> creator) {
        super(rows, cols);
        random(creator);
    }

    protected void random(Function<Random, T> creator) {
        Random rnd = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = creator.apply(rnd);
            }
        }
    }
}
