package e2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
        //Matrix mat = new Matrix(matrix2);  //POR QUÉ ESTO?
        assertThrows(IllegalArgumentException.class, () -> new Matrix(-1,0,true));
        assertThrows(IllegalArgumentException.class, () -> new Matrix(0,0,true));
        assertThrows(IllegalArgumentException.class, () -> new Matrix(0,-1,true));
        assertThrows(IllegalArgumentException.class, () -> new Matrix(matrix2));
        assertDoesNotThrow(()->new Matrix(1,1,false));
        assertDoesNotThrow(()->new Matrix(matrix1));
    }

    @Test
    void constructorsTest(){ //no sería mejor toString test?
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
        int[] array1 = {4,5,6};
        int[] array2 = {2,5,8};
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
        Matrix ale = new Matrix(matrix1);
        assertEquals(ale.toString(), "[1, 2, 3]\n" + "[4, 5, 6]\n" + "[7, 8, 9]\n");
        ale.setValue(1,1,21);
        assertEquals(ale.toString(), "[1, 2, 3]\n" + "[4, 21, 6]\n" + "[7, 8, 9]\n");
        assertThrows(IllegalArgumentException.class, () -> ale.setValue(0, 3,2));
        assertThrows(IllegalArgumentException.class, () -> ale.setValue(6, 3,2));
    }

    @Test
    void matrixAdditionTest(){
        Matrix mat1 = new Matrix(matrix1);
        Matrix mat2 = new Matrix(matrix1);
        mat1.setIterator(false);
       // MatrixAddition addition = new MatrixAddition(mat1,mat2);
        assertEquals(new MatrixAddition(mat1,mat2).Addition().toString(), "[2, 4, 6]\n" + "[8, 10, 12]\n" + "[14, 16, 18]\n");
        assertEquals(new MatrixAddition(mat2,mat1).Addition().toString(), "[2, 4, 6]\n" + "[8, 10, 12]\n" + "[14, 16, 18]\n");


    }

}
