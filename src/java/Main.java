import matrix.*;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = new NumericMatrix(new Integer[][] {
                {2, 3, 3},
                {5, 2, 6},
                {9, 0, 4},
                {4, 7, 7}
        });

        Matrix otherMatrix = new ObjectMatrix(new Integer[][] {
                {2, 3, 3},
                {5, 2, 6},
                {9, 0, 4},
                {4, 7, 7}
        });

        Matrix transposeMatrix = new TransposeMatrix(matrix);

        System.out.println(matrix.get(0, 0) * 5);



//        System.out.println(matrix.fillInteger(new Random().ints(matrix.size())));
//        System.out.println(matrix.fillInteger(-5, 7));
//        System.out.println(matrix.transpose().toString());

//        Random random = new Random(1);
//        random.



    }
}
