package e2;


import java.util.Iterator;

public class MatrixAddition {

    private Iterator<Integer> iterator;
    private final Matrix matrix1;
    private final Matrix matrix2;
    private final int row;
    private final int col;
    private final boolean rC;


    public MatrixAddition(Matrix matrix1, Matrix matrix2) {
        this.row = matrix1.getRow();
        this.col = matrix1.getCol();
        if (col != matrix2.getCol() || row != matrix2.getRow()) throw new ArithmeticException();
        this.matrix1 = new Matrix(matrix1);
        this.matrix2 = new Matrix(matrix2);
        this.rC = matrix1.getrC();
        if (matrix1.getrC()!= matrix2.getrC()) this.matrix2.setrC(rC);
    }


    public Matrix Addition() {

        Iterator<Integer> iter1 = matrix1.iterator();
        Iterator<Integer> iter2 = matrix2.iterator();

        Matrix matrixAdd = new Matrix(row, col, rC);
        if (rC) {
            for (int i = 0; i < matrixAdd.getRow(); i++) {
                for (int z = 0; z < matrixAdd.getCol(); z++)
                    matrixAdd.getMatrix()[i][z] = iter1.next() + iter2.next();
            }
        } else {
            for (int i = 0; i < matrixAdd.getCol(); i++) {
                for (int z = 0; z < matrixAdd.getRow(); z++)
                    matrixAdd.getMatrix()[z][i] = iter1.next() + iter2.next();
            }
        }
        return matrixAdd;
    }
}
