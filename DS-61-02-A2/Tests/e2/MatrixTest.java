package e2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MatrixTest {
    public static int[][] matrix1
            = {{1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}};

    public static int[][] matrix2
            = {{1, 2, 3},
            {4, 5},
            {7, 8, 9}};

    public static int[][] matrix3
            = {{1, 2, 3},
            null,
            {7, 8, 9}};

    public static int[][] matrix4
            = null;

    public static int[][] matrix5
            = {{1, 2},
            {4, 5},
            {7, 8}};

    public static int[][] matrix6
            = {{1, 2, 3, 4, 5, 6}};

    public static int[][] matrix7
            = {{1},
            {4},
            {7}};

    public static int[][] matrix8
            = {{1}};


    @Test
    void isValidTest(){

        Matrix mat = new Matrix(2,2, true);
        mat.getMatrix()[0][0]=2;
        mat.getMatrix()[0][1]=3;
        mat.getMatrix()[1][0]=1;
        mat.getMatrix()[1][1]=1;
        assertTrue(mat.isValid(mat.getMatrix()));

        assertTrue(mat.isValid(matrix1));
        assertTrue(mat.isValid(matrix5));
        assertTrue(mat.isValid(matrix6));
        assertTrue(mat.isValid(matrix7));
        assertTrue(mat.isValid(matrix8));

        assertFalse(mat.isValid(matrix2));
        assertFalse(mat.isValid(matrix3));
        assertFalse(mat.isValid(matrix4));
    }


    @Test
    void constructorsTestExceptions(){

        assertThrows(IllegalArgumentException.class, () -> new Matrix(-1,0,true));
        assertThrows(IllegalArgumentException.class, () -> new Matrix(0,0,true));
        assertThrows(IllegalArgumentException.class, () -> new Matrix(0,-1,true));
        assertThrows(IllegalArgumentException.class, () -> new Matrix(matrix2));
        assertThrows(IllegalArgumentException.class, () -> new Matrix(matrix3));
        assertDoesNotThrow(()->new Matrix(1,1,false));
        assertDoesNotThrow(()->new Matrix(matrix1));
    }

    @Test
    void toStringTest(){

        Matrix mat = new Matrix(matrix1);
        assertEquals(mat.toString(), "[1, 2, 3]\n" + "[4, 5, 6]\n" + "[7, 8, 9]\n");

        Matrix mat1 = new Matrix(matrix5);
        assertEquals(mat1.toString(), "[1, 2]\n" + "[4, 5]\n" + "[7, 8]\n");

        Matrix mat2 = new Matrix(matrix8);
        assertEquals(mat2.toString(), "[1]\n");

    }

    @Test
    void getRowColumnTest(){
        Matrix mat = new Matrix(matrix1);
        int[] array1 = {4,5,6};                                            //cambiando los 5 por 21 funcionaria
        int[] array2 = {2,5,8};                                            //hace primero el setvalue a 21 cuando se hace el test general
        assertArrayEquals(mat.getRowColumn(1, true), array1 ); 
        assertArrayEquals(mat.getRowColumn(1, false), array2 ); 

        assertThrows(IllegalArgumentException.class, () -> mat.getRowColumn(-1, true));  // incorrect row value
        assertThrows(IllegalArgumentException.class, () -> mat.getRowColumn(5, false));
    }

    @Test
    void getValueTest(){
        Matrix mat = new Matrix(matrix1);
        int val = 4;
        assertEquals( mat.getValue(1,0), val );
        assertThrows(IllegalArgumentException.class, () -> mat.getValue(0, 3));
        assertThrows(IllegalArgumentException.class, () -> mat.getValue(6, 2));
    }

    @Test
    void setValueTest(){
        Matrix mat = new Matrix(matrix1);
        assertEquals(mat.toString(), "[1, 2, 3]\n" + "[4, 5, 6]\n" + "[7, 8, 9]\n");
        mat.setValue(1,1,21);
        assertEquals(mat.toString(), "[1, 2, 3]\n" + "[4, 21, 6]\n" + "[7, 8, 9]\n");
        assertThrows(IllegalArgumentException.class, () -> mat.setValue(0, 3,2));
        assertThrows(IllegalArgumentException.class, () -> mat.setValue(6, 3,2));
    }

    @Test
    void copyTest(){
        Matrix mat = new Matrix(matrix1);   // con la 1 va pero con alguna otra no (5,6,...)
        int[][] copy =  mat.copyMatrix(matrix1);
        assertArrayEquals(matrix1, copy);
    }

    @Test
    void matrixAdditionTest(){
        Matrix mat1 = new Matrix(matrix1);
        Matrix mat2 = new Matrix(matrix1);
        //MatrixAddition addition = new MatrixAddition(mat1,mat2);
        assertEquals(new MatrixAddition(mat1,mat2).Addition().toString(), "[2, 4, 6]\n" + "[8, 10, 12]\n" + "[14, 16, 18]\n");
        assertEquals(new MatrixAddition(mat2,mat1).Addition().toString(), "[2, 4, 6]\n" + "[8, 10, 12]\n" + "[14, 16, 18]\n");

        Matrix mat3 = new Matrix(3,3, false);
        mat3.setMatrix(matrix1);
        assertEquals(new MatrixAddition(mat3,mat2).Addition().toString(), "[2, 4, 6]\n" + "[8, 10, 12]\n" + "[14, 16, 18]\n");
        assertEquals(new MatrixAddition(mat3,mat1).Addition().toString(), "[2, 4, 6]\n" + "[8, 10, 12]\n" + "[14, 16, 18]\n");

    }

    @Test
    void iteratorsTest(){
        Matrix mat = new Matrix(matrix1);
        Iterator<Integer> iter1 = mat.columnRowIterator();
        assertEquals(1, iter1.next());
        assertEquals(4, iter1.next());
        assertEquals(7, iter1.next());
        assertEquals(2, iter1.next());
        assertThrows(UnsupportedOperationException.class, iter1::remove);

        Matrix mat2 = new Matrix(matrix8);  // 1 element
        Iterator<Integer> iter2 = mat2.columnRowIterator();
        assertEquals(1, iter2.next());
        assertThrows(NoSuchElementException.class, iter2::next);

        Matrix mat3 = new Matrix(matrix1);
        Iterator<Integer> iter3 = mat3.iterator();
        assertEquals(1, iter3.next());
        assertEquals(2, iter3.next());
        assertEquals(3, iter3.next());
        assertEquals(4, iter3.next());
        assertThrows(UnsupportedOperationException.class, iter3::remove);

        Matrix mat4 = new Matrix(matrix8);  // 1 element
        Iterator<Integer> iter4 = mat4.iterator();
        assertEquals(1, iter4.next());
        assertThrows(NoSuchElementException.class, iter4::next);

    }
}
