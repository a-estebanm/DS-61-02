package e2;

import java.util.Arrays;
import java.lang.Iterable;
import java.util.Iterator;

public class Matrix implements Iterable <Integer>  {

    private int[][] matrix;
    private int row;
    private int col;
    private Iterator <Integer> iterator;
    private final boolean rC;

    public Matrix(int row, int col, boolean rC){
        if(row<=0|| col<=0 ) throw new IllegalArgumentException("Wrong array size, input a positive integer");
        this.row = row;
        this.col = col;
        this.rC=rC;
        matrix = new int[row][col]; //It initializes to all zeroes

        if(rC) this.iterator = new IterateRows(this);
        else this.iterator = new IterateColumns(this);

    }

    public Matrix(int[][] a){ //Le faltaba el iterator y el rC
        if(!isValid(a)) throw new IllegalArgumentException("The inputed matrix isn't valid");
        this.matrix=copyMatrix(a);
        rC = true; //We initialize this matrix to have a RowColumn iterator
        setIterator(rC);

    }

    public void setIterator(boolean rowCol) {
        if (rowCol) this.iterator = new IterateRows(this);
        else this.iterator = new IterateColumns(this);
    }

    public boolean getrC() {
        return rC;
    }

    public Matrix(Matrix a){ //Clone
        this.row = a.row;
        this.col = a.col;
        this.rC=a.rC;
        setIterator(rC);
        this.matrix=copyMatrix(a.matrix);
    }

    public void setMatrix(int[][] matrix) {
        if (!isValid(matrix)) throw new IllegalArgumentException();
        this.matrix = copyMatrix(matrix);
    }

    public Iterator<Integer> iterator() { return iterator; }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int getValue(int row, int col){
        if (row>=this.row||row<0||col>=this.col||col<0) throw new IllegalArgumentException("Incorrect row or column value");
        return matrix[row][col];
    }

    public void setValue(int row, int col, int value){
        if (row>=this.row||row<0||col>=this.col||col<0) throw new IllegalArgumentException("Incorrect row or column value");
        matrix[row][col]=value;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int[][] copyMatrix(int [][] a){ //CREO QUE NOS ESTABAMOS EQUIVOCANDO ROW POR COLUMN AS ALWAYS
        if (!isValid(a)) throw new IllegalArgumentException();
        int [][] copy = new int[a.length][a[0].length];
        for (int i = 0 ; i< a.length;i++){
            System.arraycopy(a[i], 0, copy[i], 0, a[0].length);
        }
        return copy;
    }

    public int[] getRowColumn(int rowCol, boolean row){ //HAY QUE COPIAR Y ESTAMOS DANDO POR REFERENCIA EL ROW O COL ARRAY
        int [] columnArray = new int[this.col];

        if (row){//If you want to get the row
            if (rowCol >= this.row||rowCol<0) throw new IllegalArgumentException("Incorrect row value");
            int[] dest_array = new int[matrix[rowCol].length];
            System.arraycopy(matrix[rowCol],0 , dest_array, 0, matrix[rowCol].length);
            return dest_array;
        }
        if (rowCol >= this.col||rowCol<0) throw new IllegalArgumentException("Incorrect column value");
        for(int i=0; i<matrix[0].length;i++)columnArray[i]=matrix[i][rowCol]; //We insert the numbers of the wanted column into the array
        return columnArray;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(this.matrix).replace("], ","]\n").replace("[[","[").replace("]]","]")+"\n";
    }

    public boolean isValid (int[][] a) {
        int i = 0;
        if (a == null) return false;
        for (int[] ints : a) {
            if (ints == null) return false;
            for (int z : ints) i++;
        }
        if (i == (a[0].length * a.length)) {
            col = a[0].length;
            row = a.length;
            return true;
        }
        return false;
    }


}
