package e2;

public class Matrix {

    int[][] matrix;
    private int row;
    private int col;

    public Matrix(int row, int col){
        if(row<=0|| col<=0 ) throw new IllegalArgumentException("Wrong array size, input a positive integer");
        this.row=row;
        this.col=col;
        matrix = new int[row][col]; //It initializes to all zeroes
    }
    public Matrix(int[][] a){
        if(!isValid(a)) throw new IllegalArgumentException("The inputed matrix isn't valid");
        matrix=a;
    }

    public boolean isValid ( int[][] a) {
        int i = 0;
        if (a == null) return false;
        for (int[] ints : a) {
            if (ints == null) return false;
            if (i == (a[0].length * a.length)) {
                row = a[0].length;
                col = a.length;
                return true;
            }
        }
    }
    public static void main(String[] args){

    int[][] mat = new int[2][3];
    mat[0][1]=3;
    mat[0]=null;
        mat[0][1]=3;
    System.out.print(mat[0][1]);

    }

    public static boolean isKeypadValid ( char [][] keypad ) {
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
    }

}
