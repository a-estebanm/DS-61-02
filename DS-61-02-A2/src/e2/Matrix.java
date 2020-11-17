package e2;

import java.util.Arrays;
import java.lang.Iterable;
import java.util.Iterator;

public class Matrix implements Iterable <Integer>  {

    private int[][] matrix;
    private int row;
    private int col;
    private Iterator <Integer> iterator;
    //private final boolean rC;

    public Matrix(int row, int col, boolean rC){
        if(row<=0|| col<=0 ) throw new IllegalArgumentException("Wrong array size, input a positive integer");
        this.row = row;
        this.col = col;
        matrix = new int[row][col]; //It initializes to all zeroes

        if(rC) this.iterator = new IterateRows(this);
        else this.iterator = new IterateColumns(this);

    }
    public Matrix(int[][] a){
        if(!isValid(a)) throw new IllegalArgumentException("The inputed matrix isn't valid");
        matrix=a;
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
            if (rowCol>this.row||rowCol<0) throw new IllegalArgumentException("Incorrect row value");
            return matrix[rowCol];
        }
        if (rowCol>this.col||rowCol<0) throw new IllegalArgumentException("Incorrect column value");
        for(int i=0; i<matrix[0].length;i++,columnArray[i]=matrix[i][rowCol]); //We insert the numbers of the wanted column into the array
        return columnArray;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(this.matrix).replace("], ","]\n").replace("[[","[").replace("]]","]");
    }

    public boolean isValid (int[][] a) {//NO FUNCIONA BIEN
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
        mat.matrix[0][0]=1;
        mat.matrix[0][1]=2;
        mat.matrix[1][0]=3;
        mat.matrix[1][1]=4;

        System.out.print(mat.toString());
        System.out.print(mat.iterator().next());
        System.out.print(mat.iterator().next());
        System.out.print(mat.iterator().next());
        System.out.print(mat.iterator().next());
    }


   /*public static boolean isKeypadValid ( char [][] keypad ) {
        int i = 0;
        if (keypad==null) return false;
        char[] result = {'1','2','3','4','5','6','7','8','9','0','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        if (keypad[0].length>1 && keypad[0][1]=='2'){ //Here we check orientation of the sequence (vertical or horizontal)
            for (char[] chars : keypad) {
                if (chars == null) return false;
                for (int col = 0; col < chars.length; col++, i++) {
                    if (chars[col] != result[i]) return false;
                }
            }
            return i == (keypad[0].length * keypad.length); 	// checks if its rectangular
        } else if (keypad[0].length>1 || keypad.length>1){
            for (int col=0; col<keypad[0].length; col++){
                for(int row=0; row< keypad.length; row++,i++) {
                    if (keypad[row]!=null && keypad[row][col]!=result[i]) return false;
                }
            }
            return i == (keypad[0].length * keypad.length);
        } else {
            return keypad[0][0] == '1';//We check that the first element is a 1
        }
    }*/

}
