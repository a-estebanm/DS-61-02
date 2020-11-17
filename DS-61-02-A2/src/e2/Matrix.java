package e2;

import java.util.Arrays;
import java.lang.Iterable;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Matrix implements Iterable <Integer>  {

    private int[][] matrix;
    private int row;
    private int col;
    private Iterator <Integer> iterator;
    private boolean rC;

    public Matrix(int row, int col, boolean rC){
        if(row<=0|| col<=0 ) throw new IllegalArgumentException("Wrong array size, input a positive integer");
        this.row = row;
        this.col = col;
        this.rC=rC;
        matrix = new int[row][col]; //It initializes to all zeroes

        if(rC) this.iterator = new IterateRows(this);
        else this.iterator = new IterateColumns(this);

    }

    public void setIterator(boolean rowCol) {
        if (rowCol) this.iterator = new IterateRows(this);
        else this.iterator = new IterateColumns(this);
    }

    public Matrix(int[][] a){
        if(!isValid(a)) throw new IllegalArgumentException("The inputed matrix isn't valid");
        matrix=a;
    }
    public boolean getrC() {
        return rC;
    }

    public Matrix(Matrix a){ //Clone
        this.row = a.row;
        this.col = a.col;
        this.rC=a.rC;
        setIterator(rC);
        this.matrix=a.matrix;
    }

    public Iterator<Integer> iterator() { return iterator; }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int getValue(int row, int col){
        if (row>this.row||row<0||col>this.col||col<0) throw new IllegalArgumentException("Incorrect row or column value");
        return matrix[row][col];
    }
    public void setValue(int row, int col, int value){
        if (row>this.row||row<0||col>this.col||col<0) throw new IllegalArgumentException("Incorrect row or column value");
        matrix[row][col]=value;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int[] getRowColumn(int rowCol, boolean row){
        int [] columnArray = new int[this.col];
        if (row){//If you want to get the row
            if (rowCol >= this.row||rowCol<0) throw new IllegalArgumentException("Incorrect row value");
            return matrix[rowCol];
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
            row = a[0].length;
            col = a.length;
            return true;
        }
        return false;
    }

    public static void main(String[] args){

        Matrix mat = new Matrix(2,2, true);
        mat.matrix[0][0]=2;
        mat.matrix[0][1]=3;
        mat.matrix[1][0]=1;
        mat.matrix[1][1]=1;
        Matrix mat2 = new Matrix(2,2, true);
        mat2.matrix[0][0]=4;
        mat2.matrix[0][1]=2;
        mat2.matrix[1][0]=1;
        mat2.matrix[1][1]=1;

        System.out.print(mat.toString()+"\n");
        System.out.print(mat2.toString()+"\n");
        System.out.print(mat2.iterator().getClass().getSimpleName()+"\n");
        System.out.print( new  MatrixAddition(mat,mat2).Addition());
        System.out.print( new  MatrixAddition(mat,mat2).Addition());
        System.out.print(mat2.iterator().next()+"\n");
        System.out.print(mat2.iterator().next()+"\n");
        System.out.print( new  MatrixAddition(mat,mat2).Addition());
        System.out.print( new  MatrixAddition(mat,mat2).Addition());


        System.out.print(mat2.iterator().getClass().getSimpleName()+"\n");
        System.out.print(mat2.getRowColumn(1,true));



    }
}
