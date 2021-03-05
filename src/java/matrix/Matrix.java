package matrix;

public interface Matrix extends Cloneable{
    public Object[][] toArray();

    public String toString();

    public Object get(int row, int col);

    public void put(int row, int col, Object data);

    public Object[] getRow(int row);

    public Object[] getCol(int col);

    public Matrix clone();

    @Override
    public int hashCode();

    @Override
    public boolean equals(Object o);

    public int size();

    public int rows();

    public int cols();
}
