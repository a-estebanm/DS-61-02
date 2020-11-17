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

    /*
    @Test
    void constructorsTest(){
        Matrix mat = new Matrix(matrix2);
        assertThrows(() -> Matrix(matrix2), IllegalArgumentException.class);
    }
    */
    @Test
    void constructorsTest(){
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
        int[] array = {4,5,6};
        assertArrayEquals(mat.getRowColumn(1, true), array );

        assertThrows(IllegalArgumentException.class, () -> mat.getRowColumn(-1, true));  // incorrect row value
        assertThrows(IllegalArgumentException.class, () -> mat.getRowColumn(5, false));
    }

    @Test
    void getValueTest(){
        Matrix mat = new Matrix(matrix1);
        int val = 4;
        assertEquals( mat.getValue(1,0), val );

    }


}
