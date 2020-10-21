package e1;

import javax.lang.model.type.NullType;

public class StringUtilities {
    /**
     * Checks if a given string is a valid c of two others . That is , it contains
     * all characters of the other two and order of all characters in the individual
     * strings is preserved .
     *
     * @param a First String to be mixed
     * @param b Second String to be mixed
     * @param c Mix of the two other Strings
     * @return true if the c is valid , false otherwise
     */
    public static boolean isValidMix(String a, String b, String c) {
        int loopA = 0;
        int loopB = 0;
        for (int i = 0; i < (c.length()); i++) {
            if ((loopA < a.length()) && (c.charAt(i) == a.charAt(loopA))) {
                loopA++;
            } else if ((loopB < b.length()) && (c.charAt(i) == b.charAt(loopB))) {
                loopB++;
            }
        }
        return a.length() == loopA && b.length() == loopB && c.length() == loopA + loopB;
    }


    /**
     * Generates a random valid mix for two Strings
     *
     * @param a First String to be mixed
     * @param b Second String to be mixed
     * @return A String that is a random valid mix of the other two .
     */


    public static String generateRandomValidMix(String a, String b) {
        StringBuilder sa = new StringBuilder(a);
        StringBuilder sb = new StringBuilder(b);
        StringBuilder sc = new StringBuilder();
        int loopA = 0;
        int loopB = 0;
        for (int i = 0; i < (sa.length() + sb.length()); i++) {
            if ((Math.random() < 0.5 && loopA < sa.length()) || loopB == sb.length()) {
                sc.insert(i, sa.charAt(loopA));
                loopA = loopA + 1;

            } else {
                sc.insert(i, sb.charAt(loopB));
                loopB = loopB + 1;
            }
        }return sc.toString();
    }
}