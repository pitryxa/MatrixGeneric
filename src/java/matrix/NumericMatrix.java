package matrix;

public class NumericMatrix extends BaseMatrix{
    public NumericMatrix(Object[][] inputMatrix) {
        super((Number[][])inputMatrix);
    }
}
