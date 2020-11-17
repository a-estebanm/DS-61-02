package e2;

import java.util.Arrays;
import java.lang.Iterable;
import java.util.Iterator;

public class MatrixAddition {

    private Iterator<Integer> iterator;
    private final Matrix matrix1;
    private final Matrix matrix2;
    private int row;
    private int col;
    private final boolean rC;


    public MatrixAddition(Matrix matrix1, Matrix matrix2) {
        this.row = matrix1.getRow();
        this.col = matrix1.getCol();
        if (col != matrix2.getCol() || row != matrix2.getRow()) throw new ArithmeticException();
        this.matrix1 = new Matrix(matrix1);
        this.matrix2 = new Matrix(matrix2);
        if (matrix1.iterator() != matrix2.iterator()) this.matrix2.setIterator(matrix1.getrC());
        this.rC = matrix1.getrC();
    }


    public Matrix Addition() {

        Matrix matrixAdd = new Matrix(row, col, rC);
        if (rC) {
            for (int i = 0; i < matrixAdd.getRow(); i++) {
                for (int z = 0; z < matrixAdd.getCol(); z++)
                    matrixAdd.getMatrix()[i][z] = matrix1.iterator().next() + matrix2.iterator().next();
            }
        } else {
            for (int i = 0; i < matrixAdd.getCol(); i++) {
                for (int z = 0; z < matrixAdd.getRow(); z++)
                    matrixAdd.getMatrix()[z][i] = matrix1.iterator().next() + matrix2.iterator().next();
            }
        }
        return matrixAdd;
    }
}
