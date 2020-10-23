package e2;

public class Code {

    /**
     * Determines whether a keypad is valid . To do this , it must be a rectangle and
     * the numbers must follow the alphanumeric sequence indicated . If the array
     * (or any of its subarrays ) is null it will be returned false .
     * @param keypad The keypad to be analyzed .
     * @return true if it is valid , false otherwise .
     */

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

    /**
     * Checks if an array of movements is valid when obtaining a key on a keypad .
     * An array of movements is valid if it is formed by Strings that only have the
     * four capital letters U, D, L and R. If the array of Strings or any of the
     * Strings is null it will be returned false .
     * @param movements Array of Strings representing movements .
     * @return true if it is valid , false otherwise .
     */
    public static boolean areMovementsValid ( String [] movements ) {
        if (movements==null) return false;
        for (String movement : movements) {
            if (movement==null||movement.isEmpty())return false;
            for (int x = 0; x < movement.length(); x++) {
                if (movement.charAt(x) != 'L' && movement.charAt(x) != 'D' && movement.charAt(x) != 'R' && movement.charAt(x) != 'U') return false;
            }

        }
        return true;
    }

    /**
     * Given a keypad and an array of movements , it returns a String with the code
     * resulting from applying the movements on the keypad .
     * @param keypad alphanumeric keypad .
     * @param movements Array with the different movements to be made for each

    number of the key .

     * @return Resulting code .
     * @throws IllegalArgumentException if the keypad of the movements are invalid .
     */
    public static String obtainCode ( char [][] keypad , String [] movements ) {
        if (!isKeypadValid(keypad) || !areMovementsValid(movements)) throw new IllegalArgumentException();
        int codeLength = 0;
        int row = 0;
        int col = 0;
        StringBuilder code = new StringBuilder() ;
        for (String movement : movements) {
            for (int atLetter = 0; atLetter < movement.length(); atLetter++) {
                char c = movement.charAt(atLetter);
                if (c=='D') row++;
                else if (c=='U') row--;
                else if (c=='R') col++;
                else if (c=='L') col--;
                if (row >= keypad.length) row = keypad.length - 1;
                else if (row < 0) row = 0;
                else if (col >= keypad[0].length) col = keypad[0].length -1;
                else if (col < 0) col = 0;
                if (keypad.length == 1 && keypad[0].length == 1){                   	// in case there is only 1 element
                    row = 0;
                    col = 0;
                }
            }
            code.insert(codeLength, keypad[row][col]);
            codeLength++;
        }
        return code.toString();
    }
}
