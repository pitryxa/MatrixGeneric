import matrix.*;

import java.math.BigDecimal;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Matrix<Integer> matrix = new Matrix<>(new Integer[][] {
                {2, 3, 3},
                {5, 2, 6},
                {9, 0, 4},
                {4, 7, 7}
        });

        Matrix<Integer> otherMatrix = new Matrix<>(new Integer[][] {
                {2, 3, 3},
                {5, 2, 6},
                {9, 0, 4},
                {4, 7, 7}
        });

        Matrix<Integer> transposeMatrix = new TransposeMatrix<>(matrix);

        Matrix<Integer> intMatrix = new RandomMatrix<>(10, 10, rnd -> rnd.nextInt(12) - 5);
        Matrix<Double> doubleMatrix = new RandomMatrix<>(10, 10, rnd -> rnd.nextDouble());

        Matrix<Integer> newMatrix =
                new RandomMatrix<>(
                        new Matrix<>(
                                new Integer[3][4]),
                        Random::nextInt);


        System.out.println(newMatrix);





//        System.out.println(matrix.fillInteger(new Random().ints(matrix.size())));
//        System.out.println(matrix.fillInteger(-5, 7));
//        System.out.println(matrix.transpose().toString());

//        Random random = new Random(1);
//        random.



    }
}
