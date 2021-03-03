import matrix.Matrix;
import matrix.TransposeMatrix;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Matrix<Integer> matrix = new Matrix<>(new Integer[][] {
                {2, 3, 3},
                {5, 2, 6},
                {9, 0, 4},
                {4, 7, 7}
        });

        Matrix<Integer> transposeMatrix = new TransposeMatrix<>(matrix);
        System.out.println(transposeMatrix);



//        System.out.println(matrix.fillInteger(new Random().ints(matrix.size())));
//        System.out.println(matrix.fillInteger(-5, 7));
//        System.out.println(matrix.transpose().toString());

//        Random random = new Random(1);
//        random.



    }
}
