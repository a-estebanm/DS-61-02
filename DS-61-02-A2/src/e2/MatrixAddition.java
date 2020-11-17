package e2;

import java.util.Arrays;
import java.lang.Iterable;
import java.util.Iterator;

public class MatrixAddition implements Iterable <Integer> {

    private Iterator <Integer> iterator;
    private final int[][] matrix1;
    private final int[][] matrix2;
    int row;
    int col;

    public MatrixAddition (Matrix matrix1, Matrix matrix2){
        this.matrix1 = matrix1.getMatrix();
        this.matrix2 = matrix2.getMatrix();
        this.row =
    }

    public Iterator<Integer> iterator() { return iterator; }

    public Matrix Addition(Matrix matrix1, Matrix matrix2){

        Matrix matrixAdd;


        if(matrix1.getCol()!=matrix2.getCol() || matrix1.getRow()!=matrix2.getRow())
            throw new ArithmeticException();

        for (Integer t : matrix1) {
            for (Integer p : matrix1) {
                matrixAdd.getMatrix()[t][p]=

            }

        }
        return matrixAdd;
    }
}
